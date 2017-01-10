package MatheTrainer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Random;

public class ProzentController {

	Random rand = new Random();
	ProzentTrainingView view;
	ProzentModell modell;
	
	private boolean firstValue;
	private boolean secondValue;
	private boolean thirdValue;
	private boolean fourthValue;
	private boolean fifthValue;
	private boolean sixthValue;
	
	private int checkValue;
	private int i = 0;
	private int wert ;
	private int prozent;
	
	DecimalFormat f = new DecimalFormat("#0.00");
	DecimalFormat g = new DecimalFormat("0.0");
	
	
	public ProzentController(ProzentTrainingView view, ProzentModell modell) {
		this.view = view;
		this.modell = modell;
		
		ShowAufgaben();
		nextAufgabe();
		Check();	
		Hauptmenü();
	}
	
	
	public void ShowAufgaben(){
		checkValue = 0;
		modell.addTasks();
		System.out.println(f.format(modell.werte.get(i)/100));
		System.out.println(f.format((modell.werte.get(i)/100) * modell.prozente.get(i)));
		view.getVerstanden().addActionListener(l->{
			view.getErklärung().setText(modell.aufgaben.get(0));
			view.getAufgabenPanel().remove(view.getVerstanden());
			
		});		
	}
	
	
	public void Hauptmenü(){
		view.getReturnbtn().addActionListener(l->{
				view.dispose();
				MainWindow main = new MainWindow();
				main.setVisible(true);
		});
		
	}

	
	public void nextAufgabe(){
		checkValue = 0;
		view.getSubmitbtn().addActionListener(e->{
			modell.addTasks();
		view.getFirstProzentField().setText("");
		view.getSecondProzentField().setText("");
		view.getThirdProzentField().setText("");
		view.getFirstValueField().setText("");
		view.getSecondValueField().setText("");
		view.getThirdValueField().setText("");
			i +=1;
			if(i<= modell.aufgaben.size()){
			view.getErklärung().setText(modell.aufgaben.get(i));
			}
			view.getSubmitbtn().setEnabled(false);
		});
	}
	
	public void Check(){

		view.getFirstProzentField().addCaretListener(l->{
			if(view.getFirstProzentField().getText().equals("100")){
				view.getFirstProzentField().setBackground(Color.GREEN);
				firstValue = true;
				checkValue++;
				CheckValue();
			}
			else{
				view.getFirstProzentField().setBackground(Color.RED);
				firstValue = false;
			}
		});
		
		view.getSecondProzentField().addCaretListener(l->{
			if(view.getSecondProzentField().getText().equals("1")){
				view.getSecondProzentField().setBackground(Color.GREEN);
				secondValue = true;
				checkValue++;
				CheckValue();
			}
			else{
				view.getSecondProzentField().setBackground(Color.RED);
				secondValue = false;
			}
		});
		
		view.getThirdProzentField().addCaretListener(l->{
			if(view.getThirdProzentField().getText().equals(String.valueOf(modell.prozente.get(i)))){
				view.getThirdProzentField().setBackground(Color.GREEN);
				thirdValue = true;
				checkValue++;
				CheckValue();
			}
			else{
				view.getThirdProzentField().setBackground(Color.RED);
				thirdValue = false;
			}
		});
		
		view.getFirstValueField().addCaretListener(l->{
			if(view.getFirstValueField().getText().equals(String.valueOf(modell.werte.get(i)))){
				view.getFirstValueField().setBackground(Color.GREEN);
				fourthValue = true;
				checkValue++;
				CheckValue();
			}
			else{
				view.getFirstValueField().setBackground(Color.RED);
				fourthValue = false;

			}
		});
		
		view.getSecondValueField().addCaretListener(l->{
			if(view.getSecondValueField().getText().equals(String.valueOf(f.format(modell.werte.get(i)/100)))){
				view.getSecondValueField().setBackground(Color.GREEN);
				fifthValue = true;
				checkValue++;
				CheckValue();

			}
			else{
				view.getSecondValueField().setBackground(Color.RED);
				fifthValue = false;
			}
		});
		view.getThirdValueField().addCaretListener(l->{
			if(view.getThirdValueField().getText().equals(String.valueOf(f.format((modell.werte.get(i)/100) * modell.prozente.get(i))))){
				view.getThirdValueField().setBackground(Color.GREEN);
				sixthValue = true;
				checkValue++;
				CheckValue();
		}
			else{
				view.getThirdValueField().setBackground(Color.RED);
				sixthValue = false;
			}
		});	
		

	}
	
	public void CheckValue(){
			if(checkValue == 6){
			view.getSubmitbtn().setEnabled(true);
		}
	}
	
	
	
	}

