package com.yodralopez.vwcleaningrobots.models;

import com.yodralopez.vwcleaningrobots.helpers.CommandHelper;

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
            CommandHelper.assertValid(command);
            switch (command) {
                case 'L' -> turnLeft();
                case 'R' -> turnRight();
                case 'M' -> moveForward(workspace);
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

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }

    private void moveForward(Workspace workspace) {
        int newX = x + direction.getDeltaX();
        int newY = y + direction.getDeltaY();

        workspace.assertPositionValid(newX, newY);

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
