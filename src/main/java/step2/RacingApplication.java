package step2;

import step2.engine.RacingGame;
import step2.view.InputView;
import step2.view.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = input();

        RacingGame racingGame = startGame(inputView);

        printResult(racingGame);
    }

    private static InputView input() {
        InputView inputView = new InputView();

        System.out.println("자동차 대수는 몇 대 인가요?");
        inputView.inputRacer();

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputView.inputTime();

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
            outputView.print(round.getCars());
        }
    }

}
