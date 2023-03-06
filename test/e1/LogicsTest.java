package e1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {

    private Logics logics;
    private Pair<Integer, Integer> knightPosition;
    private Pair<Integer, Integer> pawnPosition;
    private static final int SIZE = 5;

    private Pair<Integer, Integer> getKnightPosition() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (logics.hasKnight(row, col)) {
                    return new Pair<>(row, col);
                }
            }
        }
        return new Pair<>(SIZE, SIZE);
    }

    private Pair<Integer, Integer> getPawnPosition() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (logics.hasPawn(row, col)) {
                    return new Pair<>(row, col);
                }
            }
        }
        return new Pair<>(SIZE, SIZE);
    }

    @BeforeEach
    void beforeEach() {
        pawnPosition = new Pair<>(0, 0);
        knightPosition = new Pair<>(3, 3);
        logics = new LogicsImpl(pawnPosition, knightPosition, SIZE);
    }

    @Test
    void testAllowedKnightMoves() {
        Pair<Integer, Integer> initialKnightPosition = knightPosition;
        List<Pair<Integer, Integer>> nextPositions = List.of(
                new Pair<>(initialKnightPosition.getX() - 2, initialKnightPosition.getY() + 1),
                new Pair<>(initialKnightPosition.getX() - 2, initialKnightPosition.getY() - 1));

        for (Pair<Integer, Integer> nextPosition : nextPositions) {
            if (!nextPosition.equals(getPawnPosition())) {
                assertFalse(logics.hit(nextPosition.getX(), nextPosition.getY()));
                assertEquals(nextPosition, getKnightPosition());
                logics.hit(initialKnightPosition.getX(), initialKnightPosition.getY());
            } else {
                assertTrue(logics.hit(nextPosition.getX(), nextPosition.getY()));
            }
        }
    }

    @Test
    void testOutOfBoundsMoves() {
        Pair<Integer, Integer> initialKnightPosition = knightPosition;
        List<Pair<Integer, Integer>> nextPositions = List.of(
                new Pair<>(initialKnightPosition.getX() + 2, initialKnightPosition.getY() + 1),
                new Pair<>(initialKnightPosition.getX() + 1, initialKnightPosition.getY() + 2));

        for (Pair<Integer, Integer> nextPosition : nextPositions) {
            assertThrowsExactly(IndexOutOfBoundsException.class,
                    () -> logics.hit(nextPosition.getX(), nextPosition.getY()));
            assertEquals(knightPosition, getKnightPosition());
        }
    }

    @Test
    void testNotAllowedKnightMoves() {
        Pair<Integer, Integer> initialKnightPosition = knightPosition;
        List<Pair<Integer, Integer>> nextPositions = List.of(
                new Pair<>(initialKnightPosition.getX() - 3, initialKnightPosition.getY() + 1),
                new Pair<>(initialKnightPosition.getX() + 1, initialKnightPosition.getY() + 1));

        for (Pair<Integer, Integer> nextPosition : nextPositions) {
            assertFalse(logics.hit(nextPosition.getX(), nextPosition.getY()));
            assertEquals(knightPosition, getKnightPosition());
        }
    }

}
