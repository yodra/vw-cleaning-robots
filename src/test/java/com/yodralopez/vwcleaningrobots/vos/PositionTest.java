package com.yodralopez.vwcleaningrobots.vos;

import com.yodralopez.vwcleaningrobots.exceptions.PositionException;
import com.yodralopez.vwcleaningrobots.models.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void shouldThrowExceptionForNegativeXCoordinate() {
        assertThrows(PositionException.class, () -> Position.of(-1, 2));
    }

    @Test
    void shouldThrowExceptionForNegativeYCoordinate() {
        assertThrows(PositionException.class, () -> Position.of(2, -1));
    }

    @Test
    void shouldIncrementPositionNorth() {
        Position position = Position.of(2, 3);
        Position newPosition = position.increment(Direction.N);
        assertEquals(Position.of(2, 4), newPosition);
    }

    @Test
    void shouldIncrementPositionEast() {
        Position position = Position.of(2, 3);
        Position newPosition = position.increment(Direction.E);
        assertEquals(Position.of(3, 3), newPosition);
    }

    @Test
    void shouldIncrementPositionSouth() {
        Position position = Position.of(2, 3);
        Position newPosition = position.increment(Direction.S);
        assertEquals(Position.of(2, 2), newPosition);
    }

    @Test
    void shouldIncrementPositionWest() {
        Position position = Position.of(2, 3);
        Position newPosition = position.increment(Direction.W);
        assertEquals(Position.of(1, 3), newPosition);
    }
}