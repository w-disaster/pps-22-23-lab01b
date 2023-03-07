package e2;

import e2.Pair;

public interface Logics {

    boolean explore(Pair<Integer, Integer> position);

    boolean isBomb(Pair<Integer, Integer> position);
    
}
