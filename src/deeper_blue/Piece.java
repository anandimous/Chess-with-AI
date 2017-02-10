package deeper_blue;

import java.util.ArrayList;

public abstract class Piece {

	int value;
	int col;
	int row;
	int type;
	private boolean atRisk = false;
	private boolean isSelected = false;
	private boolean selectable = true;
	String symbol = "";
	String name = "";
	boolean eval = true; // For Kings only
	boolean hasMoved = false;
	ArrayList<Move> legalMoves = new ArrayList<Move>();

//------------------------------------------------------------------------------------------------------------
	
	public abstract ArrayList<Move> getMoves(Board b);	
	
	public void setRisk(boolean risk) {
		atRisk = risk;
	}
	public boolean getRisk() {
		return atRisk;
	}
	
	public void setSelected(boolean selected) {
		isSelected = selected;
	}
	
	public boolean getSelected() {
		return isSelected;
	}
	
	public String getName() {
		return name;
	}
	
	public void setMoved() {
		hasMoved = true;
	}
	
	public boolean getMoved() {
		return hasMoved;
	}
	public void setSelectable(boolean b) {
		selectable = b;
	}
	public boolean getSelectable() {
		return selectable;
	}
}


