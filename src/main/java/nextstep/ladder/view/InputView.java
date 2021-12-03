package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ASK_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇개 인가요?";

    private InputView() {
    }

    public static String askPlayerssName() {
        System.out.println(ASK_PLAYERS_NAME);
        return SCANNER.nextLine();
    }

    public static int askLadderHeight() {
        System.out.println(ASK_LADDER_HEIGHT);
        String height = SCANNER.nextLine();
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력 하세요");
            return askLadderHeight();
        }
    }
}
