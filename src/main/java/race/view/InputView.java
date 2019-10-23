package race.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {


    private static final String RACER_REGEX = ",";

    private List<String> racer;
    private int time;

    public void inputRacer (String racers) {
        racer = Arrays.stream(racers.split(RACER_REGEX))
                .collect(Collectors.toList());
    }

    public void inputTime (int time) {
        this.time = time;
    }

    public List<String> getRacer() {
        return racer;
    }

    public int getTime() {
        return time;
    }
}
