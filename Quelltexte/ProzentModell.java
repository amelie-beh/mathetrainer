package MatheTrainer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JLabel;


public class ProzentModell {

	Random rand = new Random();
	
	//Schwierigkeitsgrad1
	

	DecimalFormat f = new DecimalFormat("#0.00");
	public int wert;
	public int prozent;
	

	ArrayList<String> aufgaben = new ArrayList<String>();
	ArrayList<Double> prozente = new ArrayList<Double>();
	ArrayList<Double> werte = new ArrayList<Double>();
	
	String aufgabe;
	
	String aufgabe1;
	
	//= "Herr Bauer benötigt für seinen Garten" + a + "m Maschendrahtzaun und bezahlt dafür"+ wert+"€."
	//		+ "a) Nachbar Meier braucht" + a + "m vom selben Draht. Wie teuer wird das ?";
	String aufgabe2;

	
	
	public ProzentModell() {
				
		newWert();
		newProzent();


	}
	public int newWert(){
		wert = rand.nextInt(150) +1;
		return wert;
	}
	
	public int newProzent() {
		prozent = rand.nextInt(100) +1 ;
		return prozent;
	}
	
	
	public void addTasks(){
		newValues();
		werte.add((double) wert);
		prozente.add((double) prozent);
		aufgabe = "Herr Maier kauft ein T-Shirt für " + wert + " und erhält an der Kasse einen rabat von "+prozent
				+ "\n a) wieviel Euro rabat erhält Herr Maier?";
		newValues();
		werte.add((double) wert);
		prozente.add((double) prozent);
		aufgabe1 = "Frau Musterfrau kauft eine Handkreissäge für "+ wert +". Zu diesem Nettopreis kommen noch "+prozent+"% Mehrwertsteuer hinzu. Wie viel kostet die Handkreissäge insgesamt?";
		newValues();
		werte.add((double) wert);
		prozente.add((double) prozent);
		aufgabe2 = "Wieviel sind "+prozent+"% von "+wert;
		
		aufgaben.add(aufgabe);
		aufgaben.add(aufgabe1);
		aufgaben.add(aufgabe2);
	}
	
	public void newValues(){
		newWert();
		newProzent();
	}

	public String getAufgabe() {
		return aufgabe;
	}
	public int getWert() {
		return wert;
	}
	public int getProzent() {
		return prozent;
	}
	
}
