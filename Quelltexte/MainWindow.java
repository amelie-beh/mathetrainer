package MatheTrainer;


import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {


	private int training;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		initialize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
	


	public void changeTraining(int training){
		
		this.training = training;

		switch(this.training){
		case 0:
			this.dispose();
			Bruch BruchRechnung = new Bruch();
			BruchRechnung.setVisible(true);
			break;
		case 1:
			this.dispose();
			PythMain SatzDesPythagoras = new PythMain();
			SatzDesPythagoras.setVisible(true);
			System.out.println("im here");
			break;
		case 2:
			this.dispose();
			ProzentMain DreiSatz = new ProzentMain();
//			DreiSatz.setVisible(true);
			break;
		case 3:
			System.out.println("komm schon");
			this.dispose();
			RingCalc RestKlassenRinge = new RingCalc();
			RestKlassenRinge.setVisible(true);
			
			break;
		}
	}
	
	private void initialize() {
		
		
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Der Mathetrainer");
		getContentPane().setLayout(null);
		
		JButton btnBruchrechnung = new JButton("Bruchrechnung");
		btnBruchrechnung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTraining(0);
			}
		});
		btnBruchrechnung.setBounds(10, 81, 156, 55);
		getContentPane().add(btnBruchrechnung);
		
		JButton btnSatzDesPythagoras = new JButton("Satz des Pythagoras");
		btnSatzDesPythagoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTraining(1);
			}
		});
		btnSatzDesPythagoras.setBounds(268, 81, 156, 55);
		getContentPane().add(btnSatzDesPythagoras);
		
		JButton btnDreisatz = new JButton("Dreisatz");
		btnDreisatz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				changeTraining(2);
			}
		});
		btnDreisatz.setBounds(10, 147, 156, 59);
		getContentPane().add(btnDreisatz);
		
		JButton btnRestklassenringe = new JButton("Restklassenringe");
		btnRestklassenringe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTraining(3);	
			}
		});
		btnRestklassenringe.setBounds(268, 147, 156, 59);
		getContentPane().add(btnRestklassenringe);
		
		JLabel lblDerMathetrainer = new JLabel("Der Mathetrainer");
		lblDerMathetrainer.setHorizontalAlignment(SwingConstants.CENTER);
		lblDerMathetrainer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDerMathetrainer.setBounds(10, 11, 414, 59);
		getContentPane().add(lblDerMathetrainer);
		
		JButton btnNewButton = new JButton("About");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				AboutWindow about = new AboutWindow();
				about.setVisible(true);									
			}
		});
		btnNewButton.setBounds(176, 217, 82, 33);
		getContentPane().add(btnNewButton);
	}

}
