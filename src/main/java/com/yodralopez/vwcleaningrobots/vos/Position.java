package com.yodralopez.vwcleaningrobots.vos;

import com.yodralopez.vwcleaningrobots.exceptions.PositionException;
import com.yodralopez.vwcleaningrobots.models.Direction;

import java.util.Objects;

public final class Position {
    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(int x, int y) {
        if (x < 0 || y < 0) {
            throw new PositionException("Position cannot be negative");
        }
        return new Position(x, y);
    }

    public Position increment(Direction direction) {
        return Position.of(x + direction.getDeltaX(), y + direction.getDeltaY());
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
