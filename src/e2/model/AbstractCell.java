package e2.model;

import e2.Pair;
import e2.State;

import java.util.Objects;
import java.util.Optional;

public abstract class AbstractCell implements Cell {

    private Pair<Integer, Integer> position;
    private Type type;
    private State state;

    public AbstractCell(Pair<Integer, Integer> position, Type type, State state) {
        this.position = position;
        this.type = type;
        this.state = state;
    }

    @Override
    public abstract Optional<Integer> getNumber();

    @Override
    public abstract void setNumber(int numBombs);

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCell cell = (AbstractCell) o;
        return Objects.equals(position, cell.position) && type == cell.type && state == cell.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, type, state);
    }
}
