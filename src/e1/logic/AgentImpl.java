package e1.logic;

import e1.Pair;

public abstract class AgentImpl implements Agent {

    protected Pair<Integer, Integer> position;

    public AgentImpl(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public abstract boolean move(Pair<Integer, Integer> nextPosition);

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
