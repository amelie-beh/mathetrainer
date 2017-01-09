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

public class BruchMultiplikation extends JFrame {

	private JPanel contentPane;
	private JTextField eingabeZwischenZaehler;
	private JTextField eingabeZwischenNenner;
	private JTextField eingabeErgebnisZaehler;
	private JTextField eingabeErgebnisNenner;
	private JLabel ersterZaehlerLabel;
	private JLabel zweiterZaehlerLabel;
	private JLabel ersterNennerLabel;
	private JLabel zweiterNennerLabel;
	int ergebnisZwischenNenner;
	int ergebnisZwischenZaehler;
	int ergebnisZaehler; 
	int ergebnisNenner;
	int aufgabenCounter;

	public BruchMultiplikation() {
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
		JLabel rechenartLabel = new JLabel("*");
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
		eingabeZwischenZaehler = new JTextField();
		eingabeZwischenZaehler.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getZwischenZaehler = eingabeZwischenZaehler.getText();
				try{
					int parsedZwischenZaehler = Integer.parseInt(getZwischenZaehler);
					if (ergebnisZwischenZaehler == parsedZwischenZaehler) {
						eingabeZwischenZaehler.setBackground(Color.GREEN);
					}
					else {
						eingabeZwischenZaehler.setBackground(Color.RED);
					}
				}
				catch(NumberFormatException err){
				}
			}
		});
		eingabeZwischenZaehler.setBounds(20, 151, 25, 20);
		leftPanel.add(eingabeZwischenZaehler);
		eingabeZwischenZaehler.setColumns(10);
		
		//JLabel für den Bruchstrich des Bruches beim Erweitern
		JLabel ersterBruchStrichErweiternLabel = new JLabel("----");
		ersterBruchStrichErweiternLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ersterBruchStrichErweiternLabel.setBounds(20, 182, 25, 14);
		leftPanel.add(ersterBruchStrichErweiternLabel);
		
		//JTextField für die Eingabe des Zwischenergebnisses des Nenners
		//Event mit dem CaretListener : überprüft ob die Eingabe im Textfeld richtig ist.
		//Wenn ja, wird der Hintergrund auf grün gesetzt, wenn nein auf rot.
		eingabeZwischenNenner = new JTextField();
		eingabeZwischenNenner.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String getZwischenNenner = eingabeZwischenNenner.getText();
				try{
					int parsedZwischenNenner = Integer.parseInt(getZwischenNenner);
					if (ergebnisZwischenNenner == parsedZwischenNenner) {
						eingabeZwischenNenner.setBackground(Color.GREEN);
					}
					else {
						eingabeZwischenNenner.setBackground(Color.RED);
					}
				}
				catch(NumberFormatException err){
				}
			}
		});
		eingabeZwischenNenner.setColumns(10);
		eingabeZwischenNenner.setBounds(20, 207, 25, 20);
		leftPanel.add(eingabeZwischenNenner);
				
		
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
				eingabeZwischenZaehler.setText("");
				eingabeZwischenZaehler.setBackground(Color.WHITE);
				eingabeZwischenNenner.setText("");
				eingabeZwischenNenner.setBackground(Color.WHITE);
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
		ergebnisZwischenZaehler = zaehler1 * zaehler2;
	
		ergebnisZaehler = ergebnisZwischenZaehler / ggt(ergebnisZwischenZaehler, ergebnisZwischenNenner);
		ergebnisNenner = ergebnisZwischenNenner / ggt(ergebnisZwischenNenner, ergebnisZwischenZaehler);
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