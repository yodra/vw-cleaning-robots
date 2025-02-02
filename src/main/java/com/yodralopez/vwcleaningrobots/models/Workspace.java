package com.yodralopez.vwcleaningrobots.models;

public class Workspace {
    private final int width;
    private final int height;

    private Workspace(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Workspace create(int width, int height) {
        return new Workspace(width, height);
    }
}
