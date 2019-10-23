package race.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RoundTest {

    @Test
    void extractWinner_단일승자() {
        // Given
        Round round1 = Round.initRound(1, Lists.newArrayList("guppy", "gaemi", "cinabro"));

        // When
        round1.getCars().get(0).move(1);
        round1.getCars().get(1).move(1);
        round1.getCars().get(2).move(4);

        List<String> winners = round1.extractWinner();

        // Then
        assertThat(winners).hasSize(1);
        assertThat(winners).contains("cinabro");
    }

    @Test
    void extractWinner_복수승자() {
        // Given
        Round round1 = Round.initRound(1, Lists.newArrayList("guppy", "gaemi", "cinabro"));

        // When
        round1.getCars().get(0).move(1);
        round1.getCars().get(1).move(4);
        round1.getCars().get(2).move(4);

        List<String> winners = round1.extractWinner();

        // Then
        assertThat(winners).hasSize(2);
        assertThat(winners).contains("gaemi");
        assertThat(winners).contains("cinabro");
    }
}