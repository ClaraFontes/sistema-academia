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
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.paulista.tadala_fit.core.Aluno;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;       

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
		framecadastro.getContentPane().setBackground(new Color(0, 65, 130));
		framecadastro.getContentPane().setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 79, 157));
		panel.setBounds(10, 11, 988, 708);
		framecadastro.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Arial", Font.PLAIN, 13));
		txtnome.setBounds(314, 104, 589, 25);
		panel.add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(232, 105, 72, 20);
		panel.add(lblNewLabel);
		
		txtrg = new JTextField();
		txtrg.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrg.setColumns(10);
		txtrg.setBounds(314, 151, 270, 25);
		panel.add(txtrg);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setForeground(Color.WHITE);
		lblRg.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblRg.setBounds(232, 150, 72, 24);
		panel.add(lblRg);
		
		txtcpf = new JTextField();
		txtcpf.setFont(new Font("Arial", Font.PLAIN, 13));
		txtcpf.setColumns(10);
		txtcpf.setBounds(665, 151, 238, 25);
		panel.add(txtcpf);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCpf.setBounds(583, 150, 72, 24);
		panel.add(lblCpf);
		
		txtdatanascimento = new JTextField();
		txtdatanascimento.setFont(new Font("Arial", Font.PLAIN, 13));
		txtdatanascimento.setColumns(10);
		txtdatanascimento.setBounds(355, 198, 148, 25);
		panel.add(txtdatanascimento);
		
		JLabel lblDataNasc = new JLabel("DATA NASC:");
		lblDataNasc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDataNasc.setBounds(244, 197, 101, 24);
		panel.add(lblDataNasc);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Arial", Font.PLAIN, 13));
		txtemail.setColumns(10);
		txtemail.setBounds(583, 198, 320, 25);
		panel.add(txtemail);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmail.setBounds(501, 196, 72, 26);
		panel.add(lblEmail);
		
		txtendereço = new JTextField();
		txtendereço.setFont(new Font("Arial", Font.PLAIN, 13));
		txtendereço.setColumns(10);
		txtendereço.setBounds(650, 295, 253, 25);
		panel.add(txtendereço);
		
		JLabel lblEndereo = new JLabel("ENDEREÇO:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblEndereo.setBounds(539, 294, 101, 24);
		panel.add(lblEndereo);
		
		txtcep = new JTextField();
		txtcep.setFont(new Font("Arial", Font.PLAIN, 13));
		txtcep.setColumns(10);
		txtcep.setBounds(314, 245, 148, 25);
		panel.add(txtcep);
		
		txtbairro = new JTextField();
		txtbairro.setFont(new Font("Arial", Font.PLAIN, 13));
		txtbairro.setColumns(10);
		txtbairro.setBounds(554, 245, 238, 25);
		panel.add(txtbairro);
		
		txtcidade = new JTextField();
		txtcidade.setFont(new Font("Arial", Font.PLAIN, 13));
		txtcidade.setColumns(10);
		txtcidade.setBounds(326, 295, 218, 25);
		panel.add(txtcidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCep.setBounds(232, 244, 72, 24);
		panel.add(lblCep);
		
		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblBairro.setBounds(472, 246, 72, 24);
		panel.add(lblBairro);
		
		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCidade.setBounds(244, 294, 72, 24);
		panel.add(lblCidade);
		
		txtuf = new JTextField();
		txtuf.setColumns(10);
		txtuf.setBounds(843, 245, 60, 25);
		panel.add(txtuf);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setForeground(Color.WHITE);
		lblUf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblUf.setBounds(761, 244, 72, 24);
		panel.add(lblUf);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(348, 657, 324, 40);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 65, 130));
		panel_2.setBounds(22, 438, 956, 10);
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
		
		JButton btnNewButton = new JButton("Finalizar Matrícula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameConsulta fc = new FrameConsulta();
				fc.frameconsulta.setVisible(true);
				framecadastro.dispose();
				DefaultTableModel consulta = (DefaultTableModel) fc.table.getModel();		
				
				//só adiciona se o campo não estiver vazio
				String nome = txtnome.getText().trim();
				String email = txtemail.getText().trim();
				String status = "vazio por enquanto";
				
				consulta.addRow(new String[] {nome, email, status}); // adiciona campos preenchidos na table "consulta", mas não deixa salvo.
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(407, 479, 218, 32);
		panel.add(btnNewButton);
		
		JButton btnGerarBoleto = new JButton("Finalizar e Criar Treinos");
		btnGerarBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGerarBoleto.setFont(new Font("Arial", Font.BOLD, 16));
		btnGerarBoleto.setBackground(Color.WHITE);
		btnGerarBoleto.setBounds(407, 522, 218, 32);
		panel.add(btnGerarBoleto);
		
		JCheckBox Pago = new JCheckBox("Pagamento Já Efetuado");
		Pago.setFont(new Font("Arial", Font.BOLD, 13));
		Pago.setBounds(602, 357, 301, 33);
		panel.add(Pago);
		
		
		JButton Geraboleto = new JButton("Gerar Boleto");
		Geraboleto.setFont(new Font("Arial", Font.BOLD, 16));
		Geraboleto.setBackground(Color.WHITE);
		Geraboleto.setBounds(254, 355, 301, 32);
		panel.add(Geraboleto);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameHome fh = new FrameHome();
				fh.framehome.setVisible(true);
				framecadastro.dispose();
			}
		});
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
		btnVoltar.setBackground(new Color(0, 69, 130));
		btnVoltar.setBounds(809, 617, 139, 32);
		panel.add(btnVoltar);
		framecadastro.setBackground(new Color(0, 128, 128));
		framecadastro.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCadastro.class.getResource("/assets_loginFrame/Logotipo academia personal trainner (1).png")));
		framecadastro.setBounds(100, 100, 1025, 769);
		
	}
}
