package com.mycompany.app;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeCellTest {
    private TicTacToeCell cell;

    @BeforeEach
    void setUp() {
        cell = new TicTacToeCell(1, 0, 0);
    }

    @Test
    void testInitialState() {
        assertEquals(' ', cell.getMarker());
        assertEquals(1, cell.getNum());
        assertEquals(0, cell.getRow());
        assertEquals(0, cell.getCol());
        assertTrue(cell.isEnabled());
    }

    @Test
    void testSetMarker() {
        cell.setMarker("X");
        assertEquals('X', cell.getMarker());
        assertFalse(cell.isEnabled());
    }

    @Test
    void testCellProperties() {
        TicTacToeCell customCell = new TicTacToeCell(5, 2, 1);
        assertEquals(5, customCell.getNum());
        assertEquals(1, customCell.getRow());
        assertEquals(2, customCell.getCol());
    }
}