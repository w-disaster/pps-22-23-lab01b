package e1.logic;
import e1.Pair;

public class Pawn extends AbstractAgent {

    public Pawn(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean move(Pair<Integer, Integer> nextPosition) {
        return false;
    }
}
