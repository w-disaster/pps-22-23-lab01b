package e2;

import java.util.*;



public class LogicsImpl implements Logics {

    private int size;

    private Map<Pair<Integer, Integer>, State> bombCells;
    private Map<Pair<Integer, Integer>, Pair<State, Optional<Integer>>> normalCells;

    private static final int NUM_BOMBS = 5;

    private void initBombCells() {
        this.bombCells = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < NUM_BOMBS; i++) {
            Pair<Integer, Integer> bombPosition =
                    new Pair<>(random.nextInt(this.size), random.nextInt(this.size));
            while (this.bombCells.containsKey(bombPosition)) {
                bombPosition = new Pair<>(random.nextInt(this.size), random.nextInt(this.size));
            }
            this.bombCells.put(bombPosition, State.ENABLED);
        }
    }

    private void initNormalCells() {
        this.normalCells = new HashMap<>();
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                Pair<Integer, Integer> position = new Pair<>(row, col);
                if (!this.bombCells.containsKey(position)) {
                    this.normalCells.put(position, new Pair<>(State.ENABLED, Optional.empty()));
                }
            }
        }
    }

    private void initWorld() {
        initBombCells();
        initNormalCells();
    }

    public LogicsImpl(int size) {
        this.size = size;
        initWorld();
    }

    private boolean isInsideBounds(Pair<Integer, Integer> position) {
        return !(position.getX() < 0 || position.getY() < 0 ||
                position.getX() >= this.size || position.getY() >= this.size);
    }

    private Integer numberOfAdjacentBombs(Pair<Integer, Integer> position) {
        int numBombs = 0;
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                if (xOffset != 0 && yOffset != 0 && isInsideBounds(position)) {
                    Pair<Integer, Integer> neighbor = new Pair<>(position.getX() + xOffset,
                            position.getY() + yOffset);
                    if (isBomb(neighbor)) {
                        numBombs = numBombs + 1;
                    }
                }
            }
        }
        return numBombs;
    }

    private void exploreAdjacentCells(Pair<Integer, Integer> position) {
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                if (xOffset != 0 && yOffset != 0 && isInsideBounds(position)) {
                    Pair<Integer, Integer> neighbor = new Pair<>(position.getX() + xOffset,
                            position.getY() + yOffset);
                    if (this.normalCells.containsKey(neighbor)) {
                        if (this.normalCells.get(neighbor).getX().equals(State.ENABLED)) {
                            explore(neighbor);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean explore(Pair<Integer, Integer> position) {
        if (isBomb(position)) {
            return true;
        }
        int numBombs = numberOfAdjacentBombs(position);
        if (numBombs > 0) {
            this.normalCells.put(position, new Pair<>(State.DISABLED, Optional.of(numBombs)));
        } else {
            this.normalCells.put(position, new Pair<>(State.DISABLED, Optional.empty()));
            exploreAdjacentCells(position);
        }
        return false;
    }

    @Override
    public boolean isBomb(Pair<Integer, Integer> position) {
        return this.bombCells.containsKey(position);
    }
}