package e1.logic;

import e1.Pair;

public class LogicsImpl implements Logics {

	private Board board;
	private Agent knight;
	private Agent pawn;
	 
    public LogicsImpl(Board board, Agent knight, Agent pawn){
		this.board = board;
		this.knight = knight;
		this.pawn = pawn;
    }
    
	@Override
	public boolean hit(Pair<Integer, Integer> position) {
		if (!this.board.isInsideBounds(position)) {
			throw new IndexOutOfBoundsException();
		}

		if (this.knight.move(position)) {
			return this.knight.getPosition().equals(this.pawn.getPosition());
		}
		return false;
	}

	@Override
	public Board getBoard() {
		return this.board;
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
