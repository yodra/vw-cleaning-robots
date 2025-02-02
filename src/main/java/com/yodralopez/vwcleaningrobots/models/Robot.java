package com.yodralopez.vwcleaningrobots.models;

public class Robot {
    private final int x;
    private final int y;
    private final CardinalPoint orientation;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.orientation = CardinalPoint.NORTH;
    }

    private Robot(int x, int y, CardinalPoint orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Robot initialization(int x, int y, CardinalPoint orientation) {
        return new Robot(x, y, orientation);
    }

}
