package e1.logic;

import e1.Pair;

public interface Agent {

    boolean move(Pair<Integer, Integer> nextPosition);

    Pair<Integer, Integer> getPosition();

}
