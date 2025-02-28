package com.yodralopez.vwcleaningrobots.models;

public enum Direction {
    N(0, 1),
    E(1, 0),
    S(0, -1),
    W(-1, 0);

    public final int deltaX;
    public final int deltaY;

    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public Direction left() {
        int newDirectionIndex = (ordinal() + 3) % 4;
        return values()[newDirectionIndex];
    }

    public Direction right() {
        int newDirectionIndex = (ordinal() + 1) % 4;
        return values()[newDirectionIndex];
    }
}
