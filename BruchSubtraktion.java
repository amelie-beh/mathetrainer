package mathetrainer;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.SwingConstants;

public class BruchSubtraktion extends JFrame {

	private JPanel contentPane;
	private JTextField eingabeZwischenZaehler1;
	private JTextField eingabeZwischenNenner1;
	private JTextField eingabeZwischenNenner2;
	private JTextField eingabeZwischenZaehler2;
	private JTextField eingabeErgebnisZaehler;
	private JTextField eingabeErgebnisNenner;
	private JLabel ersterZaehlerLabel;
	private JLabel zweiterZaehlerLabel;
	private JLabel ersterNennerLabel;
	private JLabel zweiterNennerLabel;
	int ergebnisZwischenNenner;
	int ergebnisZwischenZaehler1;
	int ergebnisZwischenZaehler2;
	int ergebnisZaehler; 
	int ergebnisNenner;
	int aufgabenCounter;

	public BruchSubtraktion() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 300);
		
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
		JLabel rechenartLabel = new JLabel("-");
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
		
		//JLabel für das Wort "Erweitern"
		JLabel lblErweitern = new JLabel("Erweitern");
		lblErweitern.setBounds(20, 126, 60, 14);
		leftPanel.add(lblErweitern);
		
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
		
		//JLabel für den Bruchstrich des ersten Bruches beim Erweitern
		JLabel ersterBruchStrichErweiternLabel = new JLabel("----");
		ersterBruchStrichErweiternLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ersterBruchStrichErweiternLabel.setBounds(20, 182, 25, 14);
		leftPanel.add(ersterBruchStrichErweiternLabel);
		
		//JTextField für die Eingabe des Zwischenergebnisses des Nenners des ersten Bruches
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
		
		//JLabel für die Rechenart beim Bruch Erweitern
		JLabel rechenartErweiternLabel = new JLabel("-");
		rechenartErweiternLabel.setBounds(70, 182, 10, 14);
		leftPanel.add(rechenartErweiternLabel);
		
		//JTextField für die Eingabe des Zwischenergebnisses des Nenners des zweiten Bruches
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeZwischenNenner2 = new JTextField();
		eingabeZwischenNenner2.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getZwischenNenner2 = eingabeZwischenNenner1.getText();
				
				try{
					int parsedZwischenNenner2 = Integer.parseInt(getZwischenNenner2);
					if (ergebnisZwischenNenner == parsedZwischenNenner2) {
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
		
		//JTextField für die Eingabe des Zwischenergebnisses des Zählers des zweiten Bruches
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
		
		//JLabel für den Bruchstrich des zweiten Nenners beim erweitern
		JLabel zweiterBruchStrichErweiternLabel = new JLabel("----");
		zweiterBruchStrichErweiternLabel.setHorizontalAlignment(SwingConstants.CENTER);
		zweiterBruchStrichErweiternLabel.setBounds(100, 182, 25, 14);
		leftPanel.add(zweiterBruchStrichErweiternLabel);
		
		
		//Erstellung des zweiten Panels rechts
		Panel rightPanel = new Panel();
		rightPanel.setBounds(276, 10, 299, 241);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);
		
		//JLabel für das Wort "Ergebnis"
		JLabel lblErgebnis = new JLabel("Ergebnis (mit kürzen)");
		lblErgebnis.setBounds(20, 11, 150, 14);
		rightPanel.add(lblErgebnis);
		
		//JTextField für die Eingabe des Ergebnis des Zählers
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
		eingabeErgebnisZaehler.setBounds(20, 36, 25, 20);
		rightPanel.add(eingabeErgebnisZaehler);
		
		//JTextField für die Eingabe des Ergebnis des Nenners
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
		eingabeErgebnisNenner.setBounds(20, 94, 25, 20);
		rightPanel.add(eingabeErgebnisNenner);
		
		//JLabel für den Bruchstrich des Ergebnis
		JLabel bruchstrichErgebnisLabel = new JLabel("----");
		bruchstrichErgebnisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bruchstrichErgebnisLabel.setBounds(20, 69, 25, 14);
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
		
		//Rechnung für die Addition
		ergebnisZwischenNenner = nenner1 * nenner2;
		ergebnisZwischenZaehler1 = zaehler1 * nenner2;
		ergebnisZwischenZaehler2 = zaehler2 * nenner1;
	
		int ergebnisZwischenZaehlerUngekuerzt = ergebnisZwischenZaehler1 - ergebnisZwischenZaehler2;
		ergebnisZaehler = ergebnisZwischenZaehlerUngekuerzt / ggt(ergebnisZwischenZaehlerUngekuerzt, ergebnisZwischenNenner);
		ergebnisNenner = ergebnisZwischenNenner / ggt(ergebnisZwischenZaehlerUngekuerzt, ergebnisZwischenNenner);
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