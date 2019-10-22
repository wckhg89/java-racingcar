package race.engine;

import race.domain.Car;
import race.domain.Round;

import java.util.*;


public class RacingGame {

    private int time;
    private List<Round> rounds;


    public static RacingGame initGame(int time, List<String> participant) {
        RacingGame racingGame = new RacingGame(time);
        racingGame.initRound(participant);

        return racingGame;
    }

    private RacingGame(int time) {
        this.time = time;
    }

    private void initRound (List<String> participant) {
        rounds = new ArrayList<>();

        for (int round = 0; round < time; round++) {
            rounds.add(Round.initRound(round, participant));
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
