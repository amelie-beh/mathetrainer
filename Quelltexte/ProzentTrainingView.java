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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ProzentTrainingView extends JFrame{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	GridLayout grid = new GridLayout(1,2);
	private JPanel aufgabenPanel = new JPanel();
	private JPanel bearbeitungsPanel = new JPanel();
	private JPanel btnPanel = new JPanel();
	JPanel input = new JPanel();
	JPanel lineOne = new JPanel();
	JPanel lineTwo = new JPanel();
	JPanel lineThree = new JPanel();
	JLabel image = new JLabel();
	
	
	
	JScrollPane scrollpane = new JScrollPane(aufgabenPanel);
	private JButton returnbtn = new JButton("Hauptmenü");
	private JButton submitbtn = new JButton("bestätigen");
	private JButton verstanden = new JButton("zu den Aufgaben");
	private JTextField firstProzentField  = new JTextField(3);
	private JTextField secondProzentField = new JTextField(3);
	private JTextField thirdProzentField = new JTextField(3);
	private JTextField firstValueField = new JTextField(3);
	private JTextField secondValueField= new JTextField(3);
	private JTextField thirdValueField = new JTextField(3);
	private JLabel aufgabeÜberschrift = new JLabel("<html><body>Übungsaufgaben<br></body></html>");
	private JLabel erklärung = new JLabel("<html><body>Ein einfacher Dreisatz ist eine Tabelle	"
												+ "<br>mit drei Zeilen und zwei Spalten,"
												+ "<br>die du einfach nach einem bestimmten"
												+ "<br>Schema befüllen musst,"
												+ "<br>das Gute am Dreisatz ist,"
												+ "<br>dass das Schema immer das"
												+ "<br>Gleiche ist."
												+ "<br>Wenn du einmal verstanden hast,"
												+ "<br>wie der Hase läuft,"
												+ "<br>kannst du jede Dreisatz-Aufgabe kinderleicht lösen.</body></html>");
	private JLabel aufgabe = new JLabel();
	
	
	
	 ProzentTrainingView() {
	
		 setLayout(grid);
		 
		 image.setIcon(new ImageIcon("res\\Dreisatz.png"));
		 
		 aufgabeÜberschrift.setFont(new Font("Arial", 25, 25));
		 erklärung.setFont(new Font("Arial", 15,15));
		 
		 aufgabenPanel.setLayout(new BoxLayout(aufgabenPanel, BoxLayout.PAGE_AXIS));
		 aufgabenPanel.add(aufgabeÜberschrift);
		 aufgabenPanel.add(erklärung);
		 aufgabenPanel.add(image);
		 aufgabenPanel.add(verstanden);
		 add(aufgabenPanel);
		 
		 submitbtn.setEnabled(false);
		 
		 
		 btnPanel.add(submitbtn);
		 btnPanel.add(returnbtn);
		
		 bearbeitungsPanel.setLayout(new BoxLayout(bearbeitungsPanel, BoxLayout.PAGE_AXIS));
		 input.setLayout(new BoxLayout(input, BoxLayout.PAGE_AXIS));

		 
		 
		 lineOne.add(firstProzentField);
		 lineOne.add(new JLabel("%"));
		 lineOne.add(new JLabel("="));
		 lineOne.add(firstValueField);
		 
		
		 lineTwo.add(secondProzentField);
		 lineTwo.add(new JLabel("%"));
		 lineTwo.add(new JLabel("="));
		 lineTwo.add(secondValueField);
		 
		 lineThree.add(thirdProzentField);
		 lineThree.add(new JLabel("%"));
		 lineThree.add(new JLabel("="));
		 lineThree.add(thirdValueField);
		 
		 input.add(lineOne);
		 input.add(lineTwo);
		 input.add(lineThree);
		 
		 
		 bearbeitungsPanel.add(input);
		 bearbeitungsPanel.add(btnPanel);
		 add(bearbeitungsPanel);
		 
			pack();
			setResizable(false);
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
	 
	 public JLabel getErklärung() {
		return erklärung;
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
	 public JButton getReturnbtn() {
		return returnbtn;
	}
}


