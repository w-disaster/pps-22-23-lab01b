package e2.model;

import e2.Pair;
import e2.State;

import java.util.*;

public class WorldImpl implements World {

    private int size;
    private List<Cell> cells;

    public WorldImpl(int size, List<Cell> cells) {
        this.size = size;
        this.cells = cells;
    }

    @Override
    public List<Cell> getCells() {
        return this.cells;
    }

    @Override
    public int getSize() {
        return this.size;
    }

}
