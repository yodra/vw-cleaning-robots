package com.yodralopez.vwcleaningrobots.models;

public class Workspace {
    private final int maxX;
    private final int maxY;

    private Workspace(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public static Workspace create(int maxX, int maxY) {
        return new Workspace(maxX, maxY);
    }
}
