package mathetrainer;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bruch extends JFrame {
	
	public Bruch() {
			
		setLayout(new BorderLayout());
		
		JPanel ueberschriftPanel = new JPanel();
		JPanel auswahlPanel = new JPanel();
		JButton addBtn = new JButton("+");
		JButton subBtn = new JButton("-");
		JButton mulBtn = new JButton("*");
		JButton divBtn = new JButton("/");
		JButton zurueckBtn = new JButton("Zurück");
		JLabel textLabel = new JLabel("Was willst du üben?");
		
		add(ueberschriftPanel, BorderLayout.NORTH);
		add(auswahlPanel, BorderLayout.CENTER);
		
		ueberschriftPanel.add(textLabel);
		ueberschriftPanel.add(zurueckBtn);
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
		
		zurueckBtn.addActionListener(listener -> {
			dispose();
			//new Hauptmenu();
		});
		
		setVisible(true);
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		new Bruch();
	}
}
