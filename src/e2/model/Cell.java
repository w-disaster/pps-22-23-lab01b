package e2.model;

import e2.Pair;
import e2.State;

import java.util.Optional;

public interface Cell {

    Pair<Integer, Integer> getPosition();

    Type getType();

    State getState();

    void setState(State state);

    Optional<Integer> getNumber();

    void setNumber(int numBombs);

}
