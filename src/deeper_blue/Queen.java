package deeper_blue;

import java.util.ArrayList;

public class Queen extends Piece {
	
	int value = 9;
	
//---------------------------------------------------------------------------------------------------------
	
	public Queen(int c, int r, int t) {
		col = c;
		row = r;
		
		if (t == 5) {
			symbol = "\u2655";
		}
		
		if (t == 11) {
			symbol = "\u265B";
		}
		
		type = t;
		name = "Queen";
	}
	
//----------------------------------------------------------------------------------------------------------
	
	public ArrayList<Move> getMoves(Board b) {
		
		// List of Move objects returned by method
		ArrayList<Move> moves = new ArrayList<Move>();
		
		// Queen's moves are effectively a combination of Bishop and Rook,
		// so loops have been borrowed and adapted from these two classes.
		
		// First we evaluate for White Queens
		if (type == 5) {
			
			// Reused from the Bishop class
			// First loop evaluates down and left
			for(int i = 1; i < 8; i++) {
				
				// First we check if we're off the board (to avoid IndexOutOfBounds exceptions)
				if(((col-i) < 0) || ((row+i) > 7)) {
					break;
				}
				
				// Next we check if the square we're looking at has a White piece on it, which ends the path.
				if((b.board[col-i][row+i] > 0) && (b.board[col-i][row+i] < 7)) {
					break;
				}
				
				// Next we check if the square we're looking at has a Black piece on it, which also ends the path.
				if(b.board[col-i][row+i] > 6) {
					moves.add(new KillMove(col, row, col-i, row+i, this, b.getPiece(col-i, row+i, b.boardPList)));
					break;
				}
				
				// Next we check if the square we're looking at is open, and the loop continues.
				if(b.board[col-i][row+i] == 0) {
					moves.add(new Move(col, row, col-i, row+i, this));
				}
			}
			
			// Next loop evaluates down and right
			// (All conditionals are doing the same thing but for a different direction)
			for(int i = 1; i < 8; i++) {
				
				if(((col+i) > 7) || ((row+i) > 7)) {
					break;
				}
				
				if((b.board[col+i][row+i] > 0) && (b.board[col+i][row+i] < 7)) {
					break;
				}
				
				if(b.board[col+i][row+i] > 6) {
					moves.add(new KillMove(col, row, col+i, row+i, this, b.getPiece(col+i, row+i, b.boardPList)));
					break;
				}
				
				if(b.board[col+i][row+i] == 0) {
					moves.add(new Move(col, row, col+i, row+i, this));
				}
			}
			
			// Next loop evaluates up and left
			// (All conditionals are doing the same thing but for a different direction)
			for (int i = 1; i < 8; i++) {
				
				if(((col-i) < 0) || ((row-i) < 0)) {
					break;
				}
				
				if((b.board[col-i][row-i] > 0) && (b.board[col-i][row-i] < 7)) {
					break;
				}
				
				if(b.board[col-i][row-i] > 6) {			
					moves.add(new KillMove(col, row, col-i, row-i, this, b.getPiece(col-i, row-i, b.boardPList)));
					break;
				}
				
				if(b.board[col-i][row-i] == 0) {
					moves.add(new Move(col, row, col-i, row-i, this));
				}
			}
			
			// Final for loop evaluates up and right
			// (All conditionals are doing the same thing but for a different direction)
			for (int i = 1; i < 8; i++) {
				
				if(((col+i) > 7) || ((row-i) < 0)) {
					break;
				}
				
				if((b.board[col+i][row-i] > 0) && (b.board[col+i][row-i] < 7)) {
					break;
				}
				
				if(b.board[col+i][row-i] > 6) {
					moves.add(new KillMove(col, row, col+i, row-i, this, b.getPiece(col+i, row-i, b.boardPList)));
					break;
				}
				
				if(b.board[col+i][row-i] == 0) {
					moves.add(new Move(col, row, col+i, row-i, this));
				}
			}
			
			// Reused from Rook class
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
		
		if (type == 11) {
			
			// Reused from the Bishop class
			// First loop evaluates down and left
			for(int i = 1; i < 8; i++) {
				
				// First we check if we're off the board (to avoid IndexOutOfBounds exceptions)
				if(((col-i) < 0) || ((row+i) > 7)) {
					break;
				}
				
				// Next we check if the square we're looking at has a Black piece on it, which ends the path.
				if(b.board[col-i][row+i] > 6) {
					break;
				}
				
				// Next we check if the square we're looking at has a White piece on it, which also ends the path.
				if((b.board[col-i][row+i] < 7) && (b.board[col-i][row+i] > 0)) {
					moves.add(new KillMove(col, row, col-i, row+i, this, b.getPiece(col-i, row+i, b.boardPList)));
					break;
				}
				
				// Next we check if the square we're looking at is open, and the loop continues.
				if(b.board[col-i][row+i] == 0) {
					moves.add(new Move(col, row, col-i, row+i, this));
				}
			}
			
			// Next loop evaluates down and right
			// (All conditionals are doing the same thing but for a different direction)
			for(int i = 1; i < 8; i++) {
				
				if(((col+i) > 7) || ((row+i) > 7)) {
					break;
				}
				
				if(b.board[col+i][row+i] > 6) {
					break;
				}
				
				if((b.board[col+i][row+i] < 7) && (b.board[col+i][row+i] > 0)) {
					moves.add(new KillMove(col, row, col+i, row+i, this, b.getPiece(col+i, row+i, b.boardPList)));
					break;
				}
				
				if(b.board[col+i][row+i] == 0) {
					moves.add(new Move(col, row, col+i, row+i, this));
				}
			}
			
			// Next loop evaluates up and left
			// (All conditionals are doing the same thing but for a different direction)
			for (int i = 1; i < 8; i++) {
				
				if(((col-i) < 0) || ((row-i) < 0)) {
					break;
				}
				
				if(b.board[col-i][row-i] > 6) {
					break;
				}
				
				if((b.board[col-i][row-i] < 7) && (b.board[col-i][row-i] > 0)) {			
					moves.add(new KillMove(col, row, col-i, row-i, this, b.getPiece(col-i, row-i, b.boardPList)));
					break;
				}
				
				if(b.board[col-i][row-i] == 0) {
					moves.add(new Move(col, row, col-i, row-i, this));
				}
			}
			
			// Final for loop evaluates up and right
			// (All conditionals are doing the same thing but for a different direction)
			for (int i = 1; i < 8; i++) {
				
				if(((col+i) > 7) || ((row-i) < 0)) {
					break;
				}
				
				if(b.board[col+i][row-i] > 6) {
					break;
				}
				
				if((b.board[col+i][row-i] < 7) && (b.board[col+i][row-i] > 0 )) {
					moves.add(new KillMove(col, row, col+i, row-i, this, b.getPiece(col+i, row-i, b.boardPList)));
					break;
				}
				
				if(b.board[col+i][row-i] == 0) {
					moves.add(new Move(col, row, col+i, row-i, this));
				}
			}
			
			// Reused from the Rook class
			// First loop evaluates moving upwards
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
			
			// Second loop evaluates moving right
			for (int i = 1; i < 8; i++) {
				
				//First we check that we're not off of the board
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
			
			// Third loop evaluates moving downwards
			for (int i = 1; i < 8; i++) {
				
				// First we check that we're not off of the board
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
			
			// Final loop evaluates moving left
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
		}
		return moves;
	}

//-------------------------------------------------------------------------------------------------------------
}
