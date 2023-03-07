package e2.model;

import e2.Pair;
import e2.State;

import java.util.Optional;

public class BombCell extends CellImpl {

    public BombCell(Pair<Integer, Integer> position, State state) {
        super(position, Type.BOMB, state);
    }

    @Override
    public Optional<Integer> getNumAdjacentBombs() {
        return Optional.empty();
    }

    @Override
    public void setNumAdjacentBombs(int numBombs) {}
}
