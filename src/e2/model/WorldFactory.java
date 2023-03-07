package e2.model;

import java.util.List;

public interface WorldFactory {

    World createWorldWithRandomBombs(int size);

    World createWorldGivenBombs(int size, List<BombCell> bombs);
}
