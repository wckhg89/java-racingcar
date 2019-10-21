package step2;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private int round;
    private List<Car> cars;

    public Round(int round, int participant) {
        this.round = round;
        this.enrollRacer(participant);
    }

    private void enrollRacer(int participantRacer) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < participantRacer; i++) {
            cars.add(Car.init(i));
        }
    }

    public int getRound() {
        return round;
    }

    public List<Car> getCars() {
        return cars;
    }
}
