package race.view;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import race.domain.Car;
import race.domain.motor.RandomMotor;
import race.domain.motor.SpecificMotor;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

class OutputViewTest {



    @Test
    void print() {
        String EXPECTED_RESULT = "guppy : -\n"+ "honggu : --\n"+ "woowabros : ---\n";

        // Given
        Car racer0 = Car.init("guppy", new SpecificMotor(1));
        Car racer1 = Car.init("honggu", new SpecificMotor(2));
        Car racer2 = Car.init("woowabros", new SpecificMotor(3));

        racer0.move();
        racer1.move();
        racer2.move();

        ArrayList<Car> cars = Lists.newArrayList(racer0, racer1, racer2);

        // When
        OutputView outputView = new OutputView();

        // Then
        assertThat(outputView.print(cars)).isEqualTo(EXPECTED_RESULT);
    }
}
