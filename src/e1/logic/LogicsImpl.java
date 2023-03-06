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
    
	@Override
	public boolean hit(int row, int col) {
		if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}

		if (this.knight.move(new Pair<>(row, col))) {
			return this.knight.getPosition().equals(this.pawn.getPosition());
		};
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
