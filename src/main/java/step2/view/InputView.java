package step2.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    private int racer;
    private int time;

    public void inputRacer () {
        racer = scanner.nextInt();
    }

    public void inputTime () {

        time = scanner.nextInt();
    }

    public int getRacer() {
        return racer;
    }

    public int getTime() {
        return time;
    }
}
