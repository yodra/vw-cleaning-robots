package com.yodralopez.vwcleaningrobots.vos;

public record Position(int x, int y) {

    @Override
    public String toString() {
        return x + " " + y;
    }
}
