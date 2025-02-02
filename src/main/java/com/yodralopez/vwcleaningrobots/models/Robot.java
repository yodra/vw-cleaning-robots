package com.yodralopez.vwcleaningrobots.models;

import com.yodralopez.vwcleaningrobots.exceptions.BoundsException;
import com.yodralopez.vwcleaningrobots.exceptions.InvalidCommandException;

public class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.direction = Direction.N;
    }

    private Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static Robot initialization(int x, int y, Direction orientation) {
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
                    moveForward(workspace);
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

    public Direction getDirection() {
        return direction;
    }

    private void moveForward(Workspace workspace) {
        int newX = x + direction.getDeltaX();
        int newY = y + direction.getDeltaY();

        if (!workspace.isWithinBounds(newX, newY)) {
            throw new BoundsException();
        }

        x = newX;
        y = newY;
    }

    private void turnRight() {
        direction = direction.right();
    }

    private void turnLeft() {
        direction = direction.left();
    }
}
