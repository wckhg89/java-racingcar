package race.engine;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class RacingGameTest {

    @Test
    void initGame() {
        // Given
        int time = 1;
        List<String> participants = newArrayList("guppy", "honggu", "woowabros");

        // When
        RacingGame racingGame = RacingGame.initGame(time, participants);

        // Then
        assertThat(racingGame.getRounds().get(0).getCars()).hasSize(3);
        assertThat(racingGame.getRounds().get(0).getCars().get(0).getName()).isEqualTo("guppy");
        assertThat(racingGame.getRounds().get(0).getCars().get(1).getName()).isEqualTo("honggu");
        assertThat(racingGame.getRounds().get(0).getCars().get(2).getName()).isEqualTo("woowabros");
    }

    @Test
    void startGame() {
        // Given
        int time = 1;
        List<String> participants = newArrayList("guppy", "honggu", "woowabros");

        // When
        RacingGame racingGame = RacingGame.initGame(time, participants);
        racingGame.startGame();

        // Then
        assertThat(racingGame.getRounds().get(0).getCars().get(0).getPosition()).isBetween(0, 4);
        assertThat(racingGame.getRounds().get(0).getCars().get(1).getPosition()).isBetween(0, 4);
        assertThat(racingGame.getRounds().get(0).getCars().get(2).getPosition()).isBetween(0, 4);
    }


}