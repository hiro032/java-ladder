package ladder.domain;

public class LastPointStrategy implements PointStrategy {
    private final Point previousPoint;

    public LastPointStrategy(Point previousPoint) {
        this.previousPoint = previousPoint;
    }

    @Override
    public Point point() {
        if (previousPoint.hasRightDirection()) {
            return new Point(previousPoint.nextIndex(), new Direction(true, false));
        }
        return new Point(previousPoint.nextIndex(), new Direction(false, false));
    }
}