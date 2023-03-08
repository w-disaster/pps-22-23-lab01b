package e2.model;

import e2.Pair;
import e2.State;

import java.util.Optional;

public class EmptyCell extends AbstractCell {

    private Optional<Integer> number;

    public EmptyCell(Pair<Integer, Integer> position) {
        super(position, Type.EMPTY, State.ENABLED);
        this.number = Optional.empty();
    }

    @Override
    public Optional<Integer> getNumber() {
        return this.number;
    }

    @Override
    public void setNumber(int number) {
        this.number = Optional.of(number);
    }
}
