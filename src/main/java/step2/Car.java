package step2;

public class Car {

    private final int LIMIT_ENABLE_MOVE_POSITION = 4;

    private String name;
    private int position;

    public static Car init (int participantNum) {
        final String NAME_PREFIX = "racer";
        return new Car(NAME_PREFIX + participantNum);
    }

    private Car(String name) {
        this.name = name;
    }

    public void move (int pos) {
        if (pos > LIMIT_ENABLE_MOVE_POSITION) {
            return;
        }

        this.position = pos;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
