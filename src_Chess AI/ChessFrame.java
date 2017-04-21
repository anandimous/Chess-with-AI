package deeper_blue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ChessFrame extends JFrame implements ActionListener {
	
	static JButton newGame = new JButton("New Game");
	static JButton resign = new JButton("Resign");
	ChessPanel panel = new ChessPanel(new ChessData());
	static JLabel message = new JLabel("");
	static ChessFrame frame;
	
	public ChessFrame() {
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		JPanel messagePanel = new JPanel();
		message.setFont(new Font("message font", Font.BOLD, 24));
		message.setText("Welcome to Deeper Blue!");
		newGame.addActionListener(this);
		resign.addActionListener(this);
		messagePanel.add(message);
		buttonPanel.add(newGame);
		resign.setEnabled(false);
		buttonPanel.add(resign);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(messagePanel, BorderLayout.NORTH);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args) {
		frame = new ChessFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
			panel.CD = new ChessData();
			panel.gb = panel.CD.gameBoard;
			panel.gb.setProgress(true);
			panel.repaint();
			newGame.setEnabled(false);
			resign.setEnabled(true);
			frame.add(panel);
			message.setText("White: make your move");
		}
		if (e.getSource() == resign) {
			message.setText("You Lose! Press \"New Game\" to play again.");
			newGame.setEnabled(true);
			panel.gb.setProgress(false);
			resign.setEnabled(false);
		}
	}
}
