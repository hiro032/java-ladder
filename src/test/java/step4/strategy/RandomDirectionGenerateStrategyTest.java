package step4.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomDirectionGenerateStrategyTest {

    @Test
    @DisplayName("getInstance() 테스트")
    void getInstanceTest() {

        // when
        RandomDirectionGenerateStrategy result = RandomDirectionGenerateStrategy.getInstance();

        // then
        assertThat(result).isInstanceOf(DirectionGenerateStrategy.class);
        assertThat(result).isInstanceOf(RandomDirectionGenerateStrategy.class);
    }

    @Test
    @DisplayName("generateLine() 테스트")
    void generateLineTest() {

        // given
        RandomDirectionGenerateStrategy strategy = RandomDirectionGenerateStrategy.getInstance();

        // when
        boolean result = strategy.generateDirection();

        // then
        assertThat(result).isInstanceOf(Boolean.class);
    }

}