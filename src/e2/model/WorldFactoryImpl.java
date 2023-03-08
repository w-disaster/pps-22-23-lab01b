package e2.model;

import e2.Pair;

import java.util.*;
import java.util.stream.Stream;

public class WorldFactoryImpl implements WorldFactory {

    private List<MineCell> initRandomMineCells(int size, int numMines) {
        Random random = new Random();
        List<MineCell> mineCells = new ArrayList<>();

        for (int i = 0; i < numMines; i++) {
            Pair<Integer, Integer> minePosition =
                    new Pair<>(random.nextInt(size), random.nextInt(size));
            while (mineCells.stream()
                    .map(Cell::getPosition)
                    .toList()
                    .contains(minePosition)) {
                minePosition = new Pair<>(random.nextInt(size), random.nextInt(size));
            }
            mineCells.add(new MineCell(minePosition));
        }
        return mineCells;
    }

    private List<Cell> initEmptyCells(int size, List<Pair<Integer, Integer>> excluded) {
        List<Cell> emptyCells = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Pair<Integer, Integer> position = new Pair<>(row, col);
                if (!excluded.contains(position)) {
                    emptyCells.add(new EmptyCell(position));
                }
            }
        }
        return emptyCells;
    }

    @Override
    public World createWorldWithRandomMines(int size, int numMines) {
        List<MineCell> mineCells = initRandomMineCells(size, numMines);
        return createWorldGivenMines(size, mineCells);
    }

    @Override
    public World createWorldGivenMines(int size, List<MineCell> mines) {
        if(mines.stream()
                .map(CellImpl::getPosition)
                .anyMatch(b -> b.getX() >= size || b.getY() >= size)) {
            throw new IndexOutOfBoundsException();
        }
        List<Cell> emptyCells = initEmptyCells(size, mines.stream()
                .map(Cell::getPosition)
                .toList());
        return new WorldImpl(size, Stream.concat(mines.stream(), emptyCells.stream()).toList());
    }
}
