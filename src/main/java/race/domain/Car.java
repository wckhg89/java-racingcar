package race.domain;

public class Car {

    private final int LIMIT_ENABLE_MOVE_POSITION = 4;

    private String name;
    private int position;

    public static Car init (String participant) {
        return new Car(participant);
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
