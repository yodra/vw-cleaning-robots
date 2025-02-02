package com.yodralopez.vwcleaningrobots.models;

import com.yodralopez.vwcleaningrobots.exceptions.InvalidCommandException;
import com.yodralopez.vwcleaningrobots.exceptions.WorkspaceException;
import com.yodralopez.vwcleaningrobots.vos.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void shouldMoveForwardWithinWorkspace() {
        Robot robot = Robot.initialization(new Position(0, 0), Direction.N);

        robot.execute("M", Workspace.create(5, 5));

        assertEquals(new Position(0, 1), robot.getPosition());
    }

    @Test
    void shouldTurnRight() {
        Robot robot = Robot.initialization(new Position(5, 5), Direction.N);

        robot.execute("R", Workspace.create(5, 5));

        assertEquals(Direction.E, robot.getDirection());
    }

    @Test
    void shouldTurnLeft() {
        Robot robot = Robot.initialization(new Position(5, 5), Direction.N);

        robot.execute("L", Workspace.create(5, 5));

        assertEquals(Direction.W, robot.getDirection());
    }

    @Test
    void shouldMoveFollowingTheInstructions() {
        Robot robot = Robot.initialization(new Position(1, 2), Direction.N);

        robot.execute("LMLMLMLMM", Workspace.create(5, 5));

        assertEquals(new Position(1, 3), robot.getPosition());
        assertEquals(Direction.N, robot.getDirection());
    }

    @Test
    void shouldThrowAnExceptionWhenInvalidCommand() {
        Robot robot = Robot.initialization(new Position(5, 5), Direction.N);
        String commands = "XYZ";

        Exception exception = assertThrows(InvalidCommandException.class,
                () -> robot.execute(commands, Workspace.create(5, 5)));

        assertTrue(exception.getMessage().contains("Invalid command"));
    }

    @Test
    void shouldThrowAnExceptionWhenRobotMovesBeyondUpperRightCorner() {
        Robot robot = Robot.initialization(new Position(5, 5), Direction.N);

        Exception exception = assertThrows(WorkspaceException.class,
                () -> robot.execute("M", Workspace.create(5, 5)));

        assertTrue(exception.getMessage().contains("Robot cannot move outside workspace"));
    }


}