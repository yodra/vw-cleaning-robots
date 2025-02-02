package com.yodralopez.vwcleaningrobots.models;

import com.yodralopez.vwcleaningrobots.exceptions.BoundsException;
import com.yodralopez.vwcleaningrobots.exceptions.InvalidCommandException;

public class Robot {
    private int x;
    private int y;
    private CardinalPoint orientation;

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

    public static Robot initialization(int x, int y, CardinalPoint orientation) {
        return new Robot(x, y, orientation);
    }

    public void execute(String commands, Workspace workspace) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    moveForward();
                    if (!workspace.isWithinBounds(x, y)) {
                        throw new BoundsException();
                    }
                    break;
                default:
                    throw new InvalidCommandException(command);
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CardinalPoint getOrientation() {
        return orientation;
    }

    private void moveForward() {
        switch (orientation) {
            case NORTH:
                y += 1;
                break;
            case EAST:
                x += 1;
                break;
            case SOUTH:
                y -= 1;
                break;
            case WEST:
                x -= 1;
                break;
        }
    }

    private void turnRight() {
        switch (orientation) {
            case NORTH:
                orientation = CardinalPoint.EAST;
                break;
            case EAST:
                orientation = CardinalPoint.SOUTH;
                break;
            case SOUTH:
                orientation = CardinalPoint.WEST;
                break;
            case WEST:
                orientation = CardinalPoint.NORTH;
                break;
        }
    }

    private void turnLeft() {
        switch (orientation) {
            case NORTH:
                orientation = CardinalPoint.WEST;
                break;
            case WEST:
                orientation = CardinalPoint.SOUTH;
                break;
            case SOUTH:
                orientation = CardinalPoint.EAST;
                break;
            case EAST:
                orientation = CardinalPoint.NORTH;
                break;
        }
    }
}
