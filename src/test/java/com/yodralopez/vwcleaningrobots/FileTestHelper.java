package com.yodralopez.vwcleaningrobots;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTestHelper {

    public static File createFileWithOneRobot() throws IOException {
        File tempFile = File.createTempFile("instructions", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("5 5\n");
            writer.write("1 2 N\n");
            writer.write("LMLMLMLMM\n");
        }
        return tempFile;
    }

    public static File createFileWithSomeRobot() throws IOException {
        File tempFile = File.createTempFile("instructions", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("5 5\n");
            writer.write("1 2 N\n");
            writer.write("LMLMLMLMM\n");
            writer.write("3 3 E\n");
            writer.write("MMRMMRMRRM\n");
        }
        return tempFile;
    }

    public static File createFileWithInvalidInstructions() throws IOException {
        File tempFile = File.createTempFile("instructions", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("5 5\n");
            writer.write("1 2 N\n");
            writer.write("LMXM\n");
        }
        return tempFile;
    }

    public static File createFileWithOutOfBoundsInstructions() throws IOException {
        File tempFile = File.createTempFile("instructions", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("5 5\n");
            writer.write("5 5 N\n");
            writer.write("M\n");
        }
        return tempFile;
    }

    public static File createFileWithNegativeMovement() throws IOException {
        File tempFile = File.createTempFile("instructions", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("5 5\n");
            writer.write("0 0 S\n");
            writer.write("M\n");
        }
        return tempFile;
    }
}
