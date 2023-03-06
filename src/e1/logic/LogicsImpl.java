package e1.logic;

import e1.Pair;

public class LogicsImpl implements Logics {

	private final int size;
	private Agent knight;
	private Agent pawn;
	 
    public LogicsImpl(Agent knight, Agent pawn, int size){
		this.knight = knight;
		this.pawn = pawn;
    	this.size = size;
    }

	private boolean isInsideBounds(Pair<Integer, Integer> position) {
		return !(position.getX() < 0 || position.getY() < 0 ||
				position.getX() >= this.size || position.getY() >= this.size);
	}
    
	@Override
	public boolean hit(Pair<Integer, Integer> position) {
		if (!isInsideBounds(position)) {
			throw new IndexOutOfBoundsException();
		}

		if (this.knight.move(position)) {
			return this.knight.getPosition().equals(this.pawn.getPosition());
		}
		return false;
	}

	@Override
	public Agent getKnight() {
		return this.knight;
	}

	@Override
	public Agent getPawn() {
		return this.pawn;
	}


}
