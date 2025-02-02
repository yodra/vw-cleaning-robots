package com.yodralopez.vwcleaningrobots.models;

import com.yodralopez.vwcleaningrobots.helpers.CommandHelper;
import com.yodralopez.vwcleaningrobots.vos.Position;

public class Robot {
    private Position position;
    private Direction direction;

    public Robot() {
        this.position = new Position(0, 0);
        this.direction = Direction.N;
    }

    private Robot(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Robot initialization(Position position, Direction orientation) {
        return new Robot(position, orientation);
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

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return position.toString() + " " + direction;
    }

    private void moveForward(Workspace workspace) {
        int x = position.x() + direction.getDeltaX();
        int y = position.y() + direction.getDeltaY();
        Position newPosition = new Position(x, y);
        workspace.assertPositionValid(newPosition);
        this.position = newPosition;
    }

    private void turnRight() {
        direction = direction.right();
    }

    private void turnLeft() {
        direction = direction.left();
    }
}
