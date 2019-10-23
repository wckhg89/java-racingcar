package race.domain.motor;

public class SpecificMotor implements Motor {

    private int specificPosition;

    public SpecificMotor(int specificPosition) {
        this.specificPosition = specificPosition;
    }

    @Override
    public int move() {
        return specificPosition;
    }
}
