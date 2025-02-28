package com.yodralopez.vwcleaningrobots.models;

import com.yodralopez.vwcleaningrobots.exceptions.WorkspaceException;
import com.yodralopez.vwcleaningrobots.vos.Position;

public class Workspace {
    private static final Position origin = Position.of(0, 0);

    private final int width;
    private final int height;

    private Workspace(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Workspace create(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new WorkspaceException("Workspace dimensions must be greater than 0");
        }
        return new Workspace(width, height);
    }

    public void assertPositionValid(Position position) {
        if (!this.isWithinBounds(position)) {
            throw new WorkspaceException("Robot cannot move outside workspace");
        }
    }

    private boolean isWithinBounds(Position position) {
        return isWithinWidth(position.x()) && isWithinHeight(position.y());
    }

    private boolean isWithinWidth(int x) {
        return x >= origin.x() && x <= width;
    }

    private boolean isWithinHeight(int y) {
        return y >= origin.y() && y <= height;
    }
}
