import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	private JButton buttonReset;

	public static void main(String[] args) {
		new Frame();
	}
	
	public Frame() {
		initializePanel();
		
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setPreferredSize(new Dimension(400, 500));
		pack();
		setResizable(true);
		setVisible(true);;
		
	}
	
	private void initializePanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		
		buttonReset = new JButton("Reset");
		panel.add(buttonReset);
		
		
	}
}
