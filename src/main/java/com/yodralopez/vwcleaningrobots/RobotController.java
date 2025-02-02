package com.yodralopez.vwcleaningrobots;

import com.yodralopez.vwcleaningrobots.input.InputProcessor;
import com.yodralopez.vwcleaningrobots.input.RobotData;
import com.yodralopez.vwcleaningrobots.input.RobotFileReader;
import com.yodralopez.vwcleaningrobots.input.SimulationData;
import com.yodralopez.vwcleaningrobots.models.Direction;
import com.yodralopez.vwcleaningrobots.models.Robot;
import com.yodralopez.vwcleaningrobots.models.Workspace;
import com.yodralopez.vwcleaningrobots.vos.Position;

import java.util.List;

public class RobotController {

    public static void main(String[] args) {
        InputProcessor inputProcessor = new RobotFileReader(args[0]);

        SimulationData simulationData = inputProcessor.process();

        Workspace workspace = Workspace.create(simulationData.getWidth(), simulationData.getHeight());
        List<RobotData> dataRobots = simulationData.getRobotsData();

        for (RobotData data : dataRobots) {
            Position position = new Position(data.x(), data.y());
            Robot robot = Robot.initialization(position, Direction.valueOf(data.direction()));
            robot.execute(data.commands(), workspace);
            System.out.println(robot);
        }
    }

}
