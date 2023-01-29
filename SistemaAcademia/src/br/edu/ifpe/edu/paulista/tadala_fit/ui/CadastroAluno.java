package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.SwingConstants;

import com.mysql.cj.jdbc.Blob;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.CreateController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CadastroAluno extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField txtnome;
	private JTextField txttelefone;
	private JTextField txtdata;
	private JTextField txtpeso;
	private JTextField txtcpf;
	private JTextField txtemail;
	private JTextField txtaltura;
	private JTextField txtbf;
	private JTextField txtcomorbidade;
	private JTextField txtuser;
	private JPasswordField txtpassword;
	private JTextField txtsexo;
	private static JDialog dialog;
	private JLabel lblfoto;
	private JButton btnCarregarFoto;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						dialog = new CadastroAluno();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						dialog.setVisible(true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public CadastroAluno() {
		getContentPane().setBackground(new Color(0, 65, 130));
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		setTitle("Tadalafit - Versão 1.0");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja voltar pro menu?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				}else {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setBounds(100, 100, 1024, 768);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 79, 157));
		panel.setBounds(10, 11, 988, 707);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblfoto = new JLabel("");
		lblfoto.setIcon(new ImageIcon(CadastroAluno.class.getResource("/assets_loginFrame/user.png")));
		lblfoto.setBounds(55, 101, 150, 150);
		panel.add(lblfoto);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setBounds(251, 86, 72, 20);
		panel.add(lblNewLabel);
		
		JLabel lblRg = new JLabel("TELEFONE:");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setForeground(Color.WHITE);
		lblRg.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblRg.setBounds(239, 132, 87, 24);
		panel.add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCpf.setBounds(556, 132, 72, 24);
		panel.add(lblCpf);
		
		JLabel lblDataNasc = new JLabel("DATA NASC:");
		lblDataNasc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDataNasc.setBounds(222, 183, 101, 24);
		panel.add(lblDataNasc);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmail.setBounds(556, 182, 72, 26);
		panel.add(lblEmail);
		
		JLabel lblCep = new JLabel("PESO:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCep.setBounds(251, 227, 72, 24);
		panel.add(lblCep);
		
		JLabel lblBairro = new JLabel("ALTURA:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblBairro.setBounds(556, 227, 72, 24);
		panel.add(lblBairro);
		
		JLabel lblUf = new JLabel("BF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setForeground(Color.WHITE);
		lblUf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblUf.setBounds(726, 227, 72, 24);
		panel.add(lblUf);
		
		JLabel lblCidade_1 = new JLabel("COMORBIDADE:");
		lblCidade_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade_1.setForeground(Color.WHITE);
		lblCidade_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCidade_1.setBounds(191, 278, 132, 24);
		panel.add(lblCidade_1);
		
		txtnome = new JTextField();
		txtnome.setBorder(null);
		txtnome.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtnome.setColumns(10);
		txtnome.setBounds(333, 83, 514, 25);
		panel.add(txtnome);
		
		txttelefone = new JTextField();
		txttelefone.setFont(new Font("Arial Black", Font.BOLD, 13));
		txttelefone.setColumns(10);
		txttelefone.setBorder(null);
		txttelefone.setBounds(333, 135, 209, 25);
		panel.add(txttelefone);
		
		txtdata = new JTextField();
		txtdata.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtdata.setColumns(10);
		txtdata.setBorder(null);
		txtdata.setBounds(333, 182, 209, 25);
		panel.add(txtdata);
		
		txtpeso = new JTextField();
		txtpeso.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtpeso.setColumns(10);
		txtpeso.setBorder(null);
		txtpeso.setBounds(333, 226, 209, 25);
		panel.add(txtpeso);
		
		txtcpf = new JTextField();
		txtcpf.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtcpf.setColumns(10);
		txtcpf.setBorder(null);
		txtcpf.setBounds(636, 132, 211, 25);
		panel.add(txtcpf);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtemail.setColumns(10);
		txtemail.setBorder(null);
		txtemail.setBounds(636, 182, 211, 25);
		panel.add(txtemail);
		
		txtaltura = new JTextField();
		txtaltura.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtaltura.setColumns(10);
		txtaltura.setBorder(null);
		txtaltura.setBounds(636, 226, 121, 25);
		panel.add(txtaltura);
		
		txtbf = new JTextField();
		txtbf.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtbf.setColumns(10);
		txtbf.setBorder(null);
		txtbf.setBounds(810, 226, 37, 25);
		panel.add(txtbf);
		
		txtcomorbidade = new JTextField();
		txtcomorbidade.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtcomorbidade.setColumns(10);
		txtcomorbidade.setBorder(null);
		txtcomorbidade.setBounds(333, 277, 209, 25);
		panel.add(txtcomorbidade);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 65, 130));
		panel_2.setBounds(22, 348, 956, 10);
		panel.add(panel_2);
		
		JLabel lblUser = new JLabel("USUÁRIO: ");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblUser.setBounds(194, 399, 132, 24);
		panel.add(lblUser);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblSenha.setBounds(496, 399, 132, 24);
		panel.add(lblSenha);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtuser.setColumns(10);
		txtuser.setBorder(null);
		txtuser.setBounds(333, 399, 209, 25);
		panel.add(txtuser);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CadastroAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(22, 566, 200, 130);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(370, 667, 324, 40);
		panel.add(lblNewLabel_2);
		
		JButton btnfinalizar = new JButton("Finalizar Matrícula");
		btnfinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String telefone = txttelefone.getText();
					String data = txtdata.getText();
					String nome = txtnome.getText();
					Double peso = Double.parseDouble(txtpeso.getText());
					String cpf = txtcpf.getText();
					String email = txtemail.getText();
					Double altura = Double.parseDouble(txtaltura.getText());
					Double bf = Double.parseDouble(txtbf.getText());
					String sexo = txtsexo.getText();
					String comorbidade = txtcomorbidade.getText();
					String user = txtuser.getText();
					String password = new String(txtpassword.getPassword());
					Blob resizedImage;
					Aluno alunoCadastrado = CreateController.createAluno(user, password, nome, sexo, cpf, telefone, email, data, altura, peso, bf, comorbidade);
					if (alunoCadastrado == null) {
						JOptionPane.showMessageDialog(null, "Usuário já existe no banco");
					} else {
						JOptionPane.showMessageDialog(null, "Aluno(a) " + alunoCadastrado.getNome() +" cadastrado com sucesso!");
						dispose();
					}
				} catch (NumberFormatException e5) {
					JOptionPane.showMessageDialog(null, "Preencha os Campos ALTURA, PESO E BF corretamente.");
					
					
				} catch (RuntimeException e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
			
				} catch (SQLException e1) {
					e1.printStackTrace();
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
	
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente.");
				}
		   }
		});
		btnfinalizar.setFocusPainted(false);
		btnfinalizar.setFont(new Font("Arial", Font.BOLD, 16));
		btnfinalizar.setBackground(Color.WHITE);
		btnfinalizar.setBounds(599, 579, 218, 32);
		panel.add(btnfinalizar);
		
		JButton btngeraboleto = new JButton("Gerar Boleto");
		btngeraboleto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = txtnome.getText();
				String boleto = ("Boleto de Cobrança Mensalidade no valor de R% 50,00  para o Aluno:"+ nome);
				new PDF(boleto, nome);
				try {
					Desktop.getDesktop().open(new File("C:/Users/Matheus/Desktop/sistema-academia/SistemaAcademia/"+nome+".pdf"));
				} catch (IOException e1) {
					 //TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btngeraboleto.setFocusPainted(false);
		btngeraboleto.setFont(new Font("Arial", Font.BOLD, 16));
		btngeraboleto.setBackground(Color.WHITE);
		btngeraboleto.setBounds(324, 579, 218, 32);
		panel.add(btngeraboleto);
		
		JCheckBox pago = new JCheckBox("Pagamento Já Efetuado");
		pago.setFocusPainted(false);
		pago.setFont(new Font("Arial", Font.BOLD, 13));
		pago.setBounds(456, 528, 218, 32);
		panel.add(pago);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Arial", Font.BOLD, 13));
		txtpassword.setBorder(null);
		txtpassword.setBounds(637, 400, 210, 23);
		panel.add(txtpassword);
		
		txtsexo = new JTextField();
		txtsexo.setBounds(636, 281, 121, 20);
		panel.add(txtsexo);
		txtsexo.setColumns(10);
		
		JLabel lblsexo = new JLabel("SEXO:");
		lblsexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblsexo.setForeground(Color.WHITE);
		lblsexo.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblsexo.setBounds(556, 278, 72, 24);
		panel.add(lblsexo);
		
		JButton btnfoto = new JButton("Tirar Foto");
		btnfoto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(txtnome.getText().isEmpty() ||txtnome.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Preencha o nome e CPF antes de inserir a foto");
				}else if (txtcpf.getText().isBlank() || txtcpf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o nome e CPF antes de inserir a foto");
				}else {
					String nome = txtnome.getText();
					String cpf = txtcpf.getText();
					new WebCam(nome,cpf);
					btnCarregarFoto.setEnabled(true);
					btnCarregarFoto.setVisible(true);
				}
			}
		});
		btnfoto.setBorder(null);
		btnfoto.setBounds(88, 261, 93, 20);
		panel.add(btnfoto);
		
		btnCarregarFoto = new JButton("Carregar Foto");
		btnCarregarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = txtnome.getText();
					String cpf = txtcpf.getText();
					BufferedImage fotoperfil = ImageIO.read(new File("C:/Users/Matheus/Desktop/sistema-academia/SistemaAcademia/imagem"+nome+cpf+".png"));
					BufferedImage resizedImage = new BufferedImage(150, 150, fotoperfil.getType());
					Graphics2D g = resizedImage.createGraphics();
					g.drawImage(fotoperfil, 0, 0, 150, 150, null);
					g.dispose();
					lblfoto.setIcon(new ImageIcon(resizedImage));
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCarregarFoto.setEnabled(false);
		btnCarregarFoto.setVisible(false);
		btnCarregarFoto.setBorder(null);
		btnCarregarFoto.setBounds(88, 292, 93, 20);
		panel.add(btnCarregarFoto);
		}
}
