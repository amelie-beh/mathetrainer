package MatheTrainer;

import javax.swing.JFrame;

public class ProzentMain extends JFrame{
	
	public ProzentMain() {
		ProzentTrainingView view = new ProzentTrainingView();
		ProzentModell modell = new ProzentModell();
		new ProzentController(view, modell);
		
	}
}
