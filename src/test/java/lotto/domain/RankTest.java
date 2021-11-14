package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @DisplayName("로또 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"3,false,FIFTH", "4,false,FOURTH", "5,false,THIRD", "5,true,SECOND", "6,false,FIRST",
        "0,false,MISS", "2,false,MISS", "4,true,FOURTH"})
    void valueOf(int cnt, boolean containsBonus, String rankName) {
        assertThat(Rank.valueOf(cnt, containsBonus)).isEqualTo(Rank.valueOf(rankName));
    }

}