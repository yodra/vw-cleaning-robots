package com.yodralopez.vwcleaningrobots.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    void shouldLeftFromNorth() {
        assertEquals(Direction.W, Direction.N.left());
    }

    @Test
    void shouldLeftFromEast() {
        assertEquals(Direction.N, Direction.E.left());
    }

    @Test
    void shouldLeftFromSouth() {
        assertEquals(Direction.E, Direction.S.left());
    }

    @Test
    void shouldLeftFromWest() {
        assertEquals(Direction.S, Direction.W.left());
    }

    @Test
    void shouldRightFromNorth() {
        assertEquals(Direction.E, Direction.N.right());
    }

    @Test
    void shouldRightFromEast() {
        assertEquals(Direction.S, Direction.E.right());
    }

    @Test
    void shouldRightFromSouth() {
        assertEquals(Direction.W, Direction.S.right());
    }

    @Test
    void shouldRightFromWest() {
        assertEquals(Direction.N, Direction.W.right());
    }
}