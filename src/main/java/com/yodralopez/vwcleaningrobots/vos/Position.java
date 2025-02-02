package com.yodralopez.vwcleaningrobots.vos;

import com.yodralopez.vwcleaningrobots.exceptions.PositionException;

public record Position(int x, int y) {

    public Position {
        if (x < 0 || y < 0) {
            throw new PositionException("Position cannot be negative");
        }
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
