package e2;

import e2.logic.Logics;
import e2.logic.LogicsImpl;
import e2.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {

    private Logics logics;
    private static final int SIZE = 3;

    @BeforeEach
    void beforeEach() {
        this.logics = new LogicsImpl(new WorldFactoryImpl().createWorldGivenMines(SIZE,
                List.of(new MineCell(new Pair<>(0, 1)),
                        new MineCell(new Pair<>(0, 2)))));
    }

    @Test
    void testWin() {
        assertFalse(this.logics.explore(new Pair<>(0, 0)));
        assertFalse(this.logics.explore(new Pair<>(2, 1)));
        assertTrue(this.logics.isWin());
    }

    @Test
    void testLose() {
        assertFalse(this.logics.explore(new Pair<>(0, 0)));
        assertTrue(this.logics.explore(new Pair<>(0, 1)));
    }

    @Test
    void testNumber() {
        Pair<Integer, Integer> firstPosition = new Pair<>(0, 0);
        assertFalse(this.logics.explore(firstPosition));
        assertEquals(this.logics.getWorld().getCellFromPosition(firstPosition).getNumber(), Optional.of(1));
        Pair<Integer, Integer> secondPosition = new Pair<>(2, 1);
        assertFalse(this.logics.explore(secondPosition));
        for (int yOffset = -1; yOffset <= 1; yOffset++) {
            assertEquals(this.logics.getWorld()
                    .getCellFromPosition(new Pair<>(secondPosition.getX(),secondPosition.getY() + yOffset))
                    .getNumber(), Optional.of(0));
        }
    }

}
