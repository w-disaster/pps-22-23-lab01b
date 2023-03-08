package e1.logic;
import e1.Pair;

public class Knight extends AgentImpl {

    public Knight(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean move(Pair<Integer, Integer> nextPosition) {
        int x = this.position.getX() - nextPosition.getX();
        int y = this.position.getY() - nextPosition.getY();
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            this.position = nextPosition;
            return true;
        }
        return false;
    }

}
