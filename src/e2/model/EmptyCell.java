package e2.model;

import e2.Pair;
import e2.State;

import java.util.Optional;

public class EmptyCell extends CellImpl {

    private Optional<Integer> numAdjacentBombs;

    public EmptyCell(Pair<Integer, Integer> position, State state) {
        super(position, Type.EMPTY, state);
        this.numAdjacentBombs = Optional.empty();
    }

    @Override
    public Optional<Integer> getNumAdjacentBombs() {
        return this.numAdjacentBombs;
    }

    @Override
    public void setNumAdjacentBombs(int numBombs) {
        this.numAdjacentBombs = Optional.of(numBombs);
    }
}
