package race.view;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {


    @Test
    void inputRacer() {
        // Given
        InputView inputView = new InputView();
        String racers = "guppy,honggu,woowabros";

        // When
        inputView.inputRacer(racers);

        // Then
        assertThat(inputView.getRacer()).hasSize(3);
        assertThat(inputView.getRacer().get(0)).isEqualTo("guppy");
        assertThat(inputView.getRacer().get(1)).isEqualTo("honggu");
        assertThat(inputView.getRacer().get(2)).isEqualTo("woowabros");

    }

    @Test
    void inputTime() {
        // Given
        InputView inputView = new InputView();
        int time = 1;

        // When
        inputView.inputTime(time);

        // Then
        assertThat(inputView.getTime()).isEqualTo(1);
    }
}