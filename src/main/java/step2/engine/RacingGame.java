package step2.engine;

import step2.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * 초간단 자동차 경주 게임을 구현한다.
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 * */


/**
 * 자동차 대수는 몇 대 인가요?
 * 3
 * 시도할 회수는 몇 회 인가요?
 * 5
 * <p>
 * 실행 결과
 * -
 * -
 * -
 * <p>
 * --
 * -
 * --
 */
public class RacingGame {

    private int time;
    private List<Car> cars;

    public static RacingGame initGame(int time, int participantRacer) {
        RacingGame racingGame = new RacingGame(time);
        racingGame.enrollRacer(participantRacer);

        return racingGame;
    }

    private RacingGame(int time) {
        this.time = time;
    }

    private void enrollRacer(int participantRacer) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < participantRacer; i++) {
            cars.add(Car.init(i));
        }

    }

    public void startGame() {
        for (int attempt = 0; attempt < time; attempt++) {
            cycle();
        }
    }

    private void cycle() {
        final int bound = 10;

        for (Car car : cars) {
            car.move(new Random().nextInt(bound));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
