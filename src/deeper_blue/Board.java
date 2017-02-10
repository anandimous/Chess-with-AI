package deeper_blue;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	int[][] board = new int[8][8]; // Represents the chess board.
	
	// The following constants represent the possible values a square on the board can hold.
	
	static final int 
	EMPTY = 0,
	WHITE_PAWN = 1,
	WHITE_KNIGHT = 2,
	WHITE_BISHOP = 3,
	WHITE_ROOK = 4,
	WHITE_QUEEN = 5,
	WHITE_KING = 6,
	BLACK_PAWN = 7,
	BLACK_KNIGHT = 8,
	BLACK_BISHOP = 9,
	BLACK_ROOK = 10,
	BLACK_QUEEN = 11,
	BLACK_KING = 12;
	
	public ArrayList<Piece> boardPList = new ArrayList<Piece>();
	public ArrayList<Move> boardMoves = new ArrayList<Move>();
	public ArrayList<Move> whiteMoves = new ArrayList<Move>();
	public ArrayList<Move> blackMoves = new ArrayList<Move>();
	public int currentPlayer;
	boolean evaluable = false;
	boolean gameInProgress = false;
	Random rand = new Random();

//-----------------------------------------------------------------------------------------------------------
	
	public Board(ArrayList<Piece> pList) {
		
		//Constructor builds a new board object for evaluation.
		
		board = new int[8][8];
		
		for(Piece p : pList) {
			board[p.col][p.row] = p.type;
		}
		boardPList = pList;
		currentPlayer = 0;
	}

//-----------------------------------------------------------------------------------------------------------
	
	public void update() {
		
		whiteMoves = new ArrayList<Move>();
		blackMoves = new ArrayList<Move>();
		
		for (Move m : boardMoves) {
			if (m.getPiece().type < 7) {
				whiteMoves.add(m);
			}
			else {
				blackMoves.add(m);
			}
		}
		
		if (currentPlayer == 1) {
			evaluable = true;
			makeMove(blackMoves.get(rand.nextInt(blackMoves.size())), this);
		}
	}
	
//-----------------------------------------------------------------------------------------------------------
	
	public Board() {}
	
//-----------------------------------------------------------------------------------------------------------
	
	public Piece getPiece(int c, int r, ArrayList<Piece> pList) {
		
		// Gets the corresponding piece for a square on the board.
		
		for(Piece p : pList) {
			if((p.col == c) && (p.row == r)){
				return p;
			}
		}
		return null;
	}

//-----------------------------------------------------------------------------------------------------------
	
	public double getScore() {
		
		// Returns the score of the board in its current layout.
		// FINISH ME
		
		return 0.0;
	}
	
//-----------------------------------------------------------------------------------------------------------

	public ArrayList<Move> getMoves() {
		
		ArrayList<Move> moves = new ArrayList<Move>();
		for (Piece p : boardPList) {
			
			if (p.getName().contains("King")) {
				if (p.eval == false) {
					continue;
				}
			}
			moves.addAll(p.getMoves(this));
		}
		
		for (Move m : moves) {
			if (m.getName().equals("Kill Move")) {
				if (m.getKillPiece().getName().contains("King")) {
					m.setName("Check");
				}
			}
		}
		return moves;
	}

//------------------------------------------------------------------------------------------------------------
	
	public ArrayList<Move> getWhiteMoves() {
		
		ArrayList<Move> moves = new ArrayList<Move>();
		for (Piece p : boardPList) {
			if (p.type < 7) {
				moves.addAll(p.getMoves(this));
			}
		}
		
		return moves;
	}
	
//------------------------------------------------------------------------------------------------------------
	
	public ArrayList<Move> getBlackMoves() {
			
		ArrayList<Move> moves = new ArrayList<Move>();
		for (Piece p : boardPList) {
			if (p.type < 7) {
				moves.addAll(p.getMoves(this));
			}
		}
			
		return moves;
	}
	
//------------------------------------------------------------------------------------------------------------
	
	public ArrayList<Piece> pListCopy() {
		
		ArrayList<Piece> copy = new ArrayList<Piece>();
		for (Piece p : this.boardPList) {
			
			if (p.name == "Pawn") {
				Pawn pawn = (new Pawn(p.col, p.row, p.type));
				if (p.getMoved()) {
					pawn.setMoved();
				}
				copy.add(pawn);
			}
			
			if (p.name == "Bishop") {
				Bishop bishop = (new Bishop(p.col, p.row, p.type));
				if (p.getMoved()) {
					bishop.setMoved();
				}
				copy.add(bishop);
			}
			
			if (p.name == "Knight") {
				Knight knight = (new Knight(p.col, p.row, p.type));
				if (p.getMoved()) {
					knight.setMoved();
				}
				copy.add(knight);
			}
			
			if (p.name == "Rook") {
				Rook rook = (new Rook(p.col, p.row, p.type));
				if (p.getMoved()) {
					rook.setMoved();
				}
				copy.add(rook);
			}
			
			if (p.name.contains("Queen")) {
				Queen queen = (new Queen(p.col, p.row, p.type));
				if (p.getMoved()) {
					queen.setMoved();
				}
				copy.add(queen);
			}
			
			if ((p.name.equals("Black King")) || (p.name.equals("White King"))) {
				King king = (new King(p.col, p.row, p.type));
				king.eval = p.eval;
				if (p.getMoved()) {
					king.setMoved();
				}
				copy.add(king);
			}
		}
		return copy;
	}
	
//------------------------------------------------------------------------------------------------------------
	
	public Board copy() {
		
		Board b = new Board(this.pListCopy());
		b.currentPlayer = this.currentPlayer;
		return b;
	}
	
//--------------------------------------------------------------------------------------------------------------
	
	public Board evalMove(Move m) {
		
		Board evalBoard = copy();
				
		makeMove(m, evalBoard);
		return evalBoard;
	}
	
//--------------------------------------------------------------------------------------------------------------
	
	public void makeMove(Move m, Board b) {
		Piece p = b.getPiece(m.c1, m.r1, b.boardPList);
		
		// Conditional handles cases of castling separately 
		
		if (m.getName().equals("Castle")) {
			Piece p2 = b.getPiece(m.c2, m.r2, b.boardPList);
			int temp = b.board[m.c1][m.r1];
			b.board[m.c1][m.r1] = b.board[m.c2][m.r2];
			b.board[m.c2][m.r2] = temp;
			
			// Changes the King's coordinates to those originally occupied by the rook
			p.col = m.c2;
			p.row = m.r2;
			
			// Changes the Rook's coordinates to those originally occupied by the king
			p2.col = m.c1;
			p2.row = m.r1;
			
			// Sets that both of the pieces have moved (so that you can't castle again)
			p.setMoved();
			p2.setMoved();
		}
		
		else {
		
			// Sets initial square to empty
			b.board[m.c1][m.r1] = 0;
		
			// Checks if new square has a piece in it, and removes that piece from the list
			if (b.board[m.c2][m.r2] != 0) {
				b.boardPList.remove(b.getPiece(m.c2, m.r2, b.boardPList));
			}
		
			// Sets the value of the new square to the value of our piece
			b.board[m.c2][m.r2] = p.type;
		
			// Changes the piece's coordinates to reflect the move
			p.col = m.c2;
			p.row = m.r2;
		
			p.setMoved();
		
		}
		
		for (Piece piece : b.boardPList) {
			piece.setRisk(false);
		}
		
		for (Piece checkPawn : b.boardPList) {
			if ((checkPawn.type == 1) && (checkPawn.row == 7)) {
				Queen whiteQueen = new Queen(checkPawn.col, checkPawn.row, 5);
				b.board[checkPawn.col][checkPawn.row] = 5;
				b.boardPList.remove(checkPawn);
				b.boardPList.add(whiteQueen);
				break;
				
			}
			
			if ((checkPawn.type == 7) && (checkPawn.row == 0)) {
				Queen blackQueen = new Queen(checkPawn.col, checkPawn.row, 11);
				b.board[checkPawn.col][checkPawn.row] = 11;
				b.boardPList.remove(checkPawn);
				b.boardPList.add(blackQueen);
				break;
			}
		}
		
		b.boardMoves = b.getMoves();
		
		// The following loop checks which player's turn it is and updates the message and pieces accordingly.
		
		b.playerSwap();
		
		for (Piece p2 : b.boardPList) {
			if (currentPlayer == 0) {
				ChessFrame.message.setText("White: make your move");
				if (p2.type < 7) {
					p2.setSelectable(true);
				}
				else {
					p2.setSelectable(false);
				}
			}
			if (currentPlayer == 1) {
				ChessFrame.message.setText("Black: make your move");
				if (p2.type > 6) {
					p2.setSelectable(true);
				}
				else {
					p2.setSelectable(false);
				}
			}
		}
		
		// The following loop checks the Kings for a possible Check mate.
		
		for (Piece p1 : b.boardPList) {
			if (p1.getName().equals("White King")) {
				if (p1.legalMoves.isEmpty() && p1.getRisk()) {
					ChessFrame.message.setText("White is in Checkmate. Black Wins!");
					ChessFrame.resign.setEnabled(false);
					ChessFrame.newGame.setEnabled(true);
					b.setProgress(false);
				}
			}
			
			if (p1.getName().equals("Black King")) {
				if (p1.legalMoves.isEmpty() && p1.getRisk()) {
					ChessFrame.message.setText("Black is in Checkmate. White Wins!");
					ChessFrame.resign.setEnabled(false);
					ChessFrame.newGame.setEnabled(true);
					b.setProgress(false);
				}
			}
		}
		
		b.update();
		b.evaluable = false;
	}
	
//---------------------------------------------------------------------------------------------------------------
	
		public void setProgress(boolean b) {
			gameInProgress = b;
		}
		
//------------------------------------------------------------------------------------------------------------
		
		public boolean getProgress() {
			return gameInProgress;
		}

//------------------------------------------------------------------------------------------------------------

		public void playerSwap() {
			if (currentPlayer == 0) {
				currentPlayer = 1;
			}
			else {
				currentPlayer = 0;
			}
		}

}



