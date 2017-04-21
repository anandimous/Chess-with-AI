package deeper_blue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ChessPanel extends JPanel implements MouseListener {
	
	public ChessData CD = new ChessData();
	public Board gb = new Board();
	private Dimension d = new Dimension(800, 800);
	private Font font;
	private Piece piece;

	public ChessPanel(ChessData CD) {
		gb = CD.gameBoard;
		font = new Font("Chess Font", Font.PLAIN, 100);
		this.setPreferredSize(d);
		addMouseListener(this);
		
	}
	
	public ChessPanel() {
		this.setPreferredSize(d);
	}
	
	public void paintComponent(Graphics g){

		// These first loops paint the board as a grid of 100px * 100px squares
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if ((y+x) % 2 == 0) {
					g.setColor(Color.WHITE);
					g.fillRect(x * 100, y * 100, 100, 100);
				}
				else {
					g.setColor(Color.LIGHT_GRAY);
					g.fillRect(x * 100, y * 100, 100, 100);
				}
			}
		}
		
		if (gb.boardPList == null) {
			return;
		}
		for (Piece p : gb.boardPList) {
			g.setFont(font);
			if (p.type <= 6) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.BLACK);
			}
			g.drawString(p.symbol, (p.col*100) - 3, (p.row*100) + 85);
		}
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(4));
		for (Piece p : gb.boardPList) {
			if (p.getSelected()) {
				for (Move m : p.getMoves(gb)) {
					if (m.getName().equals("Kill Move")) {
						if (m.getKillPiece().getName().contains("King")) {
							g.setColor(Color.ORANGE);
						}
						else {
							g.setColor(Color.RED);
						}
					}
					else {
						g.setColor(Color.CYAN);
					}
					g.drawRect((m.c2 *100) + 2,(m.r2 * 100) + 2, 96, 96);
				}
				g.setColor(Color.CYAN);
				g.drawRect((p.col*100) + 2, (p.row*100) + 2, 96, 96);
			}	
		}
	}



	@Override
	public void mousePressed(MouseEvent e) {
		if (!gb.getProgress()) {
			ChessFrame.message.setText("Click \"New Game\" to start a new game.");
		}
		else {
			int col = (e.getX() / 100);
			int row = (e.getY() / 100);
			doClickSquare(col, row);
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void doClickSquare(int col, int row) {
		if (piece != null) {
			if (piece.getSelected()) {
				if ((piece.col == col) && (piece.row == row)) {
					piece.setSelected(false);
					repaint();
					return;
				}
				
				else {
				for (Move m : piece.getMoves(gb)) {
					if (m.getName().equals("Kill Move")) {
						if (m.getKillPiece().getName().contains("King")) {
						continue;
						}
					}
					if ((m.c2 == col) && (m.r2 == row)) {
						gb.evaluable = true;
						gb.makeMove(m, gb);
						piece.setSelected(false);
						repaint();
						return;
					}
					else {
						piece.setSelected(false);
						repaint();
					}
				}
				}
			}
		}
		for (Piece p : gb.boardPList) {
			p.setSelected(false);
			repaint();
			if ((p.col == col) && (p.row == row)) {
			if (p.getSelectable()) {
				piece = p;
				piece.setSelected(true);
				repaint();
			}
			}
			
		}
	}
}
