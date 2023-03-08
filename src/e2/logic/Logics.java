package e2.logic;

import e2.Pair;
import e2.model.World;

public interface Logics {

    boolean explore(Pair<Integer, Integer> position);

    boolean isWin();

    World getWorld();

}
