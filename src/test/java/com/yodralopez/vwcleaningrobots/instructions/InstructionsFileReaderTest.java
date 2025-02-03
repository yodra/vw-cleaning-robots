package com.yodralopez.vwcleaningrobots.instructions;

import com.yodralopez.vwcleaningrobots.FileTestHelper;
import com.yodralopez.vwcleaningrobots.exceptions.InputProcessorException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InstructionsFileReaderTest {

    @Test
    void shouldThrowExceptionWhenFileNotFound() {
        InstructionsFileReader fileReader = new InstructionsFileReader("invalidPath");

        assertThrows(InputProcessorException.class, fileReader::process);
    }

    @Test
    void shouldGetTheInstructionsFromAFileForOneRobots() throws IOException {
        File file = FileTestHelper.createFileWithOneRobot();
        InstructionsFileReader fileReader = new InstructionsFileReader(file.getAbsolutePath());

        InstructionsData instructionsData = fileReader.process();

        assertNotNull(instructionsData);
        assertEquals(5, instructionsData.getWidth());
        assertEquals(5, instructionsData.getHeight());
        assertEquals(1, instructionsData.getRobotsData().size());
        RobotData robot = instructionsData.getRobotsData().get(0);
        assertEquals(1, robot.x());
        assertEquals(2, robot.y());
        assertEquals("N", robot.direction());
        assertEquals("LMLMLMLMM", robot.commands());
    }

    @Test
    void shouldGetTheInstructionsFromAFileForSomeRobots() throws IOException {
        File file = FileTestHelper.createFileWithSomeRobot();
        InstructionsFileReader fileReader = new InstructionsFileReader(file.getAbsolutePath());

        InstructionsData instructionsData = fileReader.process();

        assertNotNull(instructionsData);
        assertEquals(5, instructionsData.getWidth());
        assertEquals(5, instructionsData.getHeight());
        RobotData robotOne = instructionsData.getRobotsData().get(0);
        assertEquals(1, robotOne.x());
        assertEquals(2, robotOne.y());
        assertEquals("N", robotOne.direction());
        assertEquals("LMLMLMLMM", robotOne.commands());
        RobotData robotTwo = instructionsData.getRobotsData().get(1);
        assertEquals(3, robotTwo.x());
        assertEquals(3, robotTwo.y());
        assertEquals("E", robotTwo.direction());
        assertEquals("MMRMMRMRRM", robotTwo.commands());
    }

}