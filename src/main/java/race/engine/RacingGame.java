package race.engine;

import race.domain.Car;
import race.domain.Round;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.joining;


public class RacingGame {

    private int time;
    private List<Round> rounds;


    public static RacingGame initGame(int time, List<Car> participant) {
        RacingGame racingGame = new RacingGame(time);
        racingGame.initRound(participant);

        return racingGame;
    }

    private RacingGame(int time) {
        this.time = time;
    }

    private void initRound (List<Car> participant) {
        rounds = new ArrayList<>();

        for (int round = 0; round < time; round++) {
            rounds.add(Round.initRound(round, participant));
        }
    }

    public void startGame() {
        rounds.forEach(this::cycle);
    }

    public String finishGame () {
        return this.rounds.stream()
                .map(Round::extractWinner)
                .flatMap(Collection::stream)
                .distinct()
                .collect(joining(","));
    }

    public List<Round> getRounds() {
        return rounds;
    }

    private void cycle(Round round) {
        round.getCars().forEach(Car::move);
    }
}
