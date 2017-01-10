package MatheTrainer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PythMain extends JFrame {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	PythTriple triples = new PythTriple();
	int rndNumberMax = triples.X.size();
	Random rndNumber = new Random();
	
	GridLayout grid = new GridLayout(2,2);
	
	
	JPanel executePanel = new JPanel();
	
	
	JPanel taskPanel = new JPanel();
	JLabel pythagoras = new JLabel("Der Satz des Pythagoras");
	JLabel pythagorasTerm = new JLabel("                   a\u00B2 + b\u00B2 = c\u00B2");
	JLabel explanation = new JLabel("<html><body><br><br>Der Satz des Pythagoras ist einer der fundamentalen Sätze der euklidischen Geometrie.<br>Er besagt, dass in allen ebenen rechtwinkligen Dreiecken die Summe der Flächeninhalte<br>der Kathetenquadrate gleich dem Flächeninhalt des Hypotenusenquadrates ist. Sind  a<br>und  b die Längen der am rechten Winkel anliegenden Seiten, der Katheten, und<br>c die Länge der dem rechten Winkel gegenüberliegenden Seite, der Hypotenuse,<br>dann lautet der Satz als Gleichung ausgedrückt:</body></html>");
	JLabel explanationApp = new JLabel("<html><body>Über dem Bild sind die drei Variablen a, b und c zu sehen. Bei jeder neuen Aufgabe ist eine<br>der Variablen nicht bekannt. Das Ziel ist also diese herrauszufinden. Dies schafft man,<br> indem man mit den rechts zu sehenden Knöpfen, die richtigen Rechenschritte einleitet und<br>danach die Variablen richtig in die dazugehörigen Textfelder einsetzt.<br>Viel Spaß!</body><html>");
	
	JPanel Variables = new JPanel();
	JPanel Task = new JPanel();
	JLabel taskA = new JLabel("a = ");
	JLabel taskB = new JLabel("  |  b = ");
	JLabel taskC = new JLabel("  |  c = ");
	JLabel task_A	 = new JLabel("");
	JLabel task_B	 = new JLabel("");
	JLabel task_C	 = new JLabel("");
	JLabel image = new JLabel();
	
	JPanel buttons = new JPanel();
	JButton rootOperationButton = new JButton("\u221A");
	JButton aOperationButton = new JButton("-a\u00B2");
	JButton bOperationButton = new JButton("-b\u00B2");
	JButton nextStep = new JButton("next step");
	JButton nextTask = new JButton("next Task");
	
	JPanel input = new JPanel();
	JLabel putInNumbers = new JLabel("");
	JLabel variableOne = new JLabel("");
	JLabel variableTwo = new JLabel("");
	JTextField One = new JTextField(3);
	JTextField Two = new JTextField(3);
	int varOne;
	int varTwo;
	
	JButton mainMenu = new JButton("Hauptmenü");
	
	JPanel inputButtons = new JPanel();
		
	public int abc;
	int a;
	int b;
	int c;
	int checkNumber;
	
	int exPanelY = 7;
	int exPanelX = 11;
	JLabel[][] exLabelHolder = new JLabel[exPanelY][exPanelX];
	
	boolean isRootable = false;
	boolean abIsPushed = false;
	boolean isA = false;
	boolean isB = false;
	boolean onetrue;
	boolean twotrue;
	
	int step = 0;
	
	String[] signs = {"c", "\u00B2"," = ","a","\u00B2"," + ","b","\u00B2"," "," "," " };
	protected Component frame;
	
	public PythMain(){
		
		setLayout(grid);
		
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.PAGE_AXIS));
		pythagoras.setFont(new Font("Serif", Font.BOLD, 30));
		pythagorasTerm.setFont(new Font("Serif", Font.BOLD, 24));
		taskPanel.add(pythagoras);
		taskPanel.add(explanation);
		taskPanel.add(pythagorasTerm);
		taskPanel.add(explanationApp);
		
		Variables.setLayout(new BoxLayout(Variables, BoxLayout.PAGE_AXIS));
		taskA.setFont(new Font("Serif", Font.BOLD, 18));
		task_A.setFont(new Font("Serif", Font.BOLD, 18));
		taskB.setFont(new Font("Serif", Font.BOLD, 18));
		task_B.setFont(new Font("Serif", Font.BOLD, 18));
		taskC.setFont(new Font("Serif", Font.BOLD, 18));
		task_C.setFont(new Font("Serif", Font.BOLD, 18));
		Task.add(taskA);
		Task.add(task_A);
		Task.add(taskB);
		Task.add(task_B);
		Task.add(taskC);
		Task.add(task_C);
		Variables.add(Task);
		image.setIcon(new ImageIcon("res\\pythagorasPic.png"));
		image.setAlignmentX(CENTER_ALIGNMENT);
		Variables.add(image);
		Variables.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK));
		
		
		nextStep.setEnabled(false);
		nextTask.setEnabled(false);
		buttons.add(rootOperationButton);
		buttons.add(aOperationButton);
		buttons.add(bOperationButton);
		buttons.add(nextStep);
		buttons.add(nextTask);
		
		input.add(variableOne);
		input.add(One);
		input.add(variableTwo);
		input.add(Two);
		input.add(putInNumbers);
	
		
		inputButtons.setLayout(new BoxLayout(inputButtons, BoxLayout.PAGE_AXIS));
		inputButtons.add(buttons);
		inputButtons.add(input);
		mainMenu.setAlignmentX(CENTER_ALIGNMENT);
		inputButtons.add(mainMenu);
		
		add(taskPanel);
		executePanel.setLayout(new GridLayout(0,exPanelX, 1, 1));
		executePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK));
		add(executePanel);
		add(Variables);
		add(inputButtons);
		validate();
		
		
		createTable();
		fillingTable();
		chooseABC();
		pushTheButtons();
		
		pack();
		setResizable(false);
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void chooseABC(){
		triples.setRndNumber(rndNumber.nextInt(rndNumberMax));
		abc = rndNumber.nextInt(3);
		
		switch(abc){
			case 0:
				a = triples.getA();
				b = triples.getB();
				task_A.setText(Integer.toString(a));
				task_B.setText(Integer.toString(b));
				task_C.setText("?");
				variableOne.setText("a = ");
				variableTwo.setText("b = ");
				varOne = a;
				varTwo = b;
				isRootable = true;
				break;
			case 1:
				a = triples.getA();
				c = triples.getC();
				task_A.setText(Integer.toString(a));
				task_B.setText("?");
				task_C.setText(Integer.toString(c));
				variableOne.setText("c = ");
				variableTwo.setText("a = ");
				varOne = c;
				varTwo = a;
				isB = true;
				break;
			case 2:
				b = triples.getB();
				c = triples.getC();
				task_A.setText("?");
				task_B.setText(Integer.toString(b));
				task_C.setText(Integer.toString(c));
				variableOne.setText("c = ");
				variableTwo.setText("b = ");
				varOne = c;
				varTwo = b;
				isA = true;
				break;
		}
	}
	
	public void createTable(){
		
		for(int m= 0; m < exPanelY; m++){
			for (int n = 0; n < exPanelX; n++) {
				exLabelHolder[m][n] = new JLabel("   ");
				executePanel.add(exLabelHolder[m][n]);
			}
		}
	}
	
	public void fillingTable(){
		
		for(int h= 0; h < exPanelY; h++){
			if(h==0){
				for (int g = 0; g < exPanelX; g++) {
					exLabelHolder[h][g].setText(signs[g]);
				}	
			}
				else{
					for (int g = 0; g < exPanelX; g++) {
						exLabelHolder[h][g].setText("");
				}	
			}
		}
	}
	
	public void putInVariables(){
		enableButtons(false, false, false, false);
		putInNumbers.setText("Trage bitte die Variabeln ein.");
		
		One.addCaretListener(l->{
			if(One.getText().equals(String.valueOf(varOne))){
				signs[5] = Integer.toString(varOne);
				onetrue = true;
				System.out.println(onetrue);
			}
			else{
				onetrue = false;
				System.out.println(onetrue);
			}
		});
		Two.addCaretListener(l->{
			if(Two.getText().equals(String.valueOf(varTwo))){
				signs[8] = Integer.toString(varTwo);
				twotrue = true;
				System.out.println(twotrue);
				nextStep.setEnabled(true);
			}
			else{
				twotrue = false;
			}
		});
	}

	public void pushTheButtons(){
		rootOperationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isRootable){
					JOptionPane.showMessageDialog(frame,"Das ist leider der falsche Schritt. \n (Hast du schon richtig umgestellt?)","Überlege nochmal...", JOptionPane.WARNING_MESSAGE);
				}
				else{
					if(!abIsPushed){
						step += 2;
					}
					steps();
					putInVariables();
				}
			}
		});
		
		aOperationButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isB){
					JOptionPane.showMessageDialog(frame,"Das ist leider der falsche Schritt. \n (Ist B gesucht?)","Überlege nochmal...", JOptionPane.WARNING_MESSAGE);
				}
				else{
				String stack = signs[0];
				signs[0] = signs[6];
				signs[6] = signs[3];
				signs[3] = stack;
				signs[5] = " - ";
				enableButtons(true, false, false,false);
				calcSteps("-a\u00B2");
				abIsPushed = true;
				checkNumber = -1;
				fillLines();
				checkNumber = 0;
				step += 1;
				isRootable = true;
				}
			}
		});
		
		bOperationButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isA){
					JOptionPane.showMessageDialog(frame,"Das ist leider der falsche Schritt. \n (Ist A gesucht?)","Überlege nochmal...", JOptionPane.WARNING_MESSAGE);
				}
				else{
				String stack = signs[3];
				signs[3] = signs[0];
				signs[0] = stack;
				signs[5] = " - ";
				enableButtons(true, false, false,false);
				calcSteps("-b\u00B2");
				abIsPushed = true;
				checkNumber = -1;
				fillLines();
				checkNumber = 0;
				step += 1;
				isRootable = true;
				}
			}
		});
		
		nextStep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				steps();
			}
		});
		
		nextTask.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				signs[0] = "c";
				signs[1] = "\u00B2";
				signs[2] = " = ";
				signs[3] = "a";
				signs[4] = "\u00B2";
				signs[5] = " + ";
				signs[6] = "b";
				signs[7] = "\u00B2";
				signs[8] = "";
				signs[9] = "";
				signs[10] = "";
				
				isRootable = false;
				isA = false;
				isB = false;
				enableButtons(true,true,true,false);
				fillingTable();
				chooseABC();
				abIsPushed = false;
				step = 0;
				putInNumbers.setText("");
				One.setText("");
				Two.setText("");
			}
		});
		mainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				dispose();
				MainWindow main = new MainWindow();
				main.setVisible(true);
			}
		});
	}
	
	public void fillLines(){
		for(int s = 0; s < exPanelX; s++){
			 exLabelHolder[step-checkNumber][s].setText(signs[s]);
			}
		step += 1;
	}
	
	public void enableButtons(boolean root, boolean a, boolean b, boolean nextStepB){
		rootOperationButton.setEnabled(root);
		aOperationButton.setEnabled(a);
		bOperationButton.setEnabled(b);
		nextStep.setEnabled(nextStepB);
	}
	
	public void calcSteps(String calc){
		exLabelHolder[0][9].setText("|");
		exLabelHolder[0][10].setText(calc);
	}
	
	public void steps(){
		switch(step){
		case 2:			
			if(!abIsPushed){
				exLabelHolder[0][9].setText("|");
				exLabelHolder[0][10].setText("\u221A");
				checkNumber = 1;
			}
			else {
				exLabelHolder[1][9].setText("|");
				exLabelHolder[1][10].setText("\u221A");
			}

			for(int p = 9; p > 4; p--){
				signs[p] = signs[p-2];
			}
			
			signs[1] = "";
			signs[3] = "\u221A";
			signs[4] = "(";
			signs[10] = ")";	
			fillLines();
			break;
			
		case 3:
				fillLines();
				break;			

		case 4: 
			signs[5] = Integer.toString((int) Math.pow(varOne, 2));
			signs[8] = Integer.toString((int) Math.pow(varTwo, 2));
			signs[6] = signs[7];
			signs[7] = signs[8];
			signs[8] = signs[10];
			signs[9] = "";
			signs[10]= "";
			fillLines();
			break;
		case 5:
			signs[5] = Integer.toString((int) Math.pow(varOne, 2)+(int) Math.pow(varTwo, 2));
			
			switch(abc){
			case 0:
				signs[5] = Integer.toString((int) Math.pow(varOne, 2)+(int) Math.pow(varTwo, 2));
			break;
			
			case 1:
				signs[5] = Integer.toString((int) Math.pow(varOne, 2)-(int) Math.pow(varTwo, 2));
			break;
				
			case 2:
				signs[5] = Integer.toString((int) Math.pow(varOne, 2)-(int) Math.pow(varTwo, 2));
			break;
			}	
			signs[6] = ")";
			for(int j = 7; j < exPanelX; j++){
				signs[j] = " ";
			}
			
			fillLines();
			
			break;
		case 6:	
			System.out.println(abc);
			switch(abc){
				case 0:
					signs[3] = Integer.toString((int)Math.sqrt((int) Math.pow(varOne, 2)+(int) Math.pow(varTwo, 2)));
				break;
				
				case 1:
					signs[3] = Integer.toString((int)Math.sqrt((int) Math.pow(varOne, 2)-(int) Math.pow(varTwo, 2)));
				break;
					
				case 2:
					signs[3] = Integer.toString((int)Math.sqrt((int) Math.pow(varOne, 2)-(int) Math.pow(varTwo, 2)));
				break;
			}
			for(int j = 4; j < exPanelX; j++){
				signs[j] = " ";
			}
			enableButtons(false, false, false, false);
			nextTask.setEnabled(true);
			fillLines();
			
			break;	
		}
	}
	
//	public static void main(String[] args) {
//		new PythMain();
//	}
}
