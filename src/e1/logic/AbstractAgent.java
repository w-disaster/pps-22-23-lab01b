package e1.logic;

import e1.Pair;

public abstract class AbstractAgent implements Agent {

    protected Pair<Integer, Integer> position;

    public AbstractAgent(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public abstract boolean move(Pair<Integer, Integer> nextPosition);

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
