package deeper_blue;

public class KillMove extends Move {


	public KillMove(int col1, int row1, int col2, int row2, Piece p, Piece kp) {
		super(col1, row1, col2, row2, p);
		
		killPiece = kp;
		killPiece.setRisk(true);
		name = "Kill Move";
	}
}
