package step2.view;

import step2.Car;

import java.util.List;

public class OutputView {

    private final String NAME_SPLIT= " : ";
    private static final String COS_LINE = "-";
    private static final String NEW_LINE = "\n";

    public String print(List<Car> cars) {
        StringBuilder result = new StringBuilder();

        for (Car car : cars) {
            result.append(car.getName()).append(NAME_SPLIT).append(printCarCos(car.getPosition())).append(NEW_LINE);
        }

        return result.toString();
    }

    private String printCarCos(int carPosition) {
        StringBuilder cos = new StringBuilder();

        for (int i = 0; i < carPosition; i++) {
            cos.append(COS_LINE);
        }

        return cos.toString();
    }
}
