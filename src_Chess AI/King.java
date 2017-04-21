package deeper_blue;

import java.util.ArrayList;

public class King extends Piece {
	
	int value = 10000;
	
//-----------------------------------------------------------------------------------------------------------

	public King(int c, int r, int t) {
		col = c;
		row = r;
		
		if (t == 6) {
			symbol = "\u2654";
			name = "White King";
		}
		
		if (t == 12) {
			symbol = "\u265A";
			name = "Black King";
		}
		
		type = t;
	}
	
//-----------------------------------------------------------------------------------------------------------
	
	public ArrayList<Move> getMoves(Board b) {
		
		// List of Move objects returned by method
		ArrayList<Move> moves = new ArrayList<Move>();
		Board evalBoard = new Board(b.pListCopy());
		
		// First we check for White Kings
		if (type == 6) {
			
			eval = false;
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a black piece.
			if ((!((col-1) < 0)) && ((b.board[col-1][row] == 0) || (b.board[col-1][row] > 6))) {
				
				// Creates a new move for evaluation
				Move m1 = new Move(col, row, col-1, row, this);
				evalBoard = b.evalMove(m1);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("White King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col-1][row] > 6) {
								moves.add(new KillMove(col, row, col-1, row, this, b.getPiece(col-1, row, b.boardPList)));
								break;
							}
							else {
								moves.add(m1);
								break;
							}
						}
					}
				}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a black piece.
			if ((!((col+1) > 7)) && ((b.board[col+1][row] == 0) || (b.board[col+1][row] > 6))) {
				
				// Creates a new move for evaluation
				Move m2 = new Move(col, row, col+1, row, this);
				evalBoard = b.evalMove(m2);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("White King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col+1][row] > 6) {
								moves.add(new KillMove(col, row, col+1, row, this, b.getPiece(col+1, row, b.boardPList)));
								break;
							}
							else {
								moves.add(m2);
								break;
							}
						}
					}
				}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a black piece.
			if ((!((row-1) < 0)) && ((b.board[col][row-1] == 0) || (b.board[col][row-1] > 6))) {
				
				// Creates a new move for evaluation
				Move m3 = new Move(col, row, col, row-1, this);
				evalBoard = b.evalMove(m3);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("White King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col][row-1] > 6) {
								moves.add(new KillMove(col, row, col, row-1, this, b.getPiece(col, row-1, b.boardPList)));
								break;
							}
							else {
								moves.add(m3);
								break;
							}
						}
					}
				}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a black piece.
			if ((!((row+1) > 7)) && ((b.board[col][row+1] == 0) || (b.board[col][row+1] > 6))) {
				
				// Creates a new move for evaluation
				Move m4 = new Move(col, row, col, row+1, this);
				evalBoard = b.evalMove(m4);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("White King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col][row+1] > 6) {
								moves.add(new KillMove(col, row, col, row+1, this, b.getPiece(col, row+1, b.boardPList)));
								break;
							}
							else {
								moves.add(m4);
								break;
							}
						}
					}
				}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a black piece.
			if (!(((col-1) < 0) || ((row-1) < 0))) {
			if ((b.board[col-1][row-1] == 0) || (b.board[col-1][row-1] > 6)) {
				
				// Creates a new move for evaluation
				Move m5 = new Move(col, row, col-1, row-1, this);
				evalBoard = b.evalMove(m5);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("White King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col-1][row-1] > 6) {
								moves.add(new KillMove(col, row, col-1, row-1, this, b.getPiece(col-1, row-1, b.boardPList)));
								break;
							}
							else {
								moves.add(m5);
								break;
							}
						}
					}
				}
			}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a black piece.
			if (!(((col-1) < 0) || ((row+1) > 7))) {
			if ((b.board[col-1][row+1] == 0) || (b.board[col-1][row+1] > 6)) {
				
				// Creates a new move for evaluation
				Move m6 = new Move(col, row, col-1, row+1, this);
				evalBoard = b.evalMove(m6);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("White King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col-1][row+1] > 6) {
								moves.add(new KillMove(col, row, col-1, row+1, this, b.getPiece(col-1, row+1, b.boardPList)));
								break;
							}
							else {
								moves.add(m6);
								break;
							}
						}
					}
				}
			}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a black piece.
			if (!(((col+1) > 7) || ((row+1) > 7))) {
			if ((b.board[col+1][row+1] == 0) || (b.board[col+1][row+1] > 6)) {
				
				// Creates a new move for evaluation
				Move m7 = new Move(col, row, col+1, row+1, this);
				evalBoard = b.evalMove(m7);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("White King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col+1][row+1] > 6) {
								moves.add(new KillMove(col, row, col+1, row+1, this, b.getPiece(col+1, row+1, b.boardPList)));
								break;
							}
							else {
								moves.add(m7);
								break;
							}
						}
					}
				}
			}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a black piece.
			if (!(((col+1) > 7) || ((row-1) < 0))) {
			if ((b.board[col+1][row-1] == 0) || (b.board[col+1][row-1] > 6)) {
				
				// Creates a new move for evaluation
				Move m8 = new Move(col, row, col+1, row-1, this);
				evalBoard = b.evalMove(m8);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("White King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col+1][row-1] > 6) {
								moves.add(new KillMove(col, row, col+1, row-1, this, b.getPiece(col+1, row-1, b.boardPList)));
								break;
							}
							else {
								moves.add(m8);
								break;
							}
						}
					}
				}
			}
			}
			
			// Final conditional checks if we can castle
			if (!hasMoved) {
				for (Piece p : b.boardPList) {
					if (p.type == 4) {
						if (!p.hasMoved) {
							Move m9 = new Move(col, row, p.col, p.row, this);
							m9.setName("Castle");
							evalBoard = b.evalMove(m9);
							
							// Finds the King after evaluation and checks if he's at risk (in check)
							for (Piece piece : evalBoard.boardPList) {
								if (piece.getName().equals("White King")) {
									if (!piece.getRisk());
									moves.add(m9);
									break;
								}
							}
						}
					}
				}
			}
		}
		
		// Next we do it all over again for Black Kings
		if (type == 12) {
			
			eval = false;
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a white piece.
			if ((!((col-1) < 0)) && (b.board[col-1][row] < 7)) {
				
				// Creates a new move for evaluation
				Move m1 = new Move(col, row, col-1, row, this);
				evalBoard = b.evalMove(m1);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("Black King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col-1][row] != 0) {
								moves.add(new KillMove(col, row, col-1, row, this, b.getPiece(col-1, row, b.boardPList)));
								break;
							}
							else {
								moves.add(m1);
								break;
							}
						}
					}
				}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a white piece.
			if ((!((col+1) > 7)) && (b.board[col+1][row] < 7)) {
				
				// Creates a new move for evaluation
				Move m2 = new Move(col, row, col+1, row, this);
				evalBoard = b.evalMove(m2);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("Black King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col+1][row] > 0) {
								moves.add(new KillMove(col, row, col+1, row, this, b.getPiece(col+1, row, b.boardPList)));
								break;
							}
							else {
								moves.add(m2);
								break;
							}
						}
					}
				}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a white piece.
			if ((!((row-1) < 0)) && (b.board[col][row-1] < 7)) {
				
				// Creates a new move for evaluation
				Move m3 = new Move(col, row, col, row-1, this);
				evalBoard = b.evalMove(m3);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("Black King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col][row-1] > 0) {
						
								moves.add(new KillMove(col, row, col, row-1, this, b.getPiece(col, row-1, b.boardPList)));
								break;
							}
							else {
								moves.add(m3);
								break;
							}
						}
					}
				}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a white piece.
			if ((!((row+1) > 7)) && (b.board[col][row+1] < 7)) {
				
				// Creates a new move for evaluation
				Move m4 = new Move(col, row, col, row+1, this);
				evalBoard = b.evalMove(m4);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("Black King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col][row+1] > 0) {
								moves.add(new KillMove(col, row, col, row+1, this, b.getPiece(col, row+1, b.boardPList)));
								break;
							}
							else {
								moves.add(m4);
								break;
							}
						}
					}
				}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a white piece.
			if (!(((col-1) < 0) || ((row-1) < 0))) {
			if ((b.board[col-1][row-1] < 7)) {
				
				// Creates a new move for evaluation
				Move m5 = new Move(col, row, col-1, row-1, this);
				evalBoard = b.evalMove(m5);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("Black King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col-1][row-1] > 0) {
								moves.add(new KillMove(col, row, col-1, row-1, this, b.getPiece(col-1, row-1, b.boardPList)));
								break;
							}
							else {
								moves.add(m5);
								break;
							}
						}
					}
				}
			}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a black piece.
			if (!(((col-1) < 0) || ((row+1) > 7))) {
			if ((b.board[col-1][row+1] < 7)) {
			
				
				// Creates a new move for evaluation
				Move m6 = new Move(col, row, col-1, row+1, this);
				evalBoard = b.evalMove(m6);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("Black King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col-1][row+1] > 0) {
								moves.add(new KillMove(col, row, col-1, row+1, this, b.getPiece(col-1, row+1, b.boardPList)));
								break;
							}
							else {
								moves.add(m6);
								break;
							}
						}
					}
				}
			}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a white piece.
			if (!(((col+1) > 7) || ((row+1) > 7))) {
			if ((b.board[col+1][row+1] < 7)) {
				
				// Creates a new move for evaluation
				Move m7 = new Move(col, row, col+1, row+1, this);
				evalBoard = b.evalMove(m7);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("Black King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col+1][row+1] > 0) {
								moves.add(new KillMove(col, row, col+1, row+1, this, b.getPiece(col+1, row+1, b.boardPList)));
								break;
							}
							else {
								moves.add(m7);
								break;
							}
						}
					}
				}
			}
			}
			
			// This conditional checks that our move will be on the board and that the space will
			// either be empty or have a white piece.
			if (!(((col+1) > 7) || ((row-1) < 0))) {
			if ((b.board[col+1][row-1] < 7)) {
			
				
				// Creates a new move for evaluation
				Move m8 = new Move(col, row, col+1, row-1, this);
				evalBoard = b.evalMove(m8);
				
				// Finds the King after evaluation and checks if he's at risk (in check)				
				for (Piece p : evalBoard.boardPList) {
					if (p.getName().equals("Black King")) {
						
						// if not, checks whether we're moving to an empty space or taking a piece
						if (p.getRisk() == false) {
							if (b.board[col+1][row-1] > 0) {
								moves.add(new KillMove(col, row, col+1, row-1, this, b.getPiece(col+1, row-1, b.boardPList)));
								break;
							}
							else {
								moves.add(m8);
								break;
							}
						}
					}
				}
			}
			}
			
			// Final conditional checks if we can castle
			if (!hasMoved) {
				for (Piece p : b.boardPList) {
					if (p.type == 10) {
						if (!p.hasMoved) {
							Move m = new Move(col, row, p.col, p.row, this);
							m.setName("Castle");
							moves.add(m);
						}
					}
				}
			}
		}
		
		eval = true;
		legalMoves = moves;
		return moves;
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------------
}
