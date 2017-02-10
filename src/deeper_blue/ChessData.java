package deeper_blue;

import java.util.ArrayList;

public class ChessData {
	
	private ArrayList<Piece> pListWhite;
	private ArrayList<Piece> pListBlack;
	private ArrayList<Piece> pListFull;
	private ArrayList<Move> whiteMoves;
	private ArrayList<Move> blackMoves;
	
	ArrayList<Move> moves = new ArrayList<Move>();
	
	public Board gameBoard = new Board();
	public Node head;
	
//-----------------------------------------------------------------------------------------------------------
	public ChessData() {
		gameBoard = setUpGame();
		moves = gameBoard.getMoves();
		Node head = new Node(gameBoard, 2);
				
	}
	
//-----------------------------------------------------------------------------------------------------------
	
	public Board setUpGame() {
		
		// Method that sets up the starting game board and returns the board object
		
		pListWhite = new ArrayList<Piece>();
		for(int i = 0; i < 8; i++) {
			pListWhite.add(new Pawn(i, 1, 1));
		}
		pListWhite.add(new Bishop(2, 0, 3));
		pListWhite.add(new Bishop(5, 0, 3));
		pListWhite.add(new Knight(1, 0, 2));
		pListWhite.add(new Knight(6, 0, 2));
		pListWhite.add(new Rook(0, 0, 4));
		pListWhite.add(new Rook(7, 0, 4));
		pListWhite.add(new Queen(4, 0, 5));
		pListWhite.add(new King(3, 0, 6));
		
		pListBlack = new ArrayList<Piece>();
		for(int i = 0; i < 8; i ++) {
			pListBlack.add(new Pawn(i, 6, 7));
		}
		pListBlack.add(new Bishop(2, 7, 9));
		pListBlack.add(new Bishop(5, 7, 9));
		pListBlack.add(new Knight(1, 7, 8));
		pListBlack.add(new Knight(6, 7, 8));
		pListBlack.add(new Rook(0, 7, 10));
		pListBlack.add(new Rook(7, 7, 10));
		pListBlack.add(new Queen(4, 7, 11));
		pListBlack.add(new King(3, 7, 12));
		
		for (Piece p : pListBlack) {
			p.setSelectable(false);
		}
		
		pListFull = new ArrayList<Piece>();
		pListFull.addAll(pListWhite);
		pListFull.addAll(pListBlack);
		
		Board b = new Board(pListFull);

		return b;
	}
	
}//-----------------------------------------------------------------------------------------------------------
