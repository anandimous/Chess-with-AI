package deeper_blue;

import java.util.ArrayList;

public class Knight extends Piece {
	
	int value = 4;
	
//--------------------------------------------------------------------------------------------------------------
	
	public Knight(int c, int r, int t) {
		col = c;
		row = r;
		
		// Conditionals set the piece image based on its rowor
		if (t == 2) {
			symbol = "\u2658";
		}
		
		if (t == 8) {
			symbol = "\u265E";
		}
		type = t;
		name = "Knight";
	}
	
//-------------------------------------------------------------------------------------------------------------

	public ArrayList<Move> getMoves(Board b) {
		
		// List of Move objects returned by method
		ArrayList<Move> moves = new ArrayList<Move>();
		
		// First we check moves for White Knights
		if (type == 2) {
			
			// The following are 8 conditionals for checking the 8 possible moves a knight can make
			
			
			// First conditional checks that we're still on the board
			if (!(((col-2) < 0) || ((row+1) > 7))) {
				
				// Next conditional checks if we can take a Black piece
				if (b.board[col-2][row+1] > 6) {
					moves.add(new KillMove(col, row, col-2, row+1, this, b.getPiece(col-2, row+1, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col-2][row+1] == 0) {
					moves.add(new Move(col, row, col-2, row+1, this));
				}
			}
			
			if (!(((col-1) < 0) || ((row+2) > 7))) {
				
				// Next conditional checks if we can take a Black piece
				if (b.board[col-1][row+2] > 6) {
					moves.add(new KillMove(col, row, col-1, row+2, this, b.getPiece(col-1, row+2, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col-1][row+2] == 0) {
					moves.add(new Move(col, row, col-1, row+2, this));
				}
			}
			
			if (!(((col+1) > 7) || ((row+2) > 7))) {
				
				// Next conditional checks if we can take a Black piece
				if (b.board[col+1][row+2] > 6) {
					moves.add(new KillMove(col, row, col+1, row+2, this, b.getPiece(col+1, row+2, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col+1][row+2] == 0) {
					moves.add(new Move(col, row, col+1, row+2, this));
				}
			}
			
			if (!(((col+2) > 7) || ((row+1) > 7))) {
				
				// Next conditional checks if we can take a Black piece
				if (b.board[col+2][row+1] > 6) {
					moves.add(new KillMove(col, row, col+2, row+1, this, b.getPiece(col+2, row+1, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col+2][row+1] == 0) {
					moves.add(new Move(col, row, col+2, row+1, this));
				}
			}
			
			if (!(((col+2) > 7) || ((row-1) < 0))) {
				
				// Next conditional checks if we can take a Black piece
				if (b.board[col+2][row-1] > 6) {
					moves.add(new KillMove(col, row, col+2, row-1, this, b.getPiece(col+2, row-1, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col+2][row-1] == 0) {
					moves.add(new Move(col, row, col+2, row-1, this));
				}
			}
			
			if (!(((col+1) > 7) || ((row-2) < 0))) {
				
				// Next conditional checks if we can take a Black piece
				if (b.board[col+1][row-2] > 6) {
					moves.add(new KillMove(col, row, col+1, row-2, this, b.getPiece(col+1, row-2, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col+1][row-2] == 0) {
					moves.add(new Move(col, row, col+1, row-2, this));
				}
			}
			
			if (!(((col-1) < 0) || ((row-2) < 0))) {
				
				// Next conditional checks if we can take a Black piece
				if (b.board[col-1][row-2] > 6) {
					moves.add(new KillMove(col, row, col-1, row-2, this, b.getPiece(col-1, row-2, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col-1][row-2] == 0) {
					moves.add(new Move(col, row, col-1, row-2, this));
				}
			}
			
			if (!(((col-2) < 0) || ((row-1) < 0))) {
				
				// Next conditional checks if we can take a Black piece
				if (b.board[col-2][row-1] > 6) {
					moves.add(new KillMove(col, row, col-2, row-1, this, b.getPiece(col-2, row-1, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col-2][row-1] == 0) {
					moves.add(new Move(col, row, col-2, row-1, this));
				}
			}
		}
		
		// Next we check moves for Black Knight
		if (type == 8) {
			
			// The following are 8 conditionals for checking the 8 possible moves a knight can make
			
			
			// First conditional checks that we're still on the board
			if (!(((col-2) < 0) || ((row+1) > 7))) {
				
				// Next conditional checks if we can take a White piece
				if ((b.board[col-2][row+1] < 7) && (b.board[col-2][row+1] > 0)) {
					moves.add(new KillMove(col, row, col-2, row+1, this, b.getPiece(col-2, row+1, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col-2][row+1] == 0) {
					moves.add(new Move(col, row, col-2, row+1, this));
				}
			}
			
			if (!(((col-1) < 0) || ((row+2) > 7))) {
				
				// Next conditional checks if we can take a White piece
				if ((b.board[col-1][row+2] < 7) && (b.board[col-1][row+2] > 0)) {
					moves.add(new KillMove(col, row, col-1, row+2, this, b.getPiece(col-1, row+2, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col-1][row+2] == 0) {
					moves.add(new Move(col, row, col-1, row+2, this));
				}
			}
			
			if (!(((col+1) > 7) || ((row+2) > 7))) {
				
				// Next conditional checks if we can take a White piece
				if ((b.board[col+1][row+2] < 7) && (b.board[col+1][row+2] > 0)) {
					moves.add(new KillMove(col, row, col+1, row+2, this, b.getPiece(col+1, row+2, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col+1][row+2] == 0) {
					moves.add(new Move(col, row, col+1, row+2, this));
				}
			}
			
			if (!(((col+2) > 7) || ((row+1) > 7))) {
				
				// Next conditional checks if we can take a White piece
				if ((b.board[col+2][row+1] < 7) && (b.board[col+2][row+1] > 0)) {
					moves.add(new KillMove(col, row, col+2, row+1, this, b.getPiece(col+2, row+1, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col+2][row+1] == 0) {
					moves.add(new Move(col, row, col+2, row+1, this));
				}
			}
			
			if (!(((col+2) > 7) || ((row-1) < 0))) {
				
				// Next conditional checks if we can take a White piece
				if ((b.board[col+2][row-1] < 7) && (b.board[col+2][row-1] > 0)) {
					moves.add(new KillMove(col, row, col+2, row-1, this, b.getPiece(col+2, row-1, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col+2][row-1] == 0) {
					moves.add(new Move(col, row, col+2, row-1, this));
				}
			}
			
			if (!(((col+1) > 7) || ((row-2) < 0))) {
				
				// Next conditional checks if we can take a White piece
				if ((b.board[col+1][row-2] < 7) && (b.board[col+1][row-2] > 0)) {
					moves.add(new KillMove(col, row, col+1, row-2, this, b.getPiece(col+1, row-2, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col+1][row-2] == 0) {
					moves.add(new Move(col, row, col+1, row-2, this));
				}
			}
			
			if (!(((col-1) < 0) || ((row-2) < 0))) {
				
				// Next conditional checks if we can take a White piece
				if ((b.board[col-1][row-2] < 7) && (b.board[col-1][row-2] > 0)) {
					moves.add(new KillMove(col, row, col-1, row-2, this, b.getPiece(col-1, row-2, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col-1][row-2] == 0) {
					moves.add(new Move(col, row, col-1, row-2, this));
				}
			}
			
			if (!(((col-2) < 0) || ((row-1) < 0))) {
				
				// Next conditional checks if we can take a White piece
				if ((b.board[col-2][row-1] < 7) && (b.board[col-2][row-1] > 0)) {
					moves.add(new KillMove(col, row, col-2, row-1, this, b.getPiece(col-2, row-1, b.boardPList)));
				}
				
				// Final conditional checks if space is empty
				else if (b.board[col-2][row-1] == 0) {
					moves.add(new Move(col, row, col-2, row-1, this));
				}
			}
		}
		return moves;
	}
//--------------------------------------------------------------------------------------------------------------
}
