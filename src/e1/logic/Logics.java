package e1.logic;

import e1.Pair;
import e1.logic.Agent;

public interface Logics{

    /**
     * attempt to move knight on position if possible
     *
     * @param position
     * @return whether the pawn has been hit
     */
    boolean hit(Pair<Integer, Integer> position);

    /**
     *
     * @return the board
     */
    Board getBoard();

    /**
     *
     * @return the knight inside the grid
     */
    Agent getKnight();

    /**
     *
     * @return the pawn inside the grid
     */
    Agent getPawn();

}
