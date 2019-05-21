import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class TicTacToe extends JPanel{
	
	private final JPanel gui = new JPanel(new BorderLayout(3,3));
	private JButton[][] tttSquares = new JButton[3][3];
	private JPanel tttBoard = new JPanel(new GridLayout(0,3));
	private JLabel message = new JLabel("test message");
	
	// constructor
	public TicTacToe() {
		initializeGui();
	}
	
	public final void initializeGui() {

		gui.setBorder(new EmptyBorder(3, 3, 3, 3));
		// tttBoard.setBorder(new LineBorder(Color.BLACK));
		JToolBar tools = new JToolBar();
		tools.add(new JButton("New"));
		tools.add(new JButton("Resign"));
		tools.addSeparator();
		tools.add(message);
		tools.setFloatable(false);
		
		gui.add(tools, BorderLayout.PAGE_START);
		
		// set squares
		for(int i = 0; i < tttSquares.length; i++) {
			for(int j = 0; j < tttSquares[i].length; j++) {
				JButton b = new JButton();
				b.setBackground(Color.DARK_GRAY);
				//b.setPreferredSize(new Dimension(150,150));
				tttSquares[i][j] = b;
				tttBoard.add(tttSquares[i][j]);
			}
		}
		
		gui.add(tttBoard);
	}
	
	public final JComponent getGui() {
		return gui;
	}
	
	// not sure how this works
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		g.setColor(Color.BLACK);
		g.fillRect(width/2, height/2, width, height);
	}
	
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				TicTacToe board = new TicTacToe();
				// setup window
				JFrame frame = new JFrame("Tic Tac Toe");
				frame.add(board.getGui());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				// minimum size for 150,150 dimension JButtons
				frame.setMinimumSize(new Dimension(472,530));
				frame.pack();
				frame.setVisible(true);
				//System.out.println(frame.getSize().toString());

			}
		};
		SwingUtilities.invokeLater(r);
	}
}
