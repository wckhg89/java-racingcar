package step2.view;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import step2.Car;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void print() {
        // Given
        Car racer0 = Car.init(0);
        Car racer1 = Car.init(1);
        Car racer2 = Car.init(2);


        racer0.move(1);
        racer1.move(2);
        racer2.move(3);

        ArrayList<Car> cars = Lists.newArrayList(racer0, racer1, racer2);

        // When
        OutputView outputView = new OutputView();

        // Then
        outputView.print(cars);
    }
}