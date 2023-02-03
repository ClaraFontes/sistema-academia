package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import br.edu.ifpe.paulista.tadala_fit.core.CreateController;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class CadastroProfessor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField txtuser;
	private JFormattedTextField txtnome;
	private JFormattedTextField txttelefone;
	private JFormattedTextField txtemail;
	private JFormattedTextField txtcref;
	private JPasswordField txtpassword;
	private JButton btntirarfoto;
	private JLabel lblfoto;
	private Blob imagemBlob = null;

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
	 * @throws ParseException 
	 */
	public CadastroProfessor() throws ParseException {
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
		lblnome.setBounds(278, 118, 50, 19);
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
		
		JLabel lbluser = new JLabel("USER:");
		lbluser.setForeground(Color.WHITE);
		lbluser.setFont(new Font("Arial Black", Font.BOLD, 13));
		lbluser.setBounds(278, 417, 57, 14);
		panel.add(lbluser);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Arial Black", Font.BOLD, 16));
		txtuser.setBorder(null);
		txtuser.setColumns(10);
		txtuser.setBounds(327, 416, 182, 20);
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
					Professor professorCadastrado = CreateController.createProfessor(user, password, nome, telefone, email, cref,imagemBlob);
					if (professorCadastrado == null) {
						JOptionPane.showMessageDialog(null, "Usuário já existe no banco");
					} else {
						JOptionPane.showMessageDialog(null, "Professor(a) cadastrado com sucesso!");
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
				WebCam webcam = new WebCam();
				if(webcam.getWebcam() != null) {
					webcam.setModal(true);
					webcam.setVisible(true);
					imagemBlob = WebCam.imgemBlob();
					lblfoto.setIcon(new ImageIcon(WebCam.carregarFoto()));
				}
			}
		});
		btntirarfoto.setBorder(null);
		btntirarfoto.setBounds(103, 266, 93, 20);
		panel.add(btntirarfoto);
		
		
		MaskFormatter mascaraNome = new MaskFormatter("********************************************************");
		mascaraNome.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopsrtuvwxyz ");
		txtnome = new JFormattedTextField(mascaraNome);
		txtnome.setBounds(338, 119, 434, 20);
		panel.add(txtnome);
		
		MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");
		mascaraTelefone.setPlaceholderCharacter('_');
		txttelefone = new JFormattedTextField(mascaraTelefone);
		txttelefone.setBounds(338, 165, 434, 20);
		panel.add(txttelefone);
		
		MaskFormatter mascaraEmail = new MaskFormatter("*************************************************************");
		txtemail = new JFormattedTextField(mascaraEmail);
		txtemail.setBounds(338, 211, 434, 20);
		panel.add(txtemail);
		
		MaskFormatter mascaraCref = new MaskFormatter("######-U");
		mascaraCref.setPlaceholderCharacter('_');
		txtcref = new JFormattedTextField(mascaraCref);
		txtcref.setBounds(338, 257, 434, 20);
		panel.add(txtcref);
	}
}
