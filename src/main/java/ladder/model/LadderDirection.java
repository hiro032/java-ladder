package ladder.model;

import java.util.Random;

public class LadderDirection {
    private static final Random random = new Random();

    private final boolean left;
    private final boolean right;

    LadderDirection(boolean left, boolean right) {
        validateNotBothDirections(left, right);
        this.left = left;
        this.right = right;
    }

    static LadderDirection first() {
        return new LadderDirection(false, generatePoint());
    }

    static LadderDirection first(boolean right) {
        return new LadderDirection(false, right);
    }

    LadderDirection next() {
        if (right) {
            return next(false);
        }
        return next(generatePoint());
    }

    private LadderDirection next(boolean nextRight) {
        return new LadderDirection(right, nextRight);
    }

    LadderDirection last() {
        return new LadderDirection(right, false);
    }

    private static boolean generatePoint() {
        return random.nextBoolean();
    }

    private void validateNotBothDirections(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리 방향이 양쪽으로 있을 수 없습니다.");
        }
    }

    boolean isLeft() {
        return left;
    }

    boolean isRight() {
        return right;
    }
}