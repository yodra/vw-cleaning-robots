package com.yodralopez.vwcleaningrobots.helpers;

import com.yodralopez.vwcleaningrobots.exceptions.InvalidCommandException;

public class CommandHelper {

    public static void assertValid(char command) {
        if (command != 'L' && command != 'R' && command != 'M') {
            throw new InvalidCommandException(command);
        }
    }
}
