package com.yodralopez.vwcleaningrobots.exceptions;

public class InvalidCommandException extends IllegalArgumentException {
    public InvalidCommandException(char command) {
        super("Invalid command: " + command);
    }

}
