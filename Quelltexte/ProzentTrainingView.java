package MatheTrainer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ProzentTrainingView extends JFrame{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel aufgabenPanel = new JPanel();
	private JPanel bearbeitungsPanel = new JPanel();
	private JPanel btnPanel = new JPanel();
	JScrollPane scrollpane = new JScrollPane(aufgabenPanel);
	private JButton returnbtn = new JButton("return");
	private JButton submitbtn = new JButton("best�tigen");
	private JButton verstanden = new JButton("zu den Aufgaben");
	private JTextField firstProzentField;
	private JTextField secondProzentField = new JTextField(3);
	private JTextField thirdProzentField = new JTextField(3);
	private JTextField firstValueField = new JTextField(3);
	private JTextField secondValueField= new JTextField(3);
	private JTextField thirdValueField = new JTextField(3);
	private JLabel aufgabe�berschrift = new JLabel("<html><body>�bungsaufgabe<br></body></html>");
	private JLabel erkl�rung = new JLabel("<html><body>Ein einfacher Dreisatz ist eine Tabelle<br> mit drei Zeilen und zwei Spalten,<br> die du einfach nach einem bestimmten<br> Schema bef�llen musst,<br> das Gute am Dreisatz ist, dass das Schema immer das Gleiche ist.<br> Wenn du einmal verstanden hast, wie der Hase l�uft, kannst du jede Dreisatz-Aufgabe kinderleicht l�sen.</body></html>");
	private JLabel aufgabe = new JLabel();
	
	
	 ProzentTrainingView() {
	
		 firstProzentField = new JTextField(3);
		 
		 Box box = Box.createVerticalBox();
		 
		 submitbtn.setEnabled(false);
		 

		 btnPanel.add(submitbtn);
		 btnPanel.add(returnbtn);
		 
		 aufgabe�berschrift.setFont(new Font("Arial", 25, 25));
		 erkl�rung.setFont(new Font("Arial", 15,15));
		 
		 aufgabenPanel.setLayout(new BorderLayout());
		 aufgabenPanel.add(aufgabe�berschrift);
		 aufgabenPanel.add(erkl�rung);
		 aufgabenPanel.add(verstanden, BorderLayout.SOUTH);
		 
		 
		 
		 
		 bearbeitungsPanel.add(btnPanel, BorderLayout.SOUTH);
		 
		 bearbeitungsPanel.add(firstProzentField);
		 bearbeitungsPanel.add(secondProzentField);
		 bearbeitungsPanel.add(thirdProzentField);
		 bearbeitungsPanel.add(firstValueField);
		 bearbeitungsPanel.add(secondValueField);
		 bearbeitungsPanel.add(thirdValueField);
		 

		 add(bearbeitungsPanel, BorderLayout.EAST);
		 add(scrollpane, BorderLayout.WEST);
		 
		 
			setSize(700, 500);
			setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
	}
	 
	 public JTextField getFirstProzentField() {
		return firstProzentField;
	}
	 
	 public JTextField getSecondProzentField() {
		return secondProzentField;
	}
	 
	 public JTextField getThirdProzentField() {
		return thirdProzentField;
	}
	 
	 public JTextField getFirstValueField() {
		return firstValueField;
	}
	 
	 public JTextField getSecondValueField() {
		return secondValueField;
	}
	 
	 public JTextField getThirdValueField() {
		return thirdValueField;
	}
	 
	 public JLabel getErkl�rung() {
		return erkl�rung;
	}
	 
	 public JButton getVerstanden() {
		return verstanden;
	}

	 public JLabel getAufgabe() {
		return aufgabe;
	}
	 
	 public JPanel getAufgabenPanel() {
		return aufgabenPanel;
	}
	 
	 public JButton getSubmitbtn() {
		return submitbtn;
	}
}


