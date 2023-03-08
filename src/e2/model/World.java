package e2.model;

import e2.Pair;

import java.util.List;

public interface World {

    void disable(Pair<Integer, Integer> position, int number);

    List<Pair<Integer, Integer>> getPositionsFromType(Type type);

    Cell getCellFromPosition(Pair<Integer, Integer> position);

    int getSize();

}
