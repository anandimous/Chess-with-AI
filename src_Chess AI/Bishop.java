package deeper_blue;

import java.util.ArrayList;

public class Bishop extends Piece {

	int value = 3;
	
//------------------------------------------------------------------------------------------------------
	
	public Bishop(int c, int r, int t) {
		col = c;
		row = r;
		
		// Conditionals set the piece image based on its color
		if (t == 3) {
			symbol = "\u2657";
		}
		
		if (t == 9) {
			symbol = "\u265D";
		}
		
		type = t;
		name = "Bishop";
	}
	
//------------------------------------------------------------------------------------------------------
	
	public ArrayList<Move> getMoves(Board b) {
		
		// List of Move objects returned by method
		ArrayList<Move> moves = new ArrayList<Move>();
		
		// Separate loops determine open paths for each of the
		// four possible directions
		
		// First we test for White Bishops
		if(type == 3){
		
			// First loop evaluates down and left
			for(int i = 1; i < 8; i++) {
				
				// First we check if we're off the board (to avoid IndexOutOfBounds exceptions)
				if(((col+i) > 7) || ((row-i) < 0)) {
					break;
				}
				
				// Next we check if the square we're looking at has a White piece on it, which ends the path.
				if((b.board[col+i][row-i] > 0) && (b.board[col+i][row-i] < 7)) {
					break;
				}
				
				// Next we check if the square we're looking at has a Black piece on it, which also ends the path.
				if(b.board[col+i][row-i] > 6) {
					moves.add(new KillMove(col, row, col+i, row-i, this, b.getPiece(col+i, row-i, b.boardPList)));
					break;
				}
				
				// Next we check if the square we're looking at is open, and the loop continues.
				if(b.board[col+i][row-i] == 0) {
					moves.add(new Move(col, row, col+i, row-i, this));
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
				
				if(((col-i) < 0) || ((row+i) > 7)) {
					break;
				}
				
				if((b.board[col-i][row+i] > 0) && (b.board[col-i][row+i] < 7)) {
					break;
				}
				
				if(b.board[col-i][row+i] > 6) {
					moves.add(new KillMove(col, row, col-i, row+i, this, b.getPiece(col-i, row+i, b.boardPList)));
					break;
				}
				
				if(b.board[col-i][row+i] == 0) {
					moves.add(new Move(col, row, col-i, row+i, this));
				}
			}
		}
		
		// Next we check all the same things for Black Bishops
		if (type == 9) {
			
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
				
				if((b.board[col+i][row+1] < 7) && (b.board[col+i][row+i] > 0)) {
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
		}
		return moves;
	}
//--------------------------------------------------------------------------------------------------------------
}
