package com.yodralopez.vwcleaningrobots;

import com.yodralopez.vwcleaningrobots.instructions.InstructionsProcessor;
import com.yodralopez.vwcleaningrobots.instructions.RobotData;
import com.yodralopez.vwcleaningrobots.instructions.InstructionsFileReader;
import com.yodralopez.vwcleaningrobots.instructions.InstructionsData;
import com.yodralopez.vwcleaningrobots.models.Direction;
import com.yodralopez.vwcleaningrobots.models.Robot;
import com.yodralopez.vwcleaningrobots.models.Workspace;
import com.yodralopez.vwcleaningrobots.vos.Position;

import java.util.List;

public class RobotController {

    public static void main(String[] args) {
        InstructionsProcessor instructionsProcessor = new InstructionsFileReader(args[0]);

        InstructionsData instructionsData = instructionsProcessor.process();

        Workspace workspace = Workspace.create(instructionsData.getWidth(), instructionsData.getHeight());
        List<RobotData> dataRobots = instructionsData.getRobotsData();

        for (RobotData data : dataRobots) {
            Position position = Position.of(data.x(), data.y());
            Robot robot = Robot.initialization(position, Direction.valueOf(data.direction()));
            robot.execute(data.commands(), workspace);
            System.out.println(robot);
        }
    }

}
