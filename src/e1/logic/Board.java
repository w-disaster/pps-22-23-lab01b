package e1.logic;

import e1.Pair;

public interface Board {

    Pair<Integer, Integer> getDimensions();

    boolean isInsideBounds(Pair<Integer, Integer> position);

}
