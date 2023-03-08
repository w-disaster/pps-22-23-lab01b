package e2.logics;

import e2.Pair;
import e2.State;
import e2.model.Cell;
import e2.model.Type;
import e2.model.World;

import java.util.*;

public class LogicsImpl implements Logics {

    private World world;

    public LogicsImpl(World world) {
        this.world = world;
    }

    private boolean isInsideBounds(Pair<Integer, Integer> position) {
        return !(position.getX() < 0 || position.getY() < 0 ||
                position.getX() >= this.world.getSize() || position.getY() >= this.world.getSize());
    }

    private int numberOfAdjacentBombs(Pair<Integer, Integer> position) {
        int numBombs = 0;
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                if (!(xOffset == 0 && yOffset == 0)) {
                    Pair<Integer, Integer> neighbor = new Pair<>(position.getX() + xOffset,
                            position.getY() + yOffset);
                    System.out.println(neighbor);
                    if (isInsideBounds(neighbor)) {
                        if (this.world.getCellFromPosition(neighbor).getType().equals(Type.BOMB)) {
                            numBombs = numBombs + 1;
                        }
                    }
                }
            }
        }
        System.out.println(numBombs);
        return numBombs;
    }

    private void exploreAdjacentCells(Pair<Integer, Integer> position) {
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                if (!(xOffset == 0 && yOffset == 0)) {
                    Pair<Integer, Integer> neighbor = new Pair<>(position.getX() + xOffset,
                            position.getY() + yOffset);
                    if (isInsideBounds(neighbor)) {
                        if (this.world.getPositionsFromType(Type.EMPTY).contains(neighbor)) {
                            if (!this.world.getCellFromPosition(neighbor).getState().equals(State.DISABLED)) {
                                explore(neighbor);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean explore(Pair<Integer, Integer> position) {
        if (this.world.getCellFromPosition(position)
                .getType()
                .equals(Type.BOMB)) {
            return true;
        }
        int numBombs = numberOfAdjacentBombs(position);
        this.world.explore(position, numBombs);
        if (numBombs == 0) {
            exploreAdjacentCells(position);
        }
        return false;
    }

    @Override
    public boolean isWin() {
        for (int row = 0; row < this.world.getSize(); row++) {
            for (int col = 0; col < this.world.getSize(); col++) {
                Cell cell = this.world.getCellFromPosition(new Pair<>(row, col));
                if (cell.getType().equals(Type.EMPTY) && cell.getState().equals(State.ENABLED)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

}