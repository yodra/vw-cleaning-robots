package com.yodralopez.vwcleaningrobots.models;

import com.yodralopez.vwcleaningrobots.exceptions.WorkspaceException;
import com.yodralopez.vwcleaningrobots.vos.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkspaceTest {

    @Test
    void shouldThrowExceptionWhenPositionOutOfBounds_Right() {
        Workspace workspace = Workspace.create(5, 5);
        Position position = Position.of(6, 5);

        assertThrows(WorkspaceException.class, () -> workspace.assertPositionValid(position));
    }

    @Test
    void shouldThrowExceptionWhenPositionOutOfBounds_Top() {
        Workspace workspace = Workspace.create(5, 5);
        Position position = Position.of(5, 6);

        assertThrows(WorkspaceException.class, () -> workspace.assertPositionValid(position));
    }

    @Test
    void shouldNotThrowExceptionWhenPositionIsWithinBounds() {
        Workspace workspace = Workspace.create(5, 5);
        Position position = Position.of(3, 3);

        assertDoesNotThrow(() -> workspace.assertPositionValid(position));
    }

}