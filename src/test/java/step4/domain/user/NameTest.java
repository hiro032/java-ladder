package step4.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.exception.user.NameBlankException;
import step4.exception.user.NameLengthException;

public class NameTest {

    @Test
    @DisplayName("name 생성 테스트")
    void createNameTest() {

        // given
        String input = "PJS";

        // when
        Name result = Name.of(input);

        // then
        assertThat(result).isEqualTo(Name.of(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"testte", "testtes", "testtest"})
    @DisplayName("이름 3글자 제한 테스트")
    void validNameLengthTest(String input) {

        // when & then
        assertThatExceptionOfType(NameLengthException.class)
            .isThrownBy(() -> Name.of(input))
            .withMessageMatching("사람의 이름은 최대 5글자까지만 입력가능하다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름 공백 제한 테스트")
    void validNameBlankTest(String input) {

        // when & then
        assertThatExceptionOfType(NameBlankException.class)
            .isThrownBy(() -> Name.of(input))
            .withMessageMatching("이름은 필수로 제공되어야 한다.");
    }
}