package br.edu.ifpe.edu.paulista.tadala_fit.ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.edu.ifpe.paulista.tadala_fit.core.Aluno;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import java.io.File;       

public class FrameCadastro {

	protected JFrame framecadastro;
	private JTextField txtnome;
	private JTextField txtrg;
	private JTextField txtcpf;
	private JTextField txtdatanascimento;
	private JTextField txtemail;
	private JTextField txtendereço;
	private JTextField txtcep;
	private JTextField txtbairro;
	private JTextField txtcidade;
	private JTextField txtuf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCadastro window = new FrameCadastro();
					window.framecadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameCadastro() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framecadastro = new JFrame();
		framecadastro.setTitle("TadalaFit - Versão - 1.0");
		framecadastro.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja interromper o cadastro?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					framecadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}else {
					framecadastro.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
		
		framecadastro.setResizable(false);
		framecadastro.getContentPane().setBackground(new Color(0, 128, 128));
		framecadastro.getContentPane().setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(10, 11, 988, 659);
		framecadastro.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtnome = new JTextField();
		txtnome.setBounds(299, 70, 589, 25);
		panel.add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(222, 71, 72, 20);
		panel.add(lblNewLabel);
		
		txtrg = new JTextField();
		txtrg.setColumns(10);
		txtrg.setBounds(299, 117, 148, 25);
		panel.add(txtrg);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setForeground(Color.WHITE);
		lblRg.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblRg.setBounds(222, 116, 72, 24);
		panel.add(lblRg);
		
		txtcpf = new JTextField();
		txtcpf.setColumns(10);
		txtcpf.setBounds(501, 117, 165, 25);
		panel.add(txtcpf);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCpf.setBounds(424, 116, 72, 24);
		panel.add(lblCpf);
		
		txtdatanascimento = new JTextField();
		txtdatanascimento.setColumns(10);
		txtdatanascimento.setBounds(299, 164, 148, 25);
		panel.add(txtdatanascimento);
		
		JLabel lblDataNasc = new JLabel("DATA NASC:");
		lblDataNasc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblDataNasc.setBounds(193, 163, 101, 24);
		panel.add(lblDataNasc);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(501, 164, 270, 25);
		panel.add(txtemail);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblEmail.setBounds(424, 162, 72, 26);
		panel.add(lblEmail);
		
		txtendereço = new JTextField();
		txtendereço.setColumns(10);
		txtendereço.setBounds(299, 211, 589, 25);
		panel.add(txtendereço);
		
		JLabel lblEndereo = new JLabel("ENDEREÇO:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblEndereo.setBounds(193, 213, 101, 24);
		panel.add(lblEndereo);
		
		txtcep = new JTextField();
		txtcep.setColumns(10);
		txtcep.setBounds(222, 261, 148, 25);
		panel.add(txtcep);
		
		txtbairro = new JTextField();
		txtbairro.setColumns(10);
		txtbairro.setBounds(438, 261, 148, 25);
		panel.add(txtbairro);
		
		txtcidade = new JTextField();
		txtcidade.setColumns(10);
		txtcidade.setBounds(648, 261, 148, 25);
		panel.add(txtcidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCep.setBounds(146, 260, 72, 24);
		panel.add(lblCep);
		
		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblBairro.setBounds(361, 260, 72, 24);
		panel.add(lblBairro);
		
		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCidade.setBounds(571, 260, 72, 24);
		panel.add(lblCidade);
		
		txtuf = new JTextField();
		txtuf.setColumns(10);
		txtuf.setBounds(828, 261, 60, 25);
		panel.add(txtuf);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setForeground(Color.WHITE);
		lblUf.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblUf.setBounds(750, 260, 72, 24);
		panel.add(lblUf);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(342, 608, 324, 40);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 111, 111));
		panel_2.setBounds(22, 305, 956, 10);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(22, 507, 200, 141);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(FrameCadastro.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 22, 173, 178);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 11, 150, 150);
		lblNewLabel_3.setIcon(new ImageIcon(FrameCadastro.class.getResource("/assets_loginFrame/user.png")));
		panel_1.add(lblNewLabel_3);
		framecadastro.setBackground(new Color(0, 128, 128));
		framecadastro.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCadastro.class.getResource("/assets_loginFrame/Logotipo academia personal trainner (1).png")));
		framecadastro.setBounds(100, 100, 1024, 720);
		
	}
}
