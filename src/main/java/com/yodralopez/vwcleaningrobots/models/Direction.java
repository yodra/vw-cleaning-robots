package com.yodralopez.vwcleaningrobots.models;

public enum Direction {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    public final char point;

    Direction(char point) {
        this.point = point;
    }
}
