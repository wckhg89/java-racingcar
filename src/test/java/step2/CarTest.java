package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        final String RACER = "guppy";

        // Given
        int pos = 1;
        Car racer = Car.init(RACER);

        // When
        racer.move(pos);

        // Then
        assertThat(racer.getPosition()).isEqualTo(1);
    }

    @Test
    void notMove() {
        final String RACER = "guppy";

        // Given
        int pos = 5;
        Car racer = Car.init(RACER);

        // When
        racer.move(pos);

        // Then
        assertThat(racer.getPosition()).isEqualTo(0);
    }
}