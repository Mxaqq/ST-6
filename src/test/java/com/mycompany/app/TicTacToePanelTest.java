package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToePanelTest {
    private TicTacToePanel panel;

    @BeforeEach
    void setUp() {
        panel = new TicTacToePanel(new GridLayout(3, 3));
    }

    @Test
    void testInitialState() {
        for (TicTacToeCell cell : panel.cells) {
            assertNotNull(cell);
            assertEquals(' ', cell.getMarker());
        }
        assertEquals(panel.game.player1, panel.game.cplayer);
    }

    @Test
    void testPlayerMove() {
        panel.cells[0].doClick();
        assertEquals('X', panel.cells[0].getMarker());
        assertFalse(panel.cells[0].isEnabled());
    }

    @Test
    void testAIMoveAfterPlayer() {
        panel.cells[0].doClick(); // Ход игрока
        boolean aiMoved = false;

        for (int i = 1; i < 9; i++) {
            if (panel.cells[i].getMarker() == 'O') {
                aiMoved = true;
                break;
            }
        }

        assertTrue(aiMoved, "AI должен был сделать ход после игрока");
    }

    @Test
    void testGameEndDetection() {
        // Имитируем выигрышную ситуацию
        panel.cells[0].setMarker("X");
        panel.cells[1].setMarker("X");
        panel.cells[2].setMarker("X");

        panel.game.board = new char[] {'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '};
        panel.game.symbol = 'X';
        panel.game.state = panel.game.checkState(panel.game.board);

        assertEquals(State.XWIN, panel.game.state);
    }
    @Test
    void testPanelInitialization() {
        assertEquals(9, panel.cells.length);
        for (int i = 0; i < 9; i++) {
            assertNotNull(panel.cells[i]);
            assertEquals(' ', panel.cells[i].getMarker());
        }
        assertEquals(panel.game.player1, panel.game.cplayer);
    }

    @Test
    void testPanelActionPerformed() {
        ActionEvent event = new ActionEvent(panel.cells[0], ActionEvent.ACTION_PERFORMED, "");
        panel.actionPerformed(event);

        assertEquals('X', panel.cells[0].getMarker());
        assertFalse(panel.cells[0].isEnabled());
    }

    @Test
    void testPanelGameEndDetection() {
        // Имитируем выигрышную ситуацию
        panel.cells[0].setMarker("X");
        panel.cells[1].setMarker("X");
        panel.cells[2].setMarker("X");

        panel.game.board = new char[]{'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '};
        panel.game.symbol = 'X';
        panel.game.state = panel.game.checkState(panel.game.board);

        assertEquals(State.XWIN, panel.game.state);
    }

    @Test
    void testPanelAIMoveAfterPlayer() {
        panel.cells[0].doClick(); // Ход игрока

        boolean aiMoved = false;
        for (int i = 1; i < 9; i++) {
            if (panel.cells[i].getMarker() == 'O') {
                aiMoved = true;
                break;
            }
        }

        assertTrue(aiMoved, "AI должен был сделать ход после игрока");
    }
}