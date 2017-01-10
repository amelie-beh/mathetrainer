package MatheTrainer;


import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

public class RingCalc extends JFrame {

	
	private JTextField textField;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


	public RingCalc() {
		initialize();
		pack();
		setVisible(true);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Multiplikation und Addition in Restklassenringen");
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	Random rng = new Random();
	
	int ringGroesse = 0;
	int startNr = 0;
	int multiplikator = 0;
	int summand = 0;
	int operation = 0;
	int antwort = 0;
	int ergebnis = 0;
	int counter = 0;
	
	JLabel lblFehlversuche = new JLabel("Fehlversuche: " + counter);
	JLabel lblAufgabentext = new JLabel("Aufgabentext");
	JLabel lblAufgabentext2 = new JLabel("Aufgabentext2");
	JLabel lblChecktext = new JLabel(" ");
	JLabel lblAufgabe = new JLabel("Aufgabe:");
		
	private void initial(){
		ringGroesse = rng.nextInt(19) + 3;
		startNr = rng.nextInt(ringGroesse - 2) + 2;
		operation = rng.nextInt(2);
		lblChecktext.setText(" ");
	}
	
	private void multiplikation(){
		multiplikator = rng.nextInt(19) + 2;
		ergebnis = (startNr * multiplikator) % ringGroesse;
		lblAufgabentext.setText("Berechne im Restklassenring Z/" + ringGroesse + "Z");
		lblAufgabentext2.setText(startNr + " * " + multiplikator + " = ?");
	}
	
	private void addition(){
		summand = rng.nextInt(99) + 2;
		ergebnis = (startNr + summand) % ringGroesse;
		lblAufgabentext.setText("Berechne im Restklassenring Z/" + ringGroesse + "Z");
		lblAufgabentext2.setText(startNr + " + " + summand + " = ?");
	}
	
	private void initialize() {
		
		initial();
		
		if (operation == 0) { //Multiplikation
			multiplikation();								
		}
		
		if (operation == 1) { //Addition
			addition();			
		}
				
		
		getContentPane().setLayout(null);
		
		JButton btnWeiter = new JButton("Weiter");
		btnWeiter.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				initial();
				
				if (operation == 0) { //Multiplikation
					multiplikation();	
				}
				
				if (operation == 1) { //Addition
					addition();
				}
			}
		});
		btnWeiter.setBounds(319, 227, 105, 23);
		getContentPane().add(btnWeiter);
		
		JButton btnHauptmen = new JButton("Hauptmen\u00FC");
		btnHauptmen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MainWindow main = new MainWindow();
				main.setVisible(true);
			}
		});
		btnHauptmen.setBounds(10, 227, 105, 23);
		getContentPane().add(btnHauptmen);
		
		JButton btnberprfen = new JButton("\u00DCberpr\u00FCfen");
		btnberprfen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnberprfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					antwort = Integer.parseInt(textField.getText());
					
					if (antwort != ergebnis) {
						counter++;
					}
					
					if (antwort == ergebnis) {
						lblChecktext.setText("Sehr gut!");
					} else if (antwort >= ringGroesse) {
						lblChecktext.setText("Bedenke, das Ergebnis muss zwischen 0 und " + (ringGroesse - 1) + " liegen.");
					} else if (antwort < 0) {
						lblChecktext.setText("Bedenke, das Ergebnis kann niemals negativ sein!");
					} else if (antwort == (ergebnis + 1) || antwort == (ergebnis - 1)) {
						lblChecktext.setText("Ich glaube, Du hast Dich verrechnet!");
					} else {
						lblChecktext.setText("Leider falsch!");
					}
					
					lblFehlversuche.setText("Fehlversuche: " + counter);
					
				} catch (java.lang.NumberFormatException nfe) {
					lblChecktext.setText("Falsche Eingabe!");
				}
				
			}
		});
		btnberprfen.setBounds(204, 227, 105, 23);
		getContentPane().add(btnberprfen);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
			    textField.setText("");
			  }
		});
		textField.setBounds(204, 198, 105, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblFehlversuche.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFehlversuche.setBounds(10, 196, 216, 20);
		getContentPane().add(lblFehlversuche);
		
		lblAufgabentext.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAufgabentext.setBounds(96, 14, 328, 47);
		getContentPane().add(lblAufgabentext);
		
		lblAufgabe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAufgabe.setBounds(10, 14, 76, 47);
		getContentPane().add(lblAufgabe);
		lblChecktext.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblChecktext.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChecktext.setBounds(10, 162, 414, 23);
		getContentPane().add(lblChecktext);
		
		lblAufgabentext2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAufgabentext2.setBounds(96, 83, 328, 47);
		getContentPane().add(lblAufgabentext2);
	}
}
//		pack();
//		setVisible(true);
//		setBounds(100, 100, 450, 300);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setTitle("Multiplikation und Addition in Restklassenringen");

	
//		public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RingCalc window = new RingCalc();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

