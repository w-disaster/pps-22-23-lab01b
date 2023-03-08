package e2.model;

import e2.Pair;
import e2.State;

import java.util.Optional;

public class MineCell extends CellImpl {

    public MineCell(Pair<Integer, Integer> position) {
        super(position, Type.MINE, State.ENABLED);
    }

    @Override
    public Optional<Integer> getNumber() {
        return Optional.empty();
    }

    @Override
    public void setNumber(int number) {}
}
