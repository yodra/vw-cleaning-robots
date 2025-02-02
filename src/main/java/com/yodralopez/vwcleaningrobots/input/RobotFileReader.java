package com.yodralopez.vwcleaningrobots.input;

import com.yodralopez.vwcleaningrobots.exceptions.RobotFileReaderException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RobotFileReader {
    private static final String SEPARATOR = " ";

    private BufferedReader reader;
    private final SimulationData simulationData;

    private RobotFileReader() {
        this.simulationData = new SimulationData();
    }

    public static RobotFileReader openFile(String filePath) throws RobotFileReaderException {
        try {
            RobotFileReader robotFileReader = new RobotFileReader();
            robotFileReader.setReader(new BufferedReader(new FileReader(filePath)));
            return robotFileReader;
        } catch (IOException e) {
            throw new RobotFileReaderException("Error reading file: " + e.getMessage());
        }
    }

    public SimulationData process() throws RobotFileReaderException {
        processWorkspaceSize();
        processRobots();
        return simulationData;
    }

    private void processWorkspaceSize() throws RobotFileReaderException {
        try {
            String[] gridSize = reader.readLine().split(SEPARATOR);
            int width = Integer.parseInt(gridSize[0]);
            int height = Integer.parseInt(gridSize[1]);
            simulationData.setWidth(width);
            simulationData.setHeight(height);
        } catch (IOException e) {
            throw new RobotFileReaderException("Error reading workspace information: " + e.getMessage());
        }
    }

    private void processRobots() throws RobotFileReaderException {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] position = line.split(SEPARATOR);
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                String direction = position[2];

                String commands = reader.readLine();
                simulationData.addRobot(new RobotData(x, y, direction, commands));
            }
        } catch (IOException e) {
            throw new RobotFileReaderException("Error reading robot information: " + e.getMessage());
        }
    }

    private void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}
