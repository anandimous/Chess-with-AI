package deeper_blue;

import java.util.ArrayList;

public class Rook extends Piece {
	
	int value = 5;
	
//-----------------------------------------------------------------------------------------------------------
	
	public Rook(int c, int r, int t) {
		col = c;
		row = r;
		
		if (t == 4) {
			symbol = "\u2656";
		}
		if (t == 10) {
			symbol = "\u265C";
		}
		type = t;
		name = "Rook";
	}
	
//-----------------------------------------------------------------------------------------------------------
	
	public ArrayList<Move> getMoves(Board b) {
		
		// List of Move objects returned by the method
		ArrayList<Move> moves = new ArrayList<Move>();
		
		// First we check moves for White Rooks
		if (type == 4) {
			
			// Separate loops determine open paths for each 
			// of the four possible directions
			
			// First loop evaluates moving upwards
			for (int i = 1; i < 8; i++) {
				
				// First we check that we're not off of the board
				if ((row-i) < 0) {
					break;
				}
				
				// Next we check if there are other White pieces, which ends the path
				if ((b.board[col][row-i] < 7) && (b.board[col][row-i] > 0)) {
					break;
				}
				
				// Next we check if there are any Black pieces, which creates a KillMove and ends the path
				if (b.board[col][row-i] > 6) {
					moves.add(new KillMove(col, row, col, row-i, this, b.getPiece(col, row-i, b.boardPList)));
					break;
				}
				
				// Finally we check if the space is empty, and the path (and loop) continue
				if (b.board[col][row-i] == 0) {
					moves.add(new Move(col, row, col, row-i, this));
				}
			}
			
			// Second loop evaluates moving right
			for (int i = 1; i < 8; i++) {
				
				//First we check that we're not off of the board
				if ((col+i) > 7) {
					break;
				}
				
				// Next we check if there are other White pieces, which ends the path
				if ((b.board[col+i][row] < 7) && (b.board[col+i][row] > 0)) {
					break;
				}
				
				// Next we check if there are any Black pieces, which creates a KillMove and ends the path
				if (b.board[col+i][row] > 6) {
					moves.add(new KillMove(col, row, col+i, row, this, b.getPiece(col+i, row, b.boardPList)));
					break;
				}
				
				// Finally we check if the space is empty, and the path (and loop) continue
				if (b.board[col+i][row] == 0) {
					moves.add(new Move(col, row, col+i, row, this));
				}
			}
			
			// Third loop evaluates moving downwards
			for (int i = 1; i < 8; i++) {
				
				// First we check that we're not off of the board
				if ((row+i) > 7) {
					break;
				}
				
				// Next we check if there are other White pieces, which ends the path
				if ((b.board[col][row+i] < 7) && (b.board[col][row+i] > 0)) {
					break;
				}
				
				// Next we check if there are any Black pieces, which creates a KillMove and ends the path
				if (b.board[col][row+i] > 6) {
					moves.add(new KillMove(col, row, col, row+i, this, b.getPiece(col, row+i, b.boardPList)));
					break;
				}
				
				// Finally we check if the space is empty, and the path (and loop) continue
				if (b.board[col][row+i] == 0) {
					moves.add(new Move(col, row, col, row+i, this));
				}
			}
			
			// Final loop evaluates moving left
			for (int i = 1; i < 8; i++) {
				
				// First we check that we're not off of the board
				if ((col-i) < 0) {
					break;
				}
				
				// Next we check if there are other White pieces, which ends the path
				if ((b.board[col-i][row] < 7) && (b.board[col-i][row] > 0)) {
					break;
				}
				
				// Next we check if there are any Black pieces, which creates a KillMove and ends the path
				if (b.board[col-i][row] > 6) {
					moves.add(new KillMove(col, row, col-i, row, this, b.getPiece(col-i, row, b.boardPList)));
					break;
				}
				
				// Finally we check if the space is empty, and the path (and loop) continue
				if (b.board[col-i][row] == 0) {
					moves.add(new Move(col, row, col-i, row, this));
				}
			}
		}
		
		// Next we check moves for Black Rooks
				if (type == 10) {
					
					// Separate loops determine open paths for each 
					// of the four possible directions
					
					// First loop evaluates moving upwards
					for (int i = 1; i < 8; i++) {
						
						// First we check that we're not off of the board
						if ((row-i) < 0) {
							break;
						}
						
						// Next we check if there are other Black pieces, which ends the path
						if (b.board[col][row-i] > 6) {
							break;
						}
						
						// Next we check if there are any White pieces, which creates a KillMove and ends the path
						if ((b.board[col][row-i] < 7) && (b.board[col][row-i] > 0)) {
							moves.add(new KillMove(col, row, col, row-i, this, b.getPiece(col, row-i, b.boardPList)));
							break;
						}
						
						// Finally we check if the space is empty, and the path (and loop) continue
						if (b.board[col][row-i] == 0) {
							moves.add(new Move(col, row, col, row-i, this));
						}
					}
					
					// Second loop evaluates moving right
					for (int i = 1; i < 8; i++) {
						
						//First we check that we're not off of the board
						if ((col+i) > 7) {
							break;
						}
						
						// Next we check if there are other Black pieces, which ends the path
						if (b.board[col+i][row] > 6) {
							break;
						}
						
						// Next we check if there are any White pieces, which creates a KillMove and ends the path
						if ((b.board[col+i][row] < 7) && (b.board[col+i][row] > 0)) {
							moves.add(new KillMove(col, row, col+i, row, this, b.getPiece(col+i, row, b.boardPList)));
							break;
						}
						
						// Finally we check if the space is empty, and the path (and loop) continue
						if (b.board[col+i][row] == 0) {
							moves.add(new Move(col, row, col+i, row, this));
						}
					}
					
					// Third loop evaluates moving downwards
					for (int i = 1; i < 8; i++) {
						
						// First we check that we're not off of the board
						if ((row+i) > 7) {
							break;
						}
						
						// Next we check if there are other Black pieces, which ends the path
						if (b.board[col][row+i] > 6) {
							break;
						}
						
						// Next we check if there are any White pieces, which creates a KillMove and ends the path
						if ((b.board[col][row+i] < 7) && (b.board[col][row+i] > 0)) {
							moves.add(new KillMove(col, row, col, row+i, this, b.getPiece(col, row+i, b.boardPList)));
							break;
						}
						
						// Finally we check if the space is empty, and the path (and loop) continue
						if (b.board[col][row+i] == 0) {
							moves.add(new Move(col, row, col, row+i, this));
						}
					}
					
					// Final loop evaluates moving left
					for (int i = 1; i < 8; i++) {
						
						// First we check that we're not off of the board
						if ((col-i) < 0) {
							break;
						}
						
						// Next we check if there are other Black pieces, which ends the path
						if (b.board[col-i][row] > 6) {
							break;
						}
						
						// Next we check if there are any White pieces, which creates a KillMove and ends the path
						if ((b.board[col-i][row] < 7) && (b.board[col-i][row] > 0)) {
							moves.add(new KillMove(col, row, col-i, row, this, b.getPiece(col-i, row, b.boardPList)));
							break;
						}
						
						// Finally we check if the space is empty, and the path (and loop) continue
						if (b.board[col-i][row] == 0) {
							moves.add(new Move(col, row, col-i, row, this));
						}
					}
				}
		
		return moves;	
	}
//---------------------------------------------------------------------------------------------------------------------
}
