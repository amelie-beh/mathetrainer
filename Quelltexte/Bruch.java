package MatheTrainer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bruch extends JFrame {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Bruch() {
			
		setLayout(new BorderLayout());
		
		JPanel ueberschriftPanel = new JPanel();
		JPanel auswahlPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		JButton addBtn = new JButton("+");
		JButton subBtn = new JButton("-");
		JButton mulBtn = new JButton("*");
		JButton divBtn = new JButton("/");
		JButton zurueckBtn = new JButton("Hauptmenü");
		JLabel textLabel = new JLabel("Was willst du üben?");
		
		add(ueberschriftPanel, BorderLayout.NORTH);
		add(auswahlPanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
		ueberschriftPanel.add(textLabel);
		
		
		
		auswahlPanel.setLayout(new GridLayout(2,2));
		
		auswahlPanel.add(addBtn);
		auswahlPanel.add(subBtn);
		auswahlPanel.add(mulBtn);
		auswahlPanel.add(divBtn);
		
		addBtn.addActionListener(listener -> {
			dispose();
			new BruchAddition();
		});
		
		subBtn.addActionListener(listener -> {
			dispose();
			new BruchSubtraktion();
		});
		
		mulBtn.addActionListener(listener -> {
			dispose();
			new BruchMultiplikation();
		});
		
		divBtn.addActionListener(listener -> {
			dispose();
			new BruchDivision();
		});
		
		btnPanel.add(zurueckBtn);
		zurueckBtn.addActionListener(listener -> {
			dispose();
			MainWindow main = new MainWindow();
			main.setVisible(true);
		});
		
		setVisible(true);
		setSize(600, 300);
		setResizable(false);
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
//	public static void main(String[] args) {
//		new Bruch();
//	}
}
