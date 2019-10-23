package race.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Round {

    private int round;
    private List<Car> cars;

    public static Round initRound(int round, List<Car> cars) {
        return new Round(round, cars);
    }

    private Round(int round, List<Car> cars) {
        this.round = round;
        this.cars = cars;
    }

    public int getRound() {
        return round;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> extractWinner() {
        int maxPosition = this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(1);

        return this.cars.stream()
                .filter(it -> it.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
