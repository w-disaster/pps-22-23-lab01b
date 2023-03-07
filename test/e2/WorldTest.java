package e2;

import e2.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {

    private WorldFactory worldFactory;
    private World world;
    private int size;

    private void testGridCells(List<BombCell> bombCells) {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                Pair<Integer, Integer> position = new Pair<>(row, col);
                if (bombCells.stream()
                        .anyMatch(b -> b.getPosition().equals(position))) {
                    assertTrue(this.world.getCells().contains(new BombCell(position, State.ENABLED)));
                } else {
                    assertTrue(this.world.getCells().contains(new EmptyCell(position, State.ENABLED)));
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
    void testWorldGivenValidBombCells() {
        List<BombCell> bombCells = List.of(new BombCell(new Pair<>(0, 0), State.ENABLED),
                new BombCell(new Pair<>(1, 1), State.ENABLED),
                new BombCell(new Pair<>(4, 4), State.ENABLED),
                new BombCell(new Pair<>(6, 6), State.ENABLED));
        this.world = this.worldFactory.createWorldGivenBombs(this.size, bombCells);
        testGridCells(bombCells);
    }

    @Test
    void testWorldGivenInvalidBombCells() {
        List<BombCell> bombCells = List.of(new BombCell(new Pair<>(0, 0), State.ENABLED),
                new BombCell(new Pair<>(1, 1), State.ENABLED),
                new BombCell(new Pair<>(10, 6), State.ENABLED));
        assertThrowsExactly(IndexOutOfBoundsException.class, () ->
                this.worldFactory.createWorldGivenBombs(this.size, bombCells));
    }

    @Test
    void testWorldWithRandomBombs() {
        this.world = this.worldFactory.createWorldWithRandomBombs(this.size);
        assertTrue(this.world.getCells().stream()
                .anyMatch(c -> c.getType().equals(Type.BOMB)));
    }

}
