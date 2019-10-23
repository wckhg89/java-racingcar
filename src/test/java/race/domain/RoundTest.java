package race.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import race.domain.motor.SpecificMotor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RoundTest {

    @Test
    void extractWinner_단일승자() {
        // Given
        Car guppy = Car.init("guppy", new SpecificMotor(1));
        Car gaemi = Car.init("gaemi", new SpecificMotor(4));
        Car cinabro = Car.init("cinabro", new SpecificMotor(1));

        Round round1 = Round.initRound(1, Lists.newArrayList( guppy, gaemi, cinabro));

        // When
        round1.getCars().get(0).move();
        round1.getCars().get(1).move();
        round1.getCars().get(2).move();

        List<String> winners = round1.extractWinner();

        // Then
        assertThat(winners).hasSize(1);
        assertThat(winners).contains("gaemi");
    }

    @Test
    void extractWinner_복수승자() {
        // Given
        Car guppy = Car.init("guppy", new SpecificMotor(4));
        Car gaemi = Car.init("gaemi", new SpecificMotor(4));
        Car cinabro = Car.init("cinabro", new SpecificMotor(1));

        Round round1 = Round.initRound(1, Lists.newArrayList(guppy, gaemi, cinabro));

        // When
        round1.getCars().get(0).move();
        round1.getCars().get(1).move();
        round1.getCars().get(2).move();

        List<String> winners = round1.extractWinner();

        // Then
        assertThat(winners).hasSize(2);
        assertThat(winners).contains("guppy");
        assertThat(winners).contains("gaemi");
    }
}