package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroProfessor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField txtmatricula;
	protected JTextField txtnome;
	protected JTextField txttelefone;
	protected JTextField txtemail;
	protected JTextField txtcref;
	protected JTextField txtuser;
	protected JPasswordField txtpassword;
	protected String matricula;
	protected String nome;
	protected String telefone;
	protected String email;
	protected int cref;

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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroProfessor.class.getResource("/assets_loginFrame/user.png")));
		lblNewLabel.setBounds(72, 79, 161, 207);
		panel.add(lblNewLabel);
		
		JLabel lblnome = new JLabel("NOME:");
		lblnome.setForeground(Color.WHITE);
		lblnome.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblnome.setBounds(278, 118, 69, 19);
		panel.add(lblnome);
		
		JLabel lblMatrcula = new JLabel("MATRÍCULA:");
		lblMatrcula.setForeground(Color.WHITE);
		lblMatrcula.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblMatrcula.setBounds(232, 79, 96, 14);
		panel.add(lblMatrcula);
		
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
		
		txtmatricula = new JTextField();
		txtmatricula.setColumns(10);
		txtmatricula.setBounds(338, 79, 460, 20);
		panel.add(txtmatricula);
		
		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(338, 119, 460, 20);
		panel.add(txtnome);
		
		txttelefone = new JTextField();
		txttelefone.setColumns(10);
		txttelefone.setBounds(338, 165, 460, 20);
		panel.add(txttelefone);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(338, 211, 460, 20);
		panel.add(txtemail);
		
		txtcref = new JTextField();
		txtcref.setColumns(10);
		txtcref.setBounds(338, 257, 460, 20);
		panel.add(txtcref);
		
		JLabel lbluser = new JLabel("USER:");
		lbluser.setForeground(Color.WHITE);
		lbluser.setFont(new Font("Arial Black", Font.BOLD, 13));
		lbluser.setBounds(278, 417, 57, 14);
		panel.add(lbluser);
		
		txtuser = new JTextField();
		txtuser.setColumns(10);
		txtuser.setBounds(326, 416, 182, 20);
		panel.add(txtuser);
		
		JLabel lblpassword = new JLabel("SENHA:");
		lblpassword.setForeground(Color.WHITE);
		lblpassword.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblpassword.setBounds(548, 419, 57, 14);
		panel.add(lblpassword);
		
		JButton btnfinalizarmatricula = new JButton("Finalizar Matrícula");
		btnfinalizarmatricula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String matricula = txtmatricula.getText();
				String nome = txtnome.getText();
				String telefone = txttelefone.getText();
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
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(364, 678, 324, 40);
		panel.add(lblNewLabel_2);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(613, 417, 185, 19);
		panel.add(txtpassword);
	}
}
