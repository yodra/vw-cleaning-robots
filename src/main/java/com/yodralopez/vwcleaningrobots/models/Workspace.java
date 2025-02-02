package com.yodralopez.vwcleaningrobots.models;

public class Workspace {
    private static final int BOTTOM = 0;
    private static final int LEFT = 0;

    private final int width;
    private final int height;

    private Workspace(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Workspace create(int width, int height) {
        return new Workspace(width, height);
    }

    public boolean isWithinBounds(int x, int y) {
        return isWithinWidth(x) && isWithinHeight(y);
    }

    private boolean isWithinWidth(int x) {
        return x >= BOTTOM && x <= width;
    }

    private boolean isWithinHeight(int y) {
        return y >= LEFT && y <= height;
    }
}
