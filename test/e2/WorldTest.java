package e2;

import e2.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {

    private WorldFactory worldFactory;
    private World world;
    private int size;

    private void testGridCells(List<MineCell> mineCells) {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                Pair<Integer, Integer> position = new Pair<>(row, col);
                if (mineCells.stream()
                        .anyMatch(b -> b.getPosition().equals(position))) {
                    assertEquals(this.world.getCellFromPosition(position).getType(), Type.MINE);
                } else {
                    assertEquals(this.world.getCellFromPosition(position).getType(), Type.EMPTY);
                }
            }
        }
    }

    @BeforeEach
    void beforeEach() {
        this.size = 10;
        this.worldFactory = new WorldFactoryImpl();
    }

    @Test
    void testWorldGivenValidMines() {
        List<MineCell> mineCells = List.of(new MineCell(new Pair<>(0, 0)),
                new MineCell(new Pair<>(1, 1)),
                new MineCell(new Pair<>(4, 4)),
                new MineCell(new Pair<>(6, 6)));
        this.world = this.worldFactory.createWorldGivenMines(this.size, mineCells);
        testGridCells(mineCells);
    }

    @Test
    void testWorldGivenInvalidMines() {
        List<MineCell> mineCells = List.of(new MineCell(new Pair<>(0, 0)),
                new MineCell(new Pair<>(1, 1)),
                new MineCell(new Pair<>(10, 6)));
        assertThrowsExactly(IndexOutOfBoundsException.class, () ->
                this.worldFactory.createWorldGivenMines(this.size, mineCells));
    }

    @Test
    void testWorldWithRandomMines() {
        this.world = this.worldFactory.createWorldWithRandomMines(this.size, this.size);
        assertFalse(this.world.getPositionsFromType(Type.MINE).isEmpty());
    }

}
