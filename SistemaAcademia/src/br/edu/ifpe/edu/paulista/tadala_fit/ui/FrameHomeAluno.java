package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;


public class FrameHomeAluno {

	protected JFrame framehomealuno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHomeAluno window = new FrameHomeAluno();
					window.framehomealuno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameHomeAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		framehomealuno = new JFrame();
		framehomealuno.getContentPane().setForeground(new Color(255, 255, 255));
		framehomealuno.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameHomeAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		framehomealuno.setResizable(false);
		framehomealuno.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja fechar a aplicação?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					framehomealuno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					framehomealuno.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		framehomealuno.getContentPane().setBackground(new Color(0, 79, 157));
		framehomealuno.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 65, 130));
		panel.setBounds(44, 11, 258, 708);
		framehomealuno.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameHomeAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel.setBounds(30, 53, 200, 159);
		panel.add(lblNewLabel);
		
		JButton btnverperfil = new JButton("Meu Perfil");
		btnverperfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FramePerfilAluno fpa = new FramePerfilAluno();
				fpa.frameperfilaluno.setVisible(true);
				framehomealuno.dispose();
			}
		});
		btnverperfil.setBackground(new Color(240, 240, 240));
		btnverperfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnverperfil.setBounds(57, 256, 151, 33);
		panel.add(btnverperfil);
		
		JButton btnconsultartreino = new JButton("Consultar Treino");
		btnconsultartreino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameTreinoAluno fta = new FrameTreinoAluno();
				fta.frametreinoaluno.setVisible(true);
				framehomealuno.dispose();
			}
		});
		btnconsultartreino.setBackground(new Color(255, 255, 255));
		btnconsultartreino.setFont(new Font("Arial", Font.BOLD, 13));
		btnconsultartreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnconsultartreino.setBounds(57, 344, 151, 33);
		panel.add(btnconsultartreino);
		
		JButton btnsair = new JButton("Sair");
		btnsair.setBackground(new Color(255, 255, 255));
		btnsair.setFont(new Font("Arial", Font.BOLD, 13));
		btnsair.setBounds(57, 430, 150, 33);
		panel.add(btnsair);
		btnsair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja sair?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin fl = new FrameLogin();
					fl.framelogin.setVisible(true);
					framehomealuno.dispose();
				}else {
	
			  }
		    }
		});
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrameHomeAluno.class.getResource("/assets_loginFrame/Logotipo_academia_personal_trainner__1_-removebg-preview.png")));
		lblNewLabel_1.setBounds(380, 113, 481, 442);
		framehomealuno.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(472, 679, 324, 40);
		framehomealuno.getContentPane().add(lblNewLabel_2);
		framehomealuno.setTitle("TadalaFit - Versão - 1.0");
		framehomealuno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framehomealuno.setBounds(100, 100, 1024, 769);
	}

	public void getAluno(Aluno alunoLogado) {
		// TODO Auto-generated method stub
		
	}
}
