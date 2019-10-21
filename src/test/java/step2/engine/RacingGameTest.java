package step2.engine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void initGame() {
        // Given
        int time = 1;
        int participantRacer = 3;

        // When
        RacingGame racingGame = RacingGame.initGame(time, participantRacer);

        // Then
        assertThat(racingGame.getCars()).hasSize(3);
        assertThat(racingGame.getCars().get(0).getName()).isEqualTo("racer0");
        assertThat(racingGame.getCars().get(1).getName()).isEqualTo("racer1");
        assertThat(racingGame.getCars().get(2).getName()).isEqualTo("racer2");
    }

    @Test
    void startGame() {
        // Given
        int time = 1;
        int participantRacer = 3;

        // When
        RacingGame racingGame = RacingGame.initGame(time, participantRacer);
        racingGame.startGame();

        // Then
        assertThat(racingGame.getCars().get(0).getPosition()).isBetween(0, 3);
        assertThat(racingGame.getCars().get(1).getPosition()).isBetween(0, 3);
        assertThat(racingGame.getCars().get(2).getPosition()).isBetween(0, 3);
    }


}