package race;

import race.domain.Car;
import race.domain.Round;
import race.domain.motor.RandomMotor;
import race.engine.RacingGame;
import race.view.InputView;
import race.view.OutputView;

import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingApplication {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InputView inputView = input();

        RacingGame racingGame = startGame(inputView);

        printResult(racingGame);
    }

    private static InputView input() {
        InputView inputView = new InputView();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputView.inputRacer(scanner.nextLine());

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputView.inputTime(scanner.nextInt());

        return inputView;
    }

    private static RacingGame startGame(InputView inputView) {
        RacingGame racingGame = RacingGame.initGame(inputView.getTime(), inputView.getRacer().stream()
                .map(it -> Car.init(it, new RandomMotor()))
                .collect(Collectors.toList()));

        racingGame.startGame();
        return racingGame;
    }

    private static void printResult(RacingGame racingGame) {
        OutputView outputView = new OutputView();

        System.out.println("실행 결과");
        for (Round round : racingGame.getRounds()) {
            System.out.println(outputView.print(round.getCars()));
        }

        System.out.println(racingGame.finishGame());
    }

}
