package race.view;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import race.domain.Car;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

class OutputViewTest {



    @Test
    void print() {
        String EXPECTED_RESULT = "guppy : -\n"+ "honggu : --\n"+ "woowabros : ---\n";

        // Given
        Car racer0 = Car.init("guppy");
        Car racer1 = Car.init("honggu");
        Car racer2 = Car.init("woowabros");

        racer0.move(1);
        racer1.move(2);
        racer2.move(3);

        ArrayList<Car> cars = Lists.newArrayList(racer0, racer1, racer2);

        // When
        OutputView outputView = new OutputView();

        // Then
        assertThat(outputView.print(cars)).isEqualTo(EXPECTED_RESULT);
    }
}
