package MatheTrainer;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.SwingConstants;

public class BruchDivision extends JFrame {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel contentPane;
	private JTextField eingabeZwischenZaehler1;
	private JTextField eingabeZwischenNenner1;
	private JTextField eingabeZwischenNenner2;
	private JTextField eingabeZwischenZaehler2;
	private JTextField eingabeErgebnisZaehler;
	private JTextField eingabeErgebnisNenner;
	private JTextField eingabeErgebnisZaehlerOhneKuerzen;
	private JTextField eingabeErgebnisNennerOhneKuerzen;
	private JLabel ersterZaehlerLabel;
	private JLabel zweiterZaehlerLabel;
	private JLabel ersterNennerLabel;
	private JLabel zweiterNennerLabel;
	int ergebnisZwischenNenner;
	int ergebnisZwischenNenner2;
	int ergebnisZwischenZaehler1;
	int ergebnisZwischenZaehler2;
	int ergebnisZaehler; 
	int ergebnisNenner;
	int aufgabenCounter;
	int ergebnisZaehlerOhneKuerzen;
	int ergebnisNennerOhneKuerzen;

	public BruchDivision() {
		setVisible(true);
		setResizable(false);
		setBounds(0, 0, 600, 300);
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel erzeugen, in dem zwei weitere Panel links und rechts angeordnet sind
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Panel links erzeugen
		Panel leftPanel = new Panel();
		leftPanel.setBounds(10, 10, 260, 241);
		contentPane.add(leftPanel);
		leftPanel.setLayout(null);
		
		//JLabel für das Wort "Aufgabe"
		JLabel lblAufgabe = new JLabel("Aufgabe");
		lblAufgabe.setBounds(20, 14, 60, 14);
		leftPanel.add(lblAufgabe);		
		
		//JLabel für den Zähler des ersten Bruches, Inhalt wird von Methode ErstelleAufgabe() ersetzt
		ersterZaehlerLabel = new JLabel("");
		ersterZaehlerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ersterZaehlerLabel.setBounds(20, 39, 25, 14);
		leftPanel.add(ersterZaehlerLabel);
		
		//JLabel für den Bruchstrich des ersten Bruches
		JLabel ersterBruchStrichLabel = new JLabel("----");
		ersterBruchStrichLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ersterBruchStrichLabel.setBounds(20, 67, 25, 14);
		leftPanel.add(ersterBruchStrichLabel);
		
		//JLabel für den Nenner des ersten Bruches, Inhalt wird von Methode ErstelleAufgabe() ersetzt
		ersterNennerLabel = new JLabel("");
		ersterNennerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ersterNennerLabel.setBounds(20, 97, 25, 14);
		leftPanel.add(ersterNennerLabel);
		
		//JLabel für die Rechenart
		JLabel rechenartLabel = new JLabel("/");
		rechenartLabel.setBounds(70, 67, 20, 14);
		leftPanel.add(rechenartLabel);
		
		//JLabel für den Zähler des zweiten Bruches, Inhalt wird von Methode ErstelleAufgabe() ersetzt
		zweiterZaehlerLabel = new JLabel("");
		zweiterZaehlerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		zweiterZaehlerLabel.setBounds(100, 39, 25, 14);
		leftPanel.add(zweiterZaehlerLabel);
		
		//JLabel für den Bruchstrich des zweiten Bruches
		JLabel zweiterBruchStrichLabel = new JLabel("----");
		zweiterBruchStrichLabel.setHorizontalAlignment(SwingConstants.CENTER);
		zweiterBruchStrichLabel.setBounds(100, 67, 25, 14);
		leftPanel.add(zweiterBruchStrichLabel);
		
		//JLabel für den Nenner des zweiten Bruches, Inhalt wird von Methode ErstelleAufgabe() ersetzt
		zweiterNennerLabel = new JLabel("");
		zweiterNennerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		zweiterNennerLabel.setBounds(100, 97, 25, 14);
		leftPanel.add(zweiterNennerLabel);
		
		//JLabel für das Wort "Kehrwert"
		JLabel lblKehrwert = new JLabel("Kehrwert");
		lblKehrwert.setBounds(20, 126, 60, 14);
		leftPanel.add(lblKehrwert);
		
		//JTextField für die Eingabe des Zwischenergebnisses des Zählers des ersten Bruches
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeZwischenZaehler1 = new JTextField();
		eingabeZwischenZaehler1.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getZwischenZaehler1 = eingabeZwischenZaehler1.getText();
				try{
					int parsedZwischenZaehler1 = Integer.parseInt(getZwischenZaehler1);
					if (ergebnisZwischenZaehler1 == parsedZwischenZaehler1) {
						eingabeZwischenZaehler1.setBackground(Color.GREEN);
					}
					else {
						eingabeZwischenZaehler1.setBackground(Color.RED);
					}
				}
				catch(NumberFormatException err){
				}
			}
		});
		eingabeZwischenZaehler1.setBounds(20, 151, 25, 20);
		leftPanel.add(eingabeZwischenZaehler1);
		eingabeZwischenZaehler1.setColumns(10);
		
		//JLabel für den Bruchstrich des ersten Bruches beim Kehrwert
		JLabel ersterBruchStrichErweiternLabel = new JLabel("----");
		ersterBruchStrichErweiternLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ersterBruchStrichErweiternLabel.setBounds(20, 182, 25, 14);
		leftPanel.add(ersterBruchStrichErweiternLabel);
		
		//JTextField für die Eingabe für das Zwischenergebnis des Nenners des ersten Bruches
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeZwischenNenner1 = new JTextField();
		eingabeZwischenNenner1.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getZwischenNenner = eingabeZwischenNenner1.getText();
				try{
					int parsedZwischenNenner = Integer.parseInt(getZwischenNenner);
					if (ergebnisZwischenNenner == parsedZwischenNenner) {
						eingabeZwischenNenner1.setBackground(Color.GREEN);
					}
					else {
						eingabeZwischenNenner1.setBackground(Color.RED);
					}
				}
				catch(NumberFormatException err){
				}
			}
		});
		eingabeZwischenNenner1.setColumns(10);
		eingabeZwischenNenner1.setBounds(20, 207, 25, 20);
		leftPanel.add(eingabeZwischenNenner1);
		
		//JLabel für die Rechenart beim Bruch Kehrwert
		JLabel rechenartErweiternLabel = new JLabel("*");
		rechenartErweiternLabel.setBounds(70, 182, 10, 14);
		leftPanel.add(rechenartErweiternLabel);
		
		//JTextField für die Eingabe des Kehrwerts des Nenners des zweiten Bruches
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeZwischenNenner2 = new JTextField();
		eingabeZwischenNenner2.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getZwischenNenner2 = eingabeZwischenNenner2.getText();
				
				try{
					int parsedZwischenNenner2 = Integer.parseInt(getZwischenNenner2);
					if (ergebnisZwischenNenner2 == parsedZwischenNenner2) {
						eingabeZwischenNenner2.setBackground(Color.GREEN);
					}
					else {
						eingabeZwischenNenner2.setBackground(Color.RED);
					}
				}
				catch(NumberFormatException err){
				}
			}
		});
		
		eingabeZwischenNenner2.setColumns(10);
		eingabeZwischenNenner2.setBounds(100, 207, 25, 20);
		leftPanel.add(eingabeZwischenNenner2);
		
		//JTextField für die Eingabe des Kehrwerts des Zählers des zweiten Bruches
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeZwischenZaehler2 = new JTextField();
		eingabeZwischenZaehler2.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getZwischenZaehler2 = eingabeZwischenZaehler2.getText();
				try{
					int parsedZwischenZaehler2 = Integer.parseInt(getZwischenZaehler2);
					if (ergebnisZwischenZaehler2 == parsedZwischenZaehler2) {
						eingabeZwischenZaehler2.setBackground(Color.GREEN);
					}
					else {
						eingabeZwischenZaehler2.setBackground(Color.RED);
					}
				}
				catch(NumberFormatException err){
				}
			}
		});
		
		eingabeZwischenZaehler2.setColumns(10);
		eingabeZwischenZaehler2.setBounds(100, 151, 25, 20);
		leftPanel.add(eingabeZwischenZaehler2);
		
		//JLabel für den Bruchstrich des zweiten Nenners beim Kehrwert
		JLabel zweiterBruchStrichErweiternLabel = new JLabel("----");
		zweiterBruchStrichErweiternLabel.setHorizontalAlignment(SwingConstants.CENTER);
		zweiterBruchStrichErweiternLabel.setBounds(100, 182, 25, 14);
		leftPanel.add(zweiterBruchStrichErweiternLabel);
		
		
		//Erstellung des zweiten Panels rechts
		Panel rightPanel = new Panel();
		rightPanel.setBounds(276, 10, 299, 241);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);
		
		//JLabel für das Wort "Ergebnis (ohne kürzen)"
		JLabel lblErgebnisOhneKuerzen = new JLabel("Ergebnis (ohne kürzen)");
		lblErgebnisOhneKuerzen.setBounds(20, 11, 150, 14);
		rightPanel.add(lblErgebnisOhneKuerzen);
		
		//JLabel für das Wort "Ergebnis (mit kürzen)"
		JLabel lblErgebnis = new JLabel("Ergebnis (mit kürzen)");
		lblErgebnis.setBounds(170, 11, 150, 14);
		rightPanel.add(lblErgebnis);
		
		//JTextField für die Eingabe des Ergebnis des Zählers ohne kürzen
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeErgebnisZaehlerOhneKuerzen = new JTextField();
		eingabeErgebnisZaehlerOhneKuerzen.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getErgebnisZaehlerOhneKuerzen = eingabeErgebnisZaehlerOhneKuerzen.getText();
			    try{
			        int parsedErgebnisZaehlerOhneKuerzen = Integer.parseInt(getErgebnisZaehlerOhneKuerzen);
			        if (ergebnisZaehlerOhneKuerzen == parsedErgebnisZaehlerOhneKuerzen) {
					eingabeErgebnisZaehlerOhneKuerzen.setBackground(Color.GREEN);
					
				}
				else {
					eingabeErgebnisZaehlerOhneKuerzen.setBackground(Color.RED);
				}
			    }
			    catch(NumberFormatException err){
			    }
			}
		});
		
		eingabeErgebnisZaehlerOhneKuerzen.setColumns(10);
		eingabeErgebnisZaehlerOhneKuerzen.setBounds(20, 36, 25, 20);
		rightPanel.add(eingabeErgebnisZaehlerOhneKuerzen);
		
		//JTextField für die Eingabe des Ergebnis des Nenners ohne kürzen
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeErgebnisNennerOhneKuerzen = new JTextField();
		eingabeErgebnisNennerOhneKuerzen.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getErgebnisNennerOhneKuerzen = eingabeErgebnisNennerOhneKuerzen.getText();
				try{
					int parsedErgebnisNennerOhneKuerzen = Integer.parseInt(getErgebnisNennerOhneKuerzen);
					
					if (ergebnisNennerOhneKuerzen == parsedErgebnisNennerOhneKuerzen) {
						eingabeErgebnisNennerOhneKuerzen.setBackground(Color.GREEN);
					}
					else {
						eingabeErgebnisNennerOhneKuerzen.setBackground(Color.RED);
					}
			    }
			    catch(NumberFormatException err){
			    }
			}
		});
		
		eingabeErgebnisNennerOhneKuerzen.setColumns(10);
		eingabeErgebnisNennerOhneKuerzen.setBounds(20, 94, 25, 20);
		rightPanel.add(eingabeErgebnisNennerOhneKuerzen);
		
		//JLabel für den Bruchstrich des Ergebnis ohne kürzen
		JLabel bruchstrichErgebnisOhneKuerzenLabel = new JLabel("----");
		bruchstrichErgebnisOhneKuerzenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bruchstrichErgebnisOhneKuerzenLabel.setBounds(20, 69, 25, 14);
		rightPanel.add(bruchstrichErgebnisOhneKuerzenLabel);
		
		//JTextField für die Eingabe des Ergebnis des Zählers mit kürzen
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeErgebnisZaehler = new JTextField();
		eingabeErgebnisZaehler.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getErgebnisZaehler = eingabeErgebnisZaehler.getText();
			    try{
			        int parsedErgebnisZaehler = Integer.parseInt(getErgebnisZaehler);
			        if (ergebnisZaehler == parsedErgebnisZaehler) {
					eingabeErgebnisZaehler.setBackground(Color.GREEN);
					
				}
				else {
					eingabeErgebnisZaehler.setBackground(Color.RED);
				}
			    }
			    catch(NumberFormatException err){
			    }
			}
		});
		
		eingabeErgebnisZaehler.setColumns(10);
		eingabeErgebnisZaehler.setBounds(170, 36, 25, 20);
		rightPanel.add(eingabeErgebnisZaehler);
		
		//JTextField für die Eingabe des Ergebnis des Nenners mit kürzen
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeErgebnisNenner = new JTextField();
		eingabeErgebnisNenner.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getErgebnisNenner = eingabeErgebnisNenner.getText();
				try{
					int parsedErgebnisNenner = Integer.parseInt(getErgebnisNenner);
					
					if (ergebnisNenner == parsedErgebnisNenner) {
						eingabeErgebnisNenner.setBackground(Color.GREEN);
					}
					else {
						eingabeErgebnisNenner.setBackground(Color.RED);
					}
			    }
			    catch(NumberFormatException err){
			    }
			}
		});
		
		eingabeErgebnisNenner.setColumns(10);
		eingabeErgebnisNenner.setBounds(170, 94, 25, 20);
		rightPanel.add(eingabeErgebnisNenner);
		
		//JLabel für den Bruchstrich des Ergebnis mit kürzen
		JLabel bruchstrichErgebnisLabel = new JLabel("----");
		bruchstrichErgebnisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bruchstrichErgebnisLabel.setBounds(170, 69, 25, 14);
		rightPanel.add(bruchstrichErgebnisLabel);		
				
		//JButton für die Erzeugung einer neuen Aufgabe durch die Methode ErstelleAufgabe()
		//Texte und Hintergründe der einzelnen Textfelder werden zurückgesetzt
		JButton btnNeueAufgabe = new JButton("Neue Aufgabe");
		btnNeueAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ErstelleAufgabe();
				eingabeZwischenZaehler1.setText("");
				eingabeZwischenZaehler1.setBackground(Color.WHITE);
				eingabeZwischenNenner1.setText("");
				eingabeZwischenNenner1.setBackground(Color.WHITE);
				eingabeZwischenNenner2.setText("");
				eingabeZwischenNenner2.setBackground(Color.WHITE);
				eingabeZwischenZaehler2.setText("");
				eingabeZwischenZaehler2.setBackground(Color.WHITE);
				eingabeErgebnisZaehlerOhneKuerzen.setText("");
				eingabeErgebnisZaehlerOhneKuerzen.setBackground(Color.WHITE);
				eingabeErgebnisNennerOhneKuerzen.setText("");
				eingabeErgebnisNennerOhneKuerzen.setBackground(Color.WHITE);	
				eingabeErgebnisZaehler.setText("");
				eingabeErgebnisZaehler.setBackground(Color.WHITE);
				eingabeErgebnisNenner.setText("");
				eingabeErgebnisNenner.setBackground(Color.WHITE);	
			}
		});
		btnNeueAufgabe.setBounds(20, 207, 115, 23);
		rightPanel.add(btnNeueAufgabe);
		
		//Button "Zurück", schließt das aktuelle Fenster und geht zur Rechenauswahl zurück
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Bruch();
			}
		});
		btnZurck.setBounds(166, 207, 115, 23);
		rightPanel.add(btnZurck);
		
		//Methode wird aufgerufen, damit am Anfang eine Aufgabe erstellt wird
		ErstelleAufgabe();
	}
	
	public void ErstelleAufgabe() {
		//Vier Zufallszahlen zwischen 1 und 5 für die Brüche werden generiert
		int zaehler1 = (int)(Math.random()*5) + 1;
		int nenner1 = (int)(Math.random()*5) + 1;
		int zaehler2 = (int)(Math.random()*5) + 1;
		int nenner2 = (int)(Math.random()*5) + 1;
		
		//Die Integer werden zu Strings geparst, um sie in die jeweiligen JLabel zu schreiben
		String zaehler1String = String.valueOf(zaehler1);
		String zaehler2String = String.valueOf(zaehler2);
		String nenner1String = String.valueOf(nenner1);
		String nenner2String = String.valueOf(nenner2);		
		
		//Die Zahlen werden in das JLabel geschrieben
		ersterZaehlerLabel.setText(zaehler1String);
		ersterNennerLabel.setText(nenner1String);
		zweiterZaehlerLabel.setText(zaehler2String);
		zweiterNennerLabel.setText(nenner2String);
		
		//Rechnung für die Divison
		ergebnisZwischenNenner = nenner1;
		ergebnisZwischenNenner2 = zaehler2;
		ergebnisZwischenZaehler1 = zaehler1;
		ergebnisZwischenZaehler2 = nenner2;
	
		ergebnisZaehlerOhneKuerzen = ergebnisZwischenZaehler1 * ergebnisZwischenZaehler2;
		ergebnisNennerOhneKuerzen = ergebnisZwischenNenner * ergebnisZwischenNenner2;

		
		ergebnisZaehler = ergebnisZaehlerOhneKuerzen / ggt(ergebnisZaehlerOhneKuerzen, ergebnisZwischenNenner);
		ergebnisNenner = ergebnisNennerOhneKuerzen / ggt(ergebnisNennerOhneKuerzen, ergebnisZaehlerOhneKuerzen);
	}
	
	//Der größte gemeinsame Teiler wird zurückgegeben, um die Brüche kürzen zu können
	int ggt(int a, int b) {
		if (b == 0) {
			return a;
		}
		else {
			return(ggt(b,a % b));
		}
	}
}