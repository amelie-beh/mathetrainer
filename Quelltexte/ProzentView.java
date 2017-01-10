package MatheTrainer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ProzentView extends JFrame{

	private JLabel startlabel = new JLabel("Mathetrainer");
	private JButton prozentbtn = new JButton("%");
	private JPanel panel = new JPanel();
	
	
	public ProzentView() {
	
	
		prozentbtn.setSize(200, 200);
		prozentbtn.setLocation(100, 200);
//		panel.add(Box.createVerticalStrut(50));
		panel.add(prozentbtn, new FlowLayout().LEFT);
		panel.setLocation(100, 200);
		
//		
//		Box startbox = Box.createVerticalBox();
//		
//		startbox.createVerticalStrut(50);
//		startbox.add(panel);
//		
//		add(startbox, BorderLayout.WEST);
		
		
		add(panel);
		
		setTitle("Mathetrainer");
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
