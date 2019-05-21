import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TicTacToe extends JFrame{
	
	private final JPanel gui = new JPanel(new BorderLayout(3,3));
	private JButton[][] tttSquares = new JButton[3][3];
	private JPanel tttBoard = new JPanel(new GridLayout(0,3));
	private JLabel message = new JLabel("test message");
	public TicTacToe() {
		initializeGui();
	}
	
	public final void initializeGui() {

		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		tttBoard.setBorder(new LineBorder(Color.BLACK));
		JToolBar tools = new JToolBar();
		tools.add(new JButton("New"));
		tools.addSeparator();
		tools.add(message);
		tools.setFloatable(false);
		
		gui.add(tools, BorderLayout.PAGE_START);
		
		// set squares
		for(int i = 0; i < tttSquares.length; i++) {
			for(int j = 0; j < tttSquares[i].length; j++) {
				JButton b = new JButton();
				b.setBackground(Color.DARK_GRAY);
				tttSquares[i][j] = b;
				tttBoard.add(tttSquares[i][j]);
			}
		}
		
		gui.add(tttBoard);
	}
	
	public final JComponent getGui() {
		return gui;
	}
	
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				TicTacToe board = new TicTacToe();
				// setup window
				JFrame frame = new JFrame("Tic Tac Toe");
				frame.add(board.getGui());
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setMinimumSize(new Dimension(600,600));
				frame.pack();
				frame.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
