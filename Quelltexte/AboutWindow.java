package MatheTrainer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutWindow extends JFrame{

//	JFrame aboutWindow;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AboutWindow window = new AboutWindow();
//					window.aboutWindow.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public AboutWindow() {
		initialize();
		setResizable(false);
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	private void initialize() {			
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("About");
		getContentPane().setLayout(null);
		
		JLabel lblProjekt = new JLabel("Projekt 1 - \"Der Mathetrainer\" von:");
		lblProjekt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProjekt.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjekt.setBounds(10, 11, 414, 48);
		getContentPane().add(lblProjekt);
		
		JLabel lblNewLabel = new JLabel("Amelie");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 70, 195, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDennisKahya = new JLabel("Behrendt");
		lblDennisKahya.setHorizontalAlignment(SwingConstants.LEFT);
		lblDennisKahya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDennisKahya.setBounds(215, 70, 209, 33);
		getContentPane().add(lblDennisKahya);
		
		JButton btnHauptmen = new JButton("Hauptmen\u00FC");
		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindow main = new MainWindow();
				main.setVisible(true);
			}
		});
		btnHauptmen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHauptmen.setBounds(160, 227, 105, 23);
		getContentPane().add(btnHauptmen);
		
		JLabel lblKahya = new JLabel("Kahya");
		lblKahya.setHorizontalAlignment(SwingConstants.LEFT);
		lblKahya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKahya.setBounds(215, 103, 209, 33);
		getContentPane().add(lblKahya);
		
		JLabel lblDennis = new JLabel("Dennis");
		lblDennis.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDennis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDennis.setBounds(10, 103, 195, 33);
		getContentPane().add(lblDennis);
		
		JLabel lblShayan = new JLabel("Shayan");
		lblShayan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblShayan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShayan.setBounds(10, 136, 195, 33);
		getContentPane().add(lblShayan);
		
		JLabel lblKeshmiri = new JLabel("Keshmiri");
		lblKeshmiri.setHorizontalAlignment(SwingConstants.LEFT);
		lblKeshmiri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKeshmiri.setBounds(215, 136, 195, 33);
		getContentPane().add(lblKeshmiri);
		
		JLabel lblTim = new JLabel("Tim");
		lblTim.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTim.setBounds(10, 169, 195, 33);
		getContentPane().add(lblTim);
		
		JLabel lblNeumann = new JLabel("Neumann");
		lblNeumann.setHorizontalAlignment(SwingConstants.LEFT);
		lblNeumann.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNeumann.setBounds(215, 169, 195, 33);
		getContentPane().add(lblNeumann);
	}

}

