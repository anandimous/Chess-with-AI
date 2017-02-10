package deeper_blue;

import java.util.ArrayList;

public class Pawn extends Piece {
	
	int value = 1;
	
//------------------------------------------------------------------------------------------------------------
	
	public Pawn(int c, int r, int t) {
		col = c;
		row = r;
		
		// Conditionals set the piece image based on its rowor
		if (t == 1) {
			symbol = "\u2659";
		}
		
		if (t == 7) {
			symbol = "\u265F";
		}
		
		type = t;
		name = "Pawn";
	}
	
//------------------------------------------------------------------------------------------------------------
	
	public ArrayList<Move> getMoves(Board b) {
		
		// List of Move objects returned by method
		ArrayList<Move> moves = new ArrayList<Move>();
		
		// This signifies moves for White pawns
		if (type == 1) {
			
			if (col > 0) {
				// First conditional checks for any kill moves in bottom left diagonal square
				// (Also checks to make sure piece cannot move off of board)
				if (b.board[col-1][row+1] > 6) {
					moves.add(new KillMove(col, row, col-1, row+1, this, b.getPiece(col-1, row+1, b.boardPList)));
				}
			}
			
			if (col < 7) {	
				// Second conditional checks for any kill moves in bottom right diagonal square
				// (Also checks to make sure piece cannot move off of board)
				if (b.board[col+1][row+1] > 6) {
					moves.add(new KillMove(col, row, col+1, row+1, this, b.getPiece(col+1, row+1, b.boardPList)));
				}
			}
			
			// Third conditional checks generic move, if square below pawn is open
			if (b.board[col][row+1] == 0) {
				moves.add(new Move(col, row, col, row+1, this));
				
				// If square is open and pawn is in starting position, checks 2 squares ahead
				if ((row == 1) && (b.board[col][row+2] == 0)) {
					moves.add(new Move(col, row, col, row+2, this));
				}
			}
		}
		
		// this signifies moves for Black pawns
		if (type == 7) {
			
			if (col > 0) {	
				// First conditional checks for any kill moves in top left diagonal square
				// (Also checks to make sure piece cannot move off of board)
				if ((b.board[col-1][row-1] <= 6) && (b.board[col-1][row-1] != 0)) {
					moves.add(new KillMove(col, row, col-1, row-1, this, b.getPiece(col-1, row-1, b.boardPList)));
				}
			}
			
			if (col < 7) {
				// Second conditional checks for any kill moves in top right diagonal square
				// (Also checks to make sure piece cannot move off of board)
				if ((b.board[col+1][row-1] <= 6) && (b.board[col+1][row-1] != 0)) {
					moves.add(new KillMove(col, row, col+1, row-1, this, b.getPiece(col+1, row-1, b.boardPList)));
				}
			}
				
			// Third conditional checks generic move, if square above pawn is open 
			if (b.board[col][row-1] == 0) {
				moves.add(new Move(col, row, col, row-1, this));
				
				// If square is open and pawn is in starting position, checks 2 square ahead
				if ((row == 6) && (b.board[col][row-2] == 0)) {
					moves.add(new Move(col, row, col, row-2, this));
				}
			}
		}
		return moves;
		
		//FIXME: Still needs additional checks for stupid transition rule
	}
	
//------------------------------------------------------------------------------------------------------------

	public void makeMove(Move m, Board b) {
		
		// Sets value of initial space of piece to empty
		b.board[col][row] = 0;
		
		// Changes position of piece to final position of move chosen
		col = m.r2;
		row = m.c2;
		
		// Sets value of final board space to piece value
		// (Conditionals check if piece is White or Black)
		if (type == 1) {
			b.board[col][row] = 1;
		}
		if (type == 7) {
			b.board[col][row] = 7;
		}
	}
}//-----------------------------------------------------------------------------------------------------------

