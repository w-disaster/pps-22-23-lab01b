package e2.model;

import e2.Pair;
import e2.State;

import java.util.*;

public class WorldImpl implements World {

    private int size;
    private List<Cell> cells;

    public WorldImpl(int size, List<Cell> cells) {
        this.size = size;
        this.cells = cells;
    }

    @Override
    public void disable(Pair<Integer, Integer> position, int number) {
        Cell cell = this.getCellFromPosition(position);
        if (cell.getState().equals(State.ENABLED)) {
            cell.setState(State.DISABLED);
            cell.setNumber(number);
        }
    }

    @Override
    public List<Pair<Integer, Integer>> getPositionsFromType(Type type) {
        return this.cells.stream()
                .filter(c -> c.getType().equals(type))
                .map(Cell::getPosition)
                .toList();
    }

    @Override
    public Cell getCellFromPosition(Pair<Integer, Integer> position) {
        Optional<Cell> cell = this.cells.stream()
                .filter(c -> c.getPosition().equals(position))
                .findFirst();
        if (cell.isPresent()) {
            return cell.get();
        }
        throw new IndexOutOfBoundsException();
    }


    @Override
    public int getSize() {
        return this.size;
    }

}
