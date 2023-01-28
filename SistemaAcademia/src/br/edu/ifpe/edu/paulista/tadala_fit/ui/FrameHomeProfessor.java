package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.ifpe.paulista.tadala_fit.core.Professor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrameHomeProfessor {

	protected JFrame framehomeprofessor;
	protected FrameHomeProfessor window;
	protected Professor professorAtual;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHomeProfessor window = new FrameHomeProfessor();
					window.framehomeprofessor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrameHomeProfessor() {
		initialize();
	}


	private void initialize() {
		framehomeprofessor = new JFrame();
		framehomeprofessor.setTitle("TadalaFit - Versão - 1.0");
		framehomeprofessor.getContentPane().setForeground(new Color(255, 255, 255));
		framehomeprofessor.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameHomeAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		framehomeprofessor.setResizable(false);
		framehomeprofessor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja fechar a aplicação?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					framehomeprofessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					framehomeprofessor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		framehomeprofessor.getContentPane().setBackground(new Color(0, 79, 157));
		framehomeprofessor.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 65, 130));
		panel.setBounds(44, 11, 258, 708);
		framehomeprofessor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameHomeProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel.setBounds(30, 53, 200, 159);
		panel.add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja sair?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin fl = new FrameLogin();
					fl.framelogin.setVisible(true);
					framehomeprofessor.dispose();
				}else {
	
			  }
			}
		});
		btnSair.setFont(new Font("Arial", Font.BOLD, 13));
		btnSair.setBackground(Color.WHITE);
		btnSair.setBounds(45, 436, 176, 33);
		panel.add(btnSair);
		
		JButton btnMeuperfil = new JButton("Meu Perfil");
		btnMeuperfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnMeuperfil.setBackground(Color.WHITE);
		btnMeuperfil.setBounds(45, 371, 176, 33);
		panel.add(btnMeuperfil);
		
		JButton btnMeusaluno = new JButton("Meus Alunos");
		btnMeusaluno.setFont(new Font("Arial", Font.BOLD, 13));
		btnMeusaluno.setBackground(Color.WHITE);
		btnMeusaluno.setBounds(45, 305, 176, 33);
		panel.add(btnMeusaluno);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrameHomeProfessor.class.getResource("/assets_loginFrame/Logotipo_academia_personal_trainner__1_-removebg-preview.png")));
		lblNewLabel_1.setBounds(380, 113, 481, 442);
		framehomeprofessor.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2023 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(473, 679, 324, 40);
		framehomeprofessor.getContentPane().add(lblNewLabel_2);
		
	}

	public void getProfessor(Professor professorLogado) {
		// TODO Auto-generated method stub
		
	}
}
