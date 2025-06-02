package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.symbol = 'X';
    }

    @Test
    void testInitialState() {
        assertEquals(State.PLAYING, game.state);
        assertNotNull(game.player1);
        assertNotNull(game.player2);
        assertEquals('X', game.player1.symbol);
        assertEquals('O', game.player2.symbol);

        char[] expected = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        assertArrayEquals(expected, game.board);
    }

    @Test
    void testCheckStateAllWinConditions() {
        // Проверяем все возможные выигрышные комбинации
        char[][] winningBoards = {
                {'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X'},
                {'X', ' ', ' ', 'X', ' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', ' ', 'X', ' ', ' ', 'X', ' '},
                {' ', ' ', 'X', ' ', ' ', 'X', ' ', ' ', 'X'},
                {'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X'},
                {' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' '}
        };

        for (char[] board : winningBoards) {
            game.board = board;
            assertEquals(State.XWIN, game.checkState(board));
        }
    }

    @Test
    void testCheckStateOWin() {
        game.symbol = 'O';
        char[] board = {'O', 'O', 'O', ' ', ' ', ' ', ' ', ' ', ' '};
        assertEquals(State.OWIN, game.checkState(board));
    }

    @Test
    void testCheckStateDraw() {
        char[] board = {'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X'};
        assertEquals(State.DRAW, game.checkState(board));
    }

    @Test
    void testCheckStatePlaying() {
        char[] board = {'X', 'O', 'X', 'X', ' ', 'O', 'O', 'X', 'X'};
        assertEquals(State.PLAYING, game.checkState(board));
    }

    @Test
    void testGenerateMoves() {
        char[] board = {'X', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'X'};
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(board, moves);

        assertEquals(6, moves.size());
        assertTrue(moves.contains(1));
        assertTrue(moves.contains(2));
        assertTrue(moves.contains(3));
        assertTrue(moves.contains(5));
        assertTrue(moves.contains(6));
        assertTrue(moves.contains(7));
    }

    @Test
    void testEvaluatePosition() {
        // X выигрывает
        char[] xWinBoard = {'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '};
        assertEquals(Game.INF, game.evaluatePosition(xWinBoard, game.player1));
        assertEquals(-Game.INF, game.evaluatePosition(xWinBoard, game.player2));

        // O выигрывает
        char[] oWinBoard = {'O', 'O', 'O', ' ', ' ', ' ', ' ', ' ', ' '};
        game.symbol = 'O';
        assertEquals(Game.INF, game.evaluatePosition(oWinBoard, game.player2));
        assertEquals(-Game.INF, game.evaluatePosition(oWinBoard, game.player1));

        // Ничья
        char[] drawBoard = {'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X'};
        assertEquals(0, game.evaluatePosition(drawBoard, game.player1));
        assertEquals(0, game.evaluatePosition(drawBoard, game.player2));

        // Игра продолжается
        char[] playingBoard = {'X', 'O', 'X', 'X', ' ', 'O', 'O', 'X', 'X'};
        assertEquals(-1, game.evaluatePosition(playingBoard, game.player1));
        assertEquals(-1, game.evaluatePosition(playingBoard, game.player2));
    }

    @Test
    void testMiniMaxBlocksOpponentWin() {
        char[] board = {'O', 'O', ' ', 'X', 'X', ' ', ' ', ' ', ' '};
        game.board = board.clone();
        game.symbol = 'O';

        int bestMove = game.MiniMax(board, game.player2);
        assertEquals(3, bestMove);
    }

    @Test
    void testMiniMaxTakesWinWhenAvailable() {
        char[] board = {'X', 'X', ' ', 'O', 'O', ' ', ' ', ' ', ' '};
        game.board = board.clone();

        int bestMove = game.MiniMax(board, game.player1);
        assertEquals(3, bestMove);
    }
}