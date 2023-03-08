package e2.model;

import java.util.List;

public interface WorldFactory {

    World createWorldWithRandomMines(int size, int numMines);

    World createWorldGivenMines(int size, List<MineCell> mines);
}
