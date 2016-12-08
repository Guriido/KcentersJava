package resolutionKcentres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

public class GUI extends JFrame {

	private Panel contentPane;

	public GUI(Panel contentPane) {
		this.contentPane = contentPane;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,1000);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}

}
