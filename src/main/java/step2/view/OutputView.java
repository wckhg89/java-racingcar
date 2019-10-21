package step2.view;

import step2.Car;

import java.util.List;

public class OutputView {

    private static final String COS_LINE = "-";

    public void print (List<Car> cars) {
        System.out.println("실행 결과");

        for (Car car : cars){
            System.out.println(printCarCos(car.getPosition()));
        }
    }

    private String printCarCos (int carPosition) {
        StringBuilder cos = new StringBuilder();

        for (int i = 0 ; i < carPosition ; i++) {
            cos.append(COS_LINE);
        }

        return cos.toString();
    }
}
