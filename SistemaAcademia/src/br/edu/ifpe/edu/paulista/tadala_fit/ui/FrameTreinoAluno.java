package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FrameTreinoAluno {

	private JFrame frametreinoaluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTreinoAluno window = new FrameTreinoAluno();
					window.frametreinoaluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameTreinoAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frametreinoaluno = new JFrame();
		frametreinoaluno.setResizable(false);
		frametreinoaluno.getContentPane().setBackground(new Color(0, 79, 157));
		frametreinoaluno.getContentPane().setForeground(new Color(0, 79, 157));
		frametreinoaluno.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 65, 130));
		panel.setBounds(44, 11, 258, 708);
		frametreinoaluno.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameTreinoAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel.setBounds(29, 22, 204, 200);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(329, 101, 105, 32);
		frametreinoaluno.getContentPane().add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(472, 101, 105, 32);
		frametreinoaluno.getContentPane().add(panel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(606, 101, 105, 32);
		frametreinoaluno.getContentPane().add(panel_1_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(329, 163, 654, 381);
		frametreinoaluno.getContentPane().add(panel_1_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBounds(744, 101, 105, 32);
		frametreinoaluno.getContentPane().add(panel_1_4);
		
		JPanel panel_1_4_1 = new JPanel();
		panel_1_4_1.setBounds(878, 101, 105, 32);
		frametreinoaluno.getContentPane().add(panel_1_4_1);
		frametreinoaluno.setTitle("Tadalafit - Versão 1.0");
		frametreinoaluno.setBounds(100, 100, 1024, 768);
		frametreinoaluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
