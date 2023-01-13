package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FrameTreinoAluno {

	protected JFrame frametreinoaluno;

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
		frametreinoaluno.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja fechar a aplicação?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					frametreinoaluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}else {
					frametreinoaluno.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		frametreinoaluno.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameTreinoAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		frametreinoaluno.setResizable(false);
		frametreinoaluno.getContentPane().setBackground(new Color(0, 79, 157));
		frametreinoaluno.getContentPane().setForeground(new Color(0, 79, 157));
		frametreinoaluno.getContentPane().setLayout(null);
		
		JPanel paneltreino = new JPanel();
		paneltreino.setBounds(181, 179, 647, 381);
		frametreinoaluno.getContentPane().add(paneltreino);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(45, 529, 204, 200);
		frametreinoaluno.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(FrameTreinoAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		
		JButton btnB = new JButton("B");
		btnB.setBackground(new Color(255, 255, 255));
		btnB.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnB.setBounds(312, 113, 121, 40);
		frametreinoaluno.getContentPane().add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.setBackground(new Color(255, 255, 255));
		btnC.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnC.setBounds(443, 113, 121, 40);
		frametreinoaluno.getContentPane().add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.setBackground(new Color(255, 255, 255));
		btnD.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnD.setBounds(574, 113, 121, 40);
		frametreinoaluno.getContentPane().add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.setBackground(new Color(255, 255, 255));
		btnE.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnE.setBounds(705, 113, 121, 40);
		frametreinoaluno.getContentPane().add(btnE);
		
		JLabel lblNewLabel_1 = new JLabel("TREINOS");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(453, 67, 168, 14);
		frametreinoaluno.getContentPane().add(lblNewLabel_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameHomeAluno fha = new FrameHomeAluno();
				fha.framehomealuno.setVisible(true);
				frametreinoaluno.dispose();
			}
		});
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));
		btnVoltar.setBackground(new Color(0, 69, 130));
		btnVoltar.setBounds(769, 614, 121, 40);
		frametreinoaluno.getContentPane().add(btnVoltar);
		
		JButton btnA = new JButton("A");
		btnA.setBackground(new Color(255, 255, 255));
		btnA.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnA.setBounds(181, 113, 121, 40);
		frametreinoaluno.getContentPane().add(btnA);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 18));
		btnAlterar.setBackground(new Color(0, 69, 130));
		btnAlterar.setBounds(244, 614, 121, 40);
		frametreinoaluno.getContentPane().add(btnAlterar);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("Arial", Font.BOLD, 18));
		btnImprimir.setBackground(new Color(0, 69, 130));
		btnImprimir.setBounds(383, 614, 121, 40);
		frametreinoaluno.getContentPane().add(btnImprimir);
		frametreinoaluno.setTitle("Tadalafit - Versão 1.0");
		frametreinoaluno.setBounds(100, 100, 1024, 768);
		frametreinoaluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
