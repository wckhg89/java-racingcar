package step2.engine;

import step2.Car;
import step2.Round;

import java.util.*;


public class RacingGame {

    private int time;
    private List<Round> rounds;


    public static RacingGame initGame(int time, int participantRacer) {
        RacingGame racingGame = new RacingGame(time);
        racingGame.initRound(participantRacer);

        return racingGame;
    }

    private RacingGame(int time) {
        this.time = time;
    }

    private void initRound (int participantRacer) {
        rounds = new ArrayList<>();

        for (int attempt = 0; attempt < time; attempt++) {
            rounds.add(new Round(attempt, participantRacer));
        }
    }

    public void startGame() {
        for (Round round : rounds) {
            cycle(round);
        }
    }

    private void cycle(Round round) {
        final int bound = 10;

        for (Car car : round.getCars()) {
            car.move(new Random().nextInt(bound));
        }
    }

    public List<Round> getRounds() {
        return rounds;
    }
}
