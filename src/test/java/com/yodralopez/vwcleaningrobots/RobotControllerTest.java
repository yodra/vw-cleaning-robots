package com.yodralopez.vwcleaningrobots;

import com.yodralopez.vwcleaningrobots.exceptions.InvalidCommandException;
import com.yodralopez.vwcleaningrobots.exceptions.PositionException;
import com.yodralopez.vwcleaningrobots.exceptions.WorkspaceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RobotControllerTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testSuccessfulExecution() throws IOException {
        File file = FileTestHelper.createFileWithOneRobot();
        String filePath = file.getAbsolutePath();
        RobotController.main(new String[]{filePath});

        String expectedOutput = """
                1 3 N
                """.trim();

        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    void testFileNotFound() {
        String invalidFilePath = "src/test/resources/nonexistent.txt";

        assertThrows(RuntimeException.class, () -> RobotController.main(new String[]{invalidFilePath}));
    }

    @Test
    void testInvalidInstructions() throws IOException {
        File file = FileTestHelper.createFileWithInvalidInstructions();
        String filePath = file.getAbsolutePath();

        Exception exception = assertThrows(InvalidCommandException.class, () ->
                RobotController.main(new String[]{filePath})
        );

        assertTrue(exception.getMessage().contains("Invalid command"));
    }

    @Test
    void testRobotOutOfBounds() throws IOException {
        File file = FileTestHelper.createFileWithOutOfBoundsInstructions();
        String filePath = file.getAbsolutePath();


        Exception exception = assertThrows(WorkspaceException.class, () ->
                RobotController.main(new String[]{filePath})
        );

        assertTrue(exception.getMessage().contains("Robot cannot move outside workspace"));
    }

    @Test
    void testRobotNegativePosition() throws IOException {
        File file = FileTestHelper.createFileWithNegativeMovement();
        String filePath = file.getAbsolutePath();


        Exception exception = assertThrows(PositionException.class, () ->
                RobotController.main(new String[]{filePath})
        );

        assertTrue(exception.getMessage().contains("Position cannot be negative"));
    }

}
