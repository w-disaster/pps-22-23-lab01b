package e1.logic;
import e1.Pair;

public class Knight implements Agent  {

    Pair<Integer, Integer> position;

    public Knight(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public boolean move(Pair<Integer, Integer> nextPosition) {
        int x = position.getX() - nextPosition.getX();
        int y = position.getY() - nextPosition.getY();
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            this.position = nextPosition;
            return true;
        }
        return false;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

}
