package com.mycompany.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameIntegrationTest {
    
    @Test
    public void testGameFlow() {
        Game game = new Game();

        game.cplayer = game.player1;
        game.board[0] = 'X';
        game.symbol = 'X';

        assertEquals(State.PLAYING, game.checkState(game.board));

        game.cplayer = game.player2;
        int move = game.MiniMax(game.board, game.player2);
        assertTrue(move > 0 && move <= 9);

        assertEquals(5, move);
    }
    
    @Test
    public void testWinDetection() {
        Game game = new Game();
        
        // X выигрывает по первой строке
        game.board = new char[] {
            'X', 'X', 'X',
            'O', 'O', ' ',
            ' ', ' ', ' '
        };
        game.symbol = 'X';
        
        assertEquals(State.XWIN, game.checkState(game.board));
    }
}
