package com.yodralopez.vwcleaningrobots.models;

import com.yodralopez.vwcleaningrobots.exceptions.BoundsException;
import com.yodralopez.vwcleaningrobots.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Test;

import static com.yodralopez.vwcleaningrobots.models.CardinalPoint.NORTH;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotTest {

    @Test
    void should_move_following_instructions() {
        Robot robot = Robot.initialization(1, 2, NORTH);
        Workspace workspace = Workspace.create(5, 5);

        robot.execute("LMLMLMLMM", workspace);

        assert robot.getX() == 1;
        assert robot.getY() == 3;
        assert robot.getOrientation() == NORTH;
    }

    @Test
    void should_throw_exception_when_invalid_command() {
        Robot robot = Robot.initialization(1, 2, NORTH);
        Workspace workspace = Workspace.create(5, 5);

        Exception exception = assertThrows(InvalidCommandException.class,
                () -> robot.execute("LMZLMLMLMM", workspace));

        assert exception.getMessage().equals("Invalid command: Z");
    }

    @Test
    void should_throw_exception_when_robot_moves_beyond_upper_right_corner() {
        Robot robot = Robot.initialization(5, 5, NORTH);
        Workspace workspace = Workspace.create(5, 5);

        Exception exception = assertThrows(BoundsException.class,
                () -> robot.execute("M", workspace));

        assert exception.getMessage().equals("Robot cannot move outside workspace");
    }

}