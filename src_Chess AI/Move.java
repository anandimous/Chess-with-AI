package deeper_blue;

public class Move {

	int c1;
	int r1;
	int c2;
	int r2;
	Piece piece;
	Piece killPiece;
	String name = "move";
	
	public Move(int col1, int row1, int col2, int row2, Piece p) {
		c1 = col1;
		r1 = row1;
		c2 = col2;
		r2 = row2;
		piece = p;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public Piece getKillPiece() {
		return killPiece;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String s) {
		name = s;
	}
}
