package e2.model;

import e2.Pair;
import e2.State;

public interface Cell {

    Pair<Integer, Integer> getPosition();

    Type getType();

    State getState();

    void setState(State state);

}
