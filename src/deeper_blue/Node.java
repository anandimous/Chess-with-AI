package deeper_blue;

import java.util.ArrayList;

public class Node {
	
	private int value;
	private int alpha;
	private int beta;
	private int depth;
	private Board board;
	private Node parent;
	private Move parentMove;
	private ArrayList<Node> children = new ArrayList<Node>();
	private ArrayList<Move> childrenMoves = new ArrayList<Move>();
	private boolean isMax;
	
	public Node (Board b, int deepness) {
		board = b.copy();
		
		if (parent == null) {
			isMax = true;
			depth = 1;
		}
		else {
			isMax = (!parent.isMax);
			depth = parent.depth + 1;
		}
		
		if (isMax) {
			childrenMoves = board.getWhiteMoves();
		}
		else {
			childrenMoves = board.getBlackMoves();
		}

		for (Move m : childrenMoves) {
			
			if ((deepness - 1) > 0) {
			Node child = new Node(board.evalMove(m), deepness - 1);
			child.parentMove = m;
			children.add(child);
			}	
		}
	}
}

	
