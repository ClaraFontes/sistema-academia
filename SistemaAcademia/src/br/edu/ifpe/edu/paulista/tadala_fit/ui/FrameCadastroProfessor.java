package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class FrameCadastroProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCadastroProfessor frame = new FrameCadastroProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameCadastroProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 769);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 79, 157));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 65, 130));
		panel.setBounds(22, 414, 956, 10);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(22, 567, 200, 159);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(FrameCadastroProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(348, 667, 324, 40);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(49, 116, 173, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 11, 150, 150);
		lblNewLabel_1.setIcon(new ImageIcon(FrameCadastroProfessor.class.getResource("/assets_loginFrame/user.png")));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmail.setBounds(241, 161, 72, 20);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOME:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(241, 116, 72, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblTelefone.setBounds(234, 206, 79, 20);
		contentPane.add(lblTelefone);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SENHA:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(579, 319, 72, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("USER:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(241, 319, 72, 20);
		contentPane.add(lblNewLabel_1_1_2);
		
		JButton btnCadastrarProf = new JButton("Cadastrar");
		btnCadastrarProf.setBackground(new Color(255, 255, 255));
		btnCadastrarProf.setFont(new Font("Arial", Font.BOLD, 16));
		btnCadastrarProf.setBounds(417, 481, 139, 32);
		contentPane.add(btnCadastrarProf);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(0, 69, 150));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
		btnVoltar.setBounds(809, 617, 139, 32);
		contentPane.add(btnVoltar);
		
		textField = new JTextField();
		textField.setBounds(323, 115, 578, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(323, 161, 578, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(323, 205, 578, 25);
		contentPane.add(textField_2);
		
		JLabel lblCref = new JLabel("CREF:");
		lblCref.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCref.setForeground(Color.WHITE);
		lblCref.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCref.setBounds(232, 251, 79, 20);
		contentPane.add(lblCref);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(323, 250, 578, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(323, 319, 266, 25);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(658, 321, 243, 25);
		contentPane.add(textField_5);
	}
}
