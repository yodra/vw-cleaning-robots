package com.yodralopez.vwcleaningrobots.models;

import com.yodralopez.vwcleaningrobots.exceptions.WorkspaceException;
import com.yodralopez.vwcleaningrobots.exceptions.InvalidCommandException;
import com.yodralopez.vwcleaningrobots.vos.Position;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.yodralopez.vwcleaningrobots.models.Direction.N;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotTest {

    @Test
    void should_move_following_instructions() {
        Robot robot = Robot.initialization(new Position(1, 2), N);
        Workspace workspace = Workspace.create(5, 5);

        robot.execute("LMLMLMLMM", workspace);

        assert Objects.equals(robot.getPosition(), new Position(1, 3));
        assert robot.getDirection() == N;
    }

    @Test
    void should_throw_exception_when_invalid_command() {
        Robot robot = Robot.initialization(new Position(1, 2), N);
        Workspace workspace = Workspace.create(5, 5);

        Exception exception = assertThrows(InvalidCommandException.class,
                () -> robot.execute("LMZLMLMLMM", workspace));

        assert exception.getMessage().equals("Invalid command: Z");
    }

    @Test
    void should_throw_exception_when_robot_moves_beyond_upper_right_corner() {
        Robot robot = Robot.initialization(new Position(5, 5), N);
        Workspace workspace = Workspace.create(5, 5);

        Exception exception = assertThrows(WorkspaceException.class,
                () -> robot.execute("M", workspace));

        assert exception.getMessage().equals("Robot cannot move outside workspace");
    }

}