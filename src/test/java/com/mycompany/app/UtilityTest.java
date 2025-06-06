package com.mycompany.app;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UtilityTest {
    @Test
    void testPrintCharArray() {
        char[] board = {'X', 'O', ' ', 'X', ' ', 'O', ' ', ' ', 'X'};
        assertDoesNotThrow(() -> Utility.print(board));
    }

    @Test
    void testPrintIntArray() {
        int[] board = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertDoesNotThrow(() -> Utility.print(board));
    }

    @Test
    void testPrintArrayList() {
        ArrayList<Integer> moves = new ArrayList<>();
        moves.add(1);
        moves.add(3);
        moves.add(5);
        assertDoesNotThrow(() -> Utility.print(moves));
    }
    @Test
    void testUtilityPrintCharArray() {
        char[] board = {'X', 'O', ' ', 'X', ' ', 'O', ' ', ' ', 'X'};
        assertDoesNotThrow(() -> Utility.print(board));
    }

    @Test
    void testUtilityPrintIntArray() {
        int[] board = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertDoesNotThrow(() -> Utility.print(board));
    }

    @Test
    void testUtilityPrintArrayList() {
        ArrayList<Integer> moves = new ArrayList<>();
        moves.add(1);
        moves.add(3);
        moves.add(5);
        assertDoesNotThrow(() -> Utility.print(moves));
    }
}
