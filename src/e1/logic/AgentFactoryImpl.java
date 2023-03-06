package e1.logic;
import e1.Pair;

import java.util.List;
import java.util.Random;

public class AgentFactoryImpl implements AgentFactory {

    private Pair<Integer, Integer> randomPositionWithoutCollide(List<Pair<Integer, Integer>> positions, int size) {
        Random random = new Random();
        Pair<Integer,Integer> randomPosition = new Pair<>(random.nextInt(size), random.nextInt(size));

        while (positions.contains(randomPosition)) {
            randomPosition = new Pair<>(random.nextInt(size), random.nextInt(size));
        }
        return randomPosition;
    }

    @Override
    public Agent createKnightByPosition(Pair<Integer, Integer> position) {
        return new Knight(position);
    }

    @Override
    public Agent createRandomKnightWithoutCollide(List<Pair<Integer, Integer>> positions, int size) {
        return new Knight(randomPositionWithoutCollide(positions, size));
    }

    @Override
    public Agent createPawnByPosition(Pair<Integer, Integer> position) {
        return new Pawn(position);
    }

    @Override
    public Agent createRandomPawnWithoutCollide(List<Pair<Integer, Integer>> positions, int size) {
        return new Pawn(randomPositionWithoutCollide(positions, size));
    }

}
