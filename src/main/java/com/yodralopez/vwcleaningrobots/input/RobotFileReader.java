package com.yodralopez.vwcleaningrobots.input;

import com.yodralopez.vwcleaningrobots.exceptions.InputProcessorException;
import com.yodralopez.vwcleaningrobots.exceptions.RobotFileReaderException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RobotFileReader implements InputProcessor {
    private static final String SEPARATOR = " ";
    private final String filePath;

    private BufferedReader reader;
    private final SimulationData simulationData;

    public RobotFileReader(String filePath) {
        this.filePath = filePath;
        this.simulationData = new SimulationData();
    }

    public SimulationData process() {
        try {
            openFile(filePath);
            processWorkspaceSize();
            processRobots();
            return simulationData;
        } catch (IOException e) {
            throw new InputProcessorException(e.getMessage());
        }
    }

    private void openFile(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    private void processWorkspaceSize() throws IOException {
        String[] gridSize = reader.readLine().split(SEPARATOR);
        int width = Integer.parseInt(gridSize[0]);
        int height = Integer.parseInt(gridSize[1]);
        simulationData.setWidth(width);
        simulationData.setHeight(height);
    }

    private void processRobots() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] position = line.split(SEPARATOR);
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            String direction = position[2];

            String commands = reader.readLine();
            simulationData.addRobot(new RobotData(x, y, direction, commands));
        }
    }
}
