package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FramePerfilAluno {

	protected JFrame frameperfilaluno;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePerfilAluno window = new FramePerfilAluno();
					window.frameperfilaluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FramePerfilAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameperfilaluno = new JFrame();
		frameperfilaluno.getContentPane().setBackground(new Color(0, 79, 157));
		frameperfilaluno.getContentPane().setLayout(null);
		frameperfilaluno.setResizable(false);
		frameperfilaluno.setTitle("TadalaFit - Versão - 1.0");
		frameperfilaluno.setBounds(100, 100, 450, 300);
		frameperfilaluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameperfilaluno.setBounds(100, 100, 1025, 769);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 79, 157));
		panel.setBounds(10, 11, 988, 708);
		frameperfilaluno.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(232, 105, 72, 20);
		panel.add(lblNewLabel);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblTelefone.setBounds(232, 150, 101, 24);
		panel.add(lblTelefone);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCpf.setBounds(583, 150, 72, 24);
		panel.add(lblCpf);
		
		JLabel lblDataNasc = new JLabel("DATA NASC:");
		lblDataNasc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDataNasc.setBounds(244, 197, 101, 24);
		panel.add(lblDataNasc);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmail.setBounds(501, 196, 72, 26);
		panel.add(lblEmail);
		
		JLabel lblPeso = new JLabel("PESO:");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPeso.setBounds(232, 244, 72, 24);
		panel.add(lblPeso);
		
		JLabel lblAltura = new JLabel("ALTURA:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblAltura.setBounds(472, 246, 72, 24);
		panel.add(lblAltura);
		
		JLabel lblComorbidade = new JLabel("COMORBIDADE:");
		lblComorbidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComorbidade.setForeground(Color.WHITE);
		lblComorbidade.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblComorbidade.setBounds(252, 294, 113, 24);
		panel.add(lblComorbidade);
		
		JLabel lblBf = new JLabel("BF:");
		lblBf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBf.setForeground(Color.WHITE);
		lblBf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblBf.setBounds(761, 244, 72, 24);
		panel.add(lblBf);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(348, 657, 324, 40);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 65, 130));
		panel_2.setBounds(22, 366, 956, 10);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(22, 567, 200, 130);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(FrameCadastro.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(49, 116, 173, 178);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 11, 150, 150);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(FrameCadastro.class.getResource("/assets_loginFrame/user.png")));
		
		JLabel lblnome = new JLabel("");
		lblnome.setBounds(326, 109, 178, 14);
		panel.add(lblnome);
		
		JLabel lbltelefone = new JLabel("");
		lbltelefone.setBounds(343, 150, 183, 24);
		panel.add(lbltelefone);
		
		JLabel lblcpf = new JLabel("");
		lblcpf.setBounds(677, 156, 178, 14);
		panel.add(lblcpf);
		
		JLabel lbldata = new JLabel("");
		lbldata.setBounds(348, 203, 178, 14);
		panel.add(lbldata);
		
		JLabel lblemail = new JLabel("");
		lblemail.setBounds(583, 203, 178, 14);
		panel.add(lblemail);
		
		JLabel lblpeso = new JLabel("");
		lblpeso.setBounds(308, 250, 178, 14);
		panel.add(lblpeso);
		
		JLabel lblaltura = new JLabel("");
		lblaltura.setBounds(547, 250, 178, 14);
		panel.add(lblaltura);
		
		JLabel lblbf = new JLabel("");
		lblbf.setBounds(843, 250, 178, 14);
		panel.add(lblbf);
		
		JLabel lblcomorbidade = new JLabel("");
		lblcomorbidade.setBounds(375, 300, 178, 14);
		panel.add(lblcomorbidade);
		
		JLabel lblcomorbidade_1 = new JLabel("");
		lblcomorbidade_1.setBounds(682, 300, 178, 14);
		panel.add(lblcomorbidade_1);
		
		JLabel lblSatus = new JLabel("STATUS:");
		lblSatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSatus.setForeground(Color.WHITE);
		lblSatus.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblSatus.setBounds(250, 433, 139, 24);
		panel.add(lblSatus);
		
		JLabel lblstatus = new JLabel("");
		lblstatus.setBounds(394, 437, 183, 20);
		panel.add(lblstatus);
		
		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja voltar?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					FrameHomeAluno fha = new FrameHomeAluno();
					fha.framehomealuno.setVisible(true);
					frameperfilaluno.dispose();
					
				}else {
				}
			}
		});
		btnvoltar.setBounds(434, 567, 139, 40);
		panel.add(btnvoltar);
	}

}
