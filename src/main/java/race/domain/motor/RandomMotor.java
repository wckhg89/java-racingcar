package race.domain.motor;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMotor implements Motor {

    private static final int BOUND = 10;
    private static final Random random = ThreadLocalRandom.current();

    @Override
    public int move() {
        return random.nextInt(BOUND);
    }
}
