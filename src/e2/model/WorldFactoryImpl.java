package e2.model;

import e2.Pair;
import e2.State;

import java.util.*;
import java.util.stream.Stream;

public class WorldFactoryImpl implements WorldFactory {

    private List<BombCell> initRandomBombCells(int size, int numBombs) {
        Random random = new Random();
        List<BombCell> bombCells = new ArrayList<>();

        for (int i = 0; i < numBombs; i++) {
            Pair<Integer, Integer> bombPosition =
                    new Pair<>(random.nextInt(size), random.nextInt(size));
            while (bombCells.stream()
                    .map(Cell::getPosition)
                    .toList()
                    .contains(bombPosition)) {
                bombPosition = new Pair<>(random.nextInt(size), random.nextInt(size));
            }
            bombCells.add(new BombCell(bombPosition, State.ENABLED));
        }
        return bombCells;
    }

    private List<Cell> initEmptyCells(int size, List<Pair<Integer, Integer>> excluded) {
        List<Cell> emptyCells = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Pair<Integer, Integer> position = new Pair<>(row, col);
                if (!excluded.contains(position)) {
                    emptyCells.add(new EmptyCell(position, State.ENABLED));
                }
            }
        }
        return emptyCells;
    }

    @Override
    public World createWorldWithRandomBombs(int size, int numBombs) {
        List<BombCell> bombCells = initRandomBombCells(size, numBombs);
        return createWorldGivenBombs(size, bombCells);
    }

    @Override
    public World createWorldGivenBombs(int size, List<BombCell> bombCells) {
        if(bombCells.stream()
                .map(CellImpl::getPosition)
                .anyMatch(b -> b.getX() >= size || b.getY() >= size)) {
            throw new IndexOutOfBoundsException();
        }
        List<Cell> emptyCells = initEmptyCells(size, bombCells.stream()
                .map(Cell::getPosition)
                .toList());
        return new WorldImpl(size, Stream.concat(bombCells.stream(), emptyCells.stream()).toList());
    }
}
