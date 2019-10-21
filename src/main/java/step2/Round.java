package step2;

import java.util.List;
import java.util.stream.Collectors;

public class Round {

    private int round;
    private List<Car> cars;

    public static Round initRound (int round, List<String> participants) {
        return new Round(round, participants);
    }

    private Round(int round, List<String> participants) {
        this.round = round;
        this.enrollRacer(participants);
    }

    private void enrollRacer(List<String> participants) {
        this.cars = participants.stream()
                .map(Car::init)
                .collect(Collectors.toList());
    }

    public int getRound() {
        return round;
    }

    public List<Car> getCars() {
        return cars;
    }
}
