package e1.logic;

import e1.Pair;

public class BoardImpl implements Board {

    Pair<Integer, Integer> dimensions;

    public BoardImpl(Pair<Integer, Integer> dimensions) {
        this.dimensions = dimensions;
    }

    public BoardImpl(int dimension) {
        this.dimensions = new Pair<>(dimension, dimension);
    }

    @Override
    public Pair<Integer, Integer> getDimensions() {
        return this.dimensions;
    }

    @Override
    public boolean isInsideBounds(Pair<Integer, Integer> position) {
        return !(position.getX() < 0 || position.getY() < 0 ||
                position.getX() >= this.dimensions.getX() || position.getY() >= this.dimensions.getY());
    }
}
