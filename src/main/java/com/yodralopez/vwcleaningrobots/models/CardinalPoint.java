package com.yodralopez.vwcleaningrobots.models;

public enum CardinalPoint {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    public final char point;

    CardinalPoint(char point) {
        this.point = point;
    }
}
