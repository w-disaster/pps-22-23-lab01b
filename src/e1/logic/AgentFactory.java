package e1.logic;

import e1.Pair;

import java.util.List;

public interface AgentFactory {

    Agent createKnightByPosition(Pair<Integer, Integer> position);

    Agent createRandomKnightWithoutCollide(List<Pair<Integer, Integer>> positions, int size);

    Agent createPawnByPosition(Pair<Integer, Integer> position);

    Agent createRandomPawnWithoutCollide(List<Pair<Integer, Integer>> positions, int size);

}
