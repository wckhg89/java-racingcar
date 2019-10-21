package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        final int RACER_NUM = 0;

        // Given
        int pos = 1;
        Car racer = Car.init(RACER_NUM);

        // When
        racer.move(pos);

        // Then
        assertThat(racer.getPosition()).isEqualTo(1);
    }

    @Test
    void notMove() {
        final int RACER_NUM = 0;

        // Given
        int pos = 4;
        Car racer = Car.init(RACER_NUM);

        // When
        racer.move(pos);

        // Then
        assertThat(racer.getPosition()).isEqualTo(0);
    }
}