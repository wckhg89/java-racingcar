package race.engine;

import org.junit.jupiter.api.Test;
import race.domain.Car;
import race.domain.motor.RandomMotor;
import race.domain.motor.SpecificMotor;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class RacingGameTest {

    @Test
    void initGame() {
        // Given
        int time = 1;
        Car guppy = Car.init("guppy", new RandomMotor());
        Car gaemi = Car.init("honggu", new RandomMotor());
        Car cinabro = Car.init("woowabros", new RandomMotor());

        ArrayList<Car> participants = newArrayList(guppy, gaemi, cinabro);

        // When
        RacingGame racingGame = RacingGame.initGame(time, participants);

        // Then
        assertThat(racingGame.getRounds().get(0).getCars()).hasSize(3);
        assertThat(racingGame.getRounds().get(0).getCars().get(0).getName()).isEqualTo("guppy");
        assertThat(racingGame.getRounds().get(0).getCars().get(1).getName()).isEqualTo("honggu");
        assertThat(racingGame.getRounds().get(0).getCars().get(2).getName()).isEqualTo("woowabros");
    }

    @Test
    void startGame() {
        // Given
        int time = 1;
        Car guppy = Car.init("guppy", new RandomMotor());
        Car gaemi = Car.init("gaemi", new RandomMotor());
        Car cinabro = Car.init("cinabro", new RandomMotor());

        ArrayList<Car> participants = newArrayList(guppy, gaemi, cinabro);

        // When
        RacingGame racingGame = RacingGame.initGame(time, participants);
        racingGame.startGame();

        // Then
        assertThat(racingGame.getRounds().get(0).getCars().get(0).getPosition()).isBetween(0, 4);
        assertThat(racingGame.getRounds().get(0).getCars().get(1).getPosition()).isBetween(0, 4);
        assertThat(racingGame.getRounds().get(0).getCars().get(2).getPosition()).isBetween(0, 4);
    }


    @Test
    void finishGame() {
        // Given
        int time = 2;
        Car guppy = Car.init("guppy", new SpecificMotor(1));
        Car gaemi = Car.init("gaemi", new SpecificMotor(2));
        Car cinabro = Car.init("cinabro", new SpecificMotor(4));

        ArrayList<Car> participants = newArrayList(guppy, gaemi, cinabro);

        // When
        RacingGame racingGame = RacingGame.initGame(time, participants);
        racingGame.startGame();

        // Then
        assertThat(racingGame.finishGame()).isEqualTo("cinabro");
    }
}