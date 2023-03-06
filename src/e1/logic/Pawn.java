package e1.logic;
import e1.Pair;

public class Pawn implements Agent {

    private Pair<Integer, Integer> position;

    public Pawn(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public boolean move(Pair<Integer, Integer> nextPosition) {
        return false;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
