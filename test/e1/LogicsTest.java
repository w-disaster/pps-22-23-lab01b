package e1;

import e1.logic.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {

    private Logics logics;
    private Pair<Integer, Integer> initialKnightPosition;
    private Pair<Integer, Integer> initialPawnPosition;
    private static final int SIZE = 5;

    private List<Pair<Integer, Integer>> getPositionsByKightOffset(List<Pair<Integer, Integer>> offsets) {
        List<Pair<Integer, Integer>> positions = new ArrayList<>();
        for (Pair<Integer, Integer> off : offsets) {
            positions.add(new Pair<>(this.initialKnightPosition.getX() + off.getX(),
                    this.initialKnightPosition.getY() + off.getY()));
        }
        return positions;
    }

    @BeforeEach
    void beforeEach() {
        initialPawnPosition = new Pair<>(0, 0);
        initialKnightPosition = new Pair<>(3, 3);

        AgentFactory agentFactory = new AgentFactoryImpl();
        logics = new LogicsImpl(
                new BoardImpl(SIZE),
                agentFactory.createKnightByPosition(initialKnightPosition),
                agentFactory.createPawnByPosition(initialPawnPosition));
    }

    @Test
    void testAllowedKnightMoves() {
        List<Pair<Integer, Integer>> nextPositions =
                getPositionsByKightOffset(List.of(new Pair<>(-2, 1), new Pair<>(-2 , -1)));

        for (Pair<Integer, Integer> nextPosition : nextPositions) {
            assertFalse(logics.hit(nextPosition));
            assertEquals(nextPosition, logics.getKnight().getPosition());
            logics.hit(initialKnightPosition);
        }
    }

    @Test
    void testOutOfBoundsMoves() {
        List<Pair<Integer, Integer>> nextPositions =
                getPositionsByKightOffset(List.of(new Pair<>(2, 1), new Pair<>(1, 2)));

        for (Pair<Integer, Integer> nextPosition : nextPositions) {
            assertThrowsExactly(IndexOutOfBoundsException.class,
                    () -> logics.hit(nextPosition));
            assertEquals(initialKnightPosition, logics.getKnight().getPosition());
        }
    }

    @Test
    void testNotAllowedKnightMoves() {
        List<Pair<Integer, Integer>> nextPositions =
                getPositionsByKightOffset(List.of(new Pair<>(-3, 1), new Pair<>(1, 1)));

        for (Pair<Integer, Integer> nextPosition : nextPositions) {
            assertFalse(logics.hit(nextPosition));
            assertEquals(initialKnightPosition, logics.getKnight().getPosition());
        }
    }

    @Test
    void testWin() {
        Pair<Integer, Integer> nextKnightPosition = new Pair<>(2, 1);
        assertFalse(logics.hit(nextKnightPosition));
        assertEquals(logics.getKnight().getPosition(), nextKnightPosition);

        Pair<Integer, Integer> finalPosition = new Pair<>(0, 0);
        assertTrue(logics.hit(finalPosition));
    }

}
