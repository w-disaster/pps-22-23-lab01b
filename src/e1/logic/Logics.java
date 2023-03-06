package e1.logic;

import e1.logic.Agent;

public interface Logics{
    
    /**
     * attempt to move Knight on position row,col, if possible
     * 
     * @param row
     * @param col
     * @return whether the pawn has been hit 
     */
    boolean hit(int row, int col);

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
