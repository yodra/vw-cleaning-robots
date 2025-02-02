package com.yodralopez.vwcleaningrobots.exceptions;

public class BoundsException extends IllegalArgumentException {
    public BoundsException() {
        super("Robot cannot move outside workspace");
    }
}
