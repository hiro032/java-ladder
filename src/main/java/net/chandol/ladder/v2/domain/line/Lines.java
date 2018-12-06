package net.chandol.ladder.v2.domain.line;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines implements Iterable<Line> {
    private static final String LINE_START_PADDING = "  ";
    private static final String BRIDGE_EXIST = "-----";
    private static final String BRIDGE_EMPTY = "     ";
    private static final String LINE_CHARACTER = "|";

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public boolean hasPoint(int column, int row) {
        if (column < 0 || column >= size()) {
            return false;
        }

        Line line = lines.get(column);
        return line.hasPoint(row);
    }

    public Direction getDirection(int column, int row) {
        if (hasPoint(column, row)) {
            return Direction.RIGHT;
        }

        if (hasPoint(column - 1, row)) {
            return Direction.LEFT;
        }

        return Direction.STRAIGHT;
    }

    public Line get(int idx) {
        return lines.get(idx);
    }

    public int size() {
        return lines.size();
    }

    private int height() {
        return lines.get(0).height();
    }

    public String createColumnString(int row) {
        StringBuilder builder = new StringBuilder(LINE_START_PADDING);
        IntStream.range(0, size()).forEach(idx -> {
            builder.append(LINE_CHARACTER);

            String bridge = hasPoint(idx, row) ? BRIDGE_EXIST : BRIDGE_EMPTY;
            builder.append(bridge);
        });

        return builder.toString();
    }

    public List<String> createLinesString() {
        return IntStream.range(0, height())
                .mapToObj(this::createColumnString)
                .collect(Collectors.toList());
    }

    public int calculateResult(int startLine) {
        int currentLine = startLine;
        for (int row = 0; row < height(); row++) {
            currentLine = move(currentLine, row);
        }

        return currentLine;
    }

    private int move(int currentLine, int row) {
        return getDirection(currentLine, row).nextLineNumber(currentLine);
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
}