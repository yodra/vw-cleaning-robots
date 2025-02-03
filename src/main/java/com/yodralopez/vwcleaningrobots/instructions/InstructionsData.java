package com.yodralopez.vwcleaningrobots.instructions;

import java.util.ArrayList;
import java.util.List;

public class InstructionsData {
    private int width;
    private int height;
    private final List<RobotData> robots;

    public InstructionsData() {
        this.robots = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<RobotData> getRobotsData() {
        return robots;
    }

    public void addRobot(RobotData robot) {
        robots.add(robot);
    }
}
