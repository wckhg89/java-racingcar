package step2;

import step2.engine.RacingGame;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.Scanner;

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
        RacingGame racingGame = RacingGame.initGame(inputView.getTime(), inputView.getRacer());
        racingGame.startGame();
        return racingGame;
    }

    private static void printResult(RacingGame racingGame) {
        OutputView outputView = new OutputView();

        System.out.println("실행 결과");
        for (Round round : racingGame.getRounds()) {
            System.out.println(outputView.print(round.getCars()));
        }
    }

}
