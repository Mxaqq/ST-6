package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PlayerTest {
    @Test
    void testPlayerInitialization() {
        Player player = new Player();
        assertFalse(player.selected);
        assertFalse(player.win);
        assertEquals(0, player.move);
    }

    @Test
    void testPlayerSymbolAssignment() {
        Game game = new Game();
        assertEquals('X', game.player1.symbol);
        assertEquals('O', game.player2.symbol);
    }
}

