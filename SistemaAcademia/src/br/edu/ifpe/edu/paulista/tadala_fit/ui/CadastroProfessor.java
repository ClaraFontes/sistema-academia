package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifpe.paulista.tadala_fit.core.CreateController;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;
import br.edu.ifpe.paulista.tadala_fit.data.MySQLRepository;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProfessor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField txtnome;
	protected JTextField txttelefone;
	protected JTextField txtemail;
	protected JTextField txtcref;
	protected JTextField txtuser;
	protected JPasswordField txtpassword;
	private JButton btncarregarfoto;
	private JButton btntirarfoto;
	private JLabel lblfoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroProfessor dialog = new CadastroProfessor();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroProfessor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja interromper cadastro?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				}else {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		setTitle("Tadalafit - Versão 1.0");
		setBounds(100, 100, 1024, 768);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 79, 157));
		panel.setBounds(0, 0, 1008, 729);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 69, 130));
		panel_1.setBounds(10, 361, 988, 10);
		panel.add(panel_1);
		
		lblfoto = new JLabel("");
		lblfoto.setIcon(new ImageIcon(CadastroProfessor.class.getResource("/assets_loginFrame/user.png")));
		lblfoto.setBounds(73, 74, 161, 179);
		panel.add(lblfoto);
		
		JLabel lblnome = new JLabel("NOME:");
		lblnome.setForeground(Color.WHITE);
		lblnome.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblnome.setBounds(278, 118, 69, 19);
		panel.add(lblnome);
		
		JLabel lbltelefone = new JLabel("TELEFONE:");
		lbltelefone.setForeground(Color.WHITE);
		lbltelefone.setFont(new Font("Arial Black", Font.BOLD, 13));
		lbltelefone.setBounds(244, 166, 84, 14);
		panel.add(lbltelefone);
		
		JLabel lblemail = new JLabel("EMAIL: ");
		lblemail.setForeground(Color.WHITE);
		lblemail.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblemail.setBounds(278, 210, 69, 19);
		panel.add(lblemail);
		
		JLabel lblcref = new JLabel("CREF:");
		lblcref.setForeground(Color.WHITE);
		lblcref.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblcref.setBounds(282, 258, 46, 14);
		panel.add(lblcref);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Arial", Font.BOLD, 15));
		txtnome.setBorder(null);
		txtnome.setColumns(10);
		txtnome.setBounds(338, 119, 460, 20);
		panel.add(txtnome);
		
		txttelefone = new JTextField();
		txttelefone.setFont(new Font("Arial", Font.BOLD, 15));
		txttelefone.setBorder(null);
		txttelefone.setColumns(10);
		txttelefone.setBounds(338, 165, 460, 20);
		panel.add(txttelefone);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtemail.setBorder(null);
		txtemail.setColumns(10);
		txtemail.setBounds(338, 211, 460, 20);
		panel.add(txtemail);
		
		txtcref = new JTextField();
		txtcref.setFont(new Font("Arial", Font.BOLD, 15));
		txtcref.setBorder(null);
		txtcref.setColumns(10);
		txtcref.setBounds(338, 257, 460, 20);
		panel.add(txtcref);
		
		JLabel lbluser = new JLabel("USER:");
		lbluser.setForeground(Color.WHITE);
		lbluser.setFont(new Font("Arial Black", Font.BOLD, 13));
		lbluser.setBounds(278, 417, 57, 14);
		panel.add(lbluser);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Arial Black", Font.BOLD, 16));
		txtuser.setBorder(null);
		txtuser.setColumns(10);
		txtuser.setBounds(326, 416, 182, 20);
		panel.add(txtuser);
		
		JLabel lblpassword = new JLabel("SENHA:");
		lblpassword.setForeground(Color.WHITE);
		lblpassword.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblpassword.setBounds(548, 419, 57, 14);
		panel.add(lblpassword);
		
		JButton btnfinalizarmatricula = new JButton("Finalizar Matrícula");
		btnfinalizarmatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String user = txtuser.getText();
					String password = new String(txtpassword.getPassword());
					String cref = txtcref.getText();
					String nome = txtnome.getText();
					String telefone = txttelefone.getText();
					String email = txtemail.getText();
					File image = new File ("C:/Users/clara/git/sistema-academia/SistemaAcademia/imagem.png");
					FileInputStream inputstream = new FileInputStream(image);
					byte[] imagepronta = new byte[(int) image.length()];
					inputstream.read(imagepronta);
					inputstream.close();
					java.sql.Blob imagemBlob = new javax.sql.rowset.serial.SerialBlob(imagepronta);
					Professor professorCadastrado = CreateController.createProfessor(user, password, nome, telefone, email, cref,imagemBlob);
					if (professorCadastrado == null) {
						JOptionPane.showMessageDialog(null, "Usuário já existe no banco");
					} else {
						JOptionPane.showMessageDialog(null, "Professor " + professorCadastrado.getNome() +" cadastrado com sucesso!");
						if (image.delete()) {
						    System.out.println("Arquivo excluído com sucesso.");
						} else {
						    System.out.println("Não foi possível excluir o arquivo.");
						}
					}
					
				} catch (RuntimeException e2) {
					JOptionPane.showMessageDialog(null,"Preencha todos os campos");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente.");
				}
				
			}
		});
		btnfinalizarmatricula.setForeground(Color.BLACK);
		btnfinalizarmatricula.setFont(new Font("Arial", Font.BOLD, 16));
		btnfinalizarmatricula.setBackground(Color.WHITE);
		btnfinalizarmatricula.setBounds(421, 538, 222, 35);
		panel.add(btnfinalizarmatricula);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(CadastroProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lbllogo.setBounds(52, 562, 192, 167);
		panel.add(lbllogo);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2023 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(364, 678, 324, 40);
		panel.add(lblNewLabel_2);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtpassword.setBorder(null);
		txtpassword.setBounds(613, 417, 185, 19);
		panel.add(txtpassword);
		
		btntirarfoto = new JButton("Tirar Foto");
		btntirarfoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WebCam();
				btncarregarfoto.setEnabled(true);
				btncarregarfoto.setVisible(true);
			}
		});
		btntirarfoto.setBorder(null);
		btntirarfoto.setBounds(103, 266, 93, 20);
		panel.add(btntirarfoto);
		
		btncarregarfoto = new JButton("Carregar Foto");
		btncarregarfoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedImage fotoperfil = ImageIO.read(new File("C:/Users/Matheus/Desktop/sistema-academia/SistemaAcademia/imagem.png"));
					BufferedImage resizedImage = new BufferedImage(150, 150, fotoperfil.getType());
					Graphics2D g = resizedImage.createGraphics();
					g.drawImage(fotoperfil, 0, 0, 150, 150, null);
					g.dispose();
					lblfoto.setIcon(new ImageIcon(resizedImage));
					btncarregarfoto.setEnabled(false);
					btncarregarfoto.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btncarregarfoto.setBorder(null);
		btncarregarfoto.setEnabled(false);
		btncarregarfoto.setVisible(false);
		btncarregarfoto.setBounds(103, 297, 93, 20);
		panel.add(btncarregarfoto);
	}
}
