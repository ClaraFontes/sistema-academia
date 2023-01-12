package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameCadastroProfessor {

	protected JFrame framecadastroprofessor;
	private JTextField txtnome;
	private JTextField txttelefone;
	private JTextField txtemail;
	private JTextField txtcref;
	private JTextField txtuser;
	private JTextField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCadastroProfessor window = new FrameCadastroProfessor();
					window.framecadastroprofessor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameCadastroProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framecadastroprofessor = new JFrame();
		framecadastroprofessor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja fechar a aplicação?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					framecadastroprofessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					framecadastroprofessor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		framecadastroprofessor.getContentPane().setBackground(new Color(0, 79, 157));
		framecadastroprofessor.setTitle("Tadalafit - Versão 1.0");
		framecadastroprofessor.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCadastroProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		framecadastroprofessor.setResizable(false);
		framecadastroprofessor.setBounds(100, 100, 1024, 768);
		framecadastroprofessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framecadastroprofessor.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameCadastroProfessor.class.getResource("/assets_loginFrame/user.png")));
		lblNewLabel.setBounds(55, 73, 161, 207);
		framecadastroprofessor.getContentPane().add(lblNewLabel);
		
		JLabel lblnome = new JLabel("NOME:");
		lblnome.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblnome.setForeground(new Color(255, 255, 255));
		lblnome.setBounds(254, 105, 57, 14);
		framecadastroprofessor.getContentPane().add(lblnome);
		
		JLabel lbltelefone = new JLabel("TELEFONE:");
		lbltelefone.setForeground(Color.WHITE);
		lbltelefone.setFont(new Font("Arial Black", Font.BOLD, 13));
		lbltelefone.setBounds(226, 153, 96, 14);
		framecadastroprofessor.getContentPane().add(lbltelefone);
		
		JLabel lblemail = new JLabel("EMAIL: ");
		lblemail.setForeground(Color.WHITE);
		lblemail.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblemail.setBounds(254, 196, 57, 14);
		framecadastroprofessor.getContentPane().add(lblemail);
		
		JLabel lblcref = new JLabel("CREF:");
		lblcref.setForeground(Color.WHITE);
		lblcref.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblcref.setBounds(264, 241, 46, 14);
		framecadastroprofessor.getContentPane().add(lblcref);
		
		txtnome = new JTextField();
		txtnome.setBounds(321, 104, 460, 20);
		framecadastroprofessor.getContentPane().add(txtnome);
		txtnome.setColumns(10);
		
		txttelefone = new JTextField();
		txttelefone.setColumns(10);
		txttelefone.setBounds(321, 152, 460, 20);
		framecadastroprofessor.getContentPane().add(txttelefone);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(321, 195, 460, 20);
		framecadastroprofessor.getContentPane().add(txtemail);
		
		txtcref = new JTextField();
		txtcref.setColumns(10);
		txtcref.setBounds(320, 240, 460, 20);
		framecadastroprofessor.getContentPane().add(txtcref);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(FrameCadastroProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lbllogo.setBounds(67, 535, 222, 167);
		framecadastroprofessor.getContentPane().add(lbllogo);
		
		JLabel lblcopyright = new JLabel("\"Copyright (c) 2022 Tadalafit  All Rights Reserved\"");
		lblcopyright.setForeground(new Color(255, 255, 255));
		lblcopyright.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblcopyright.setBackground(new Color(255, 255, 255));
		lblcopyright.setBounds(345, 665, 486, 14);
		framecadastroprofessor.getContentPane().add(lblcopyright);
		
		JPanel panel = new JPanel();
		panel.setBounds(55, 307, 65, -2);
		framecadastroprofessor.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 30, 130));
		panel_1.setBounds(10, 322, 988, 10);
		framecadastroprofessor.getContentPane().add(panel_1);
		
		JLabel lbluser = new JLabel("USER:");
		lbluser.setForeground(Color.WHITE);
		lbluser.setFont(new Font("Arial Black", Font.BOLD, 13));
		lbluser.setBounds(264, 388, 57, 14);
		framecadastroprofessor.getContentPane().add(lbluser);
		
		JLabel lblpassword = new JLabel("SENHA:");
		lblpassword.setForeground(Color.WHITE);
		lblpassword.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblpassword.setBounds(544, 388, 57, 14);
		framecadastroprofessor.getContentPane().add(lblpassword);
		
		txtuser = new JTextField();
		txtuser.setColumns(10);
		txtuser.setBounds(331, 387, 182, 20);
		framecadastroprofessor.getContentPane().add(txtuser);
		
		txtpassword = new JTextField();
		txtpassword.setColumns(10);
		txtpassword.setBounds(611, 387, 182, 20);
		framecadastroprofessor.getContentPane().add(txtpassword);
		
		JButton btnfinalizarmatricula = new JButton("Finalizar Matrícula");
		btnfinalizarmatricula.setForeground(new Color(0, 0, 0));
		btnfinalizarmatricula.setBackground(new Color(255, 255, 255));
		btnfinalizarmatricula.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnfinalizarmatricula.setBounds(408, 517, 222, 35);
		framecadastroprofessor.getContentPane().add(btnfinalizarmatricula);
		
		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameHome fh = new FrameHome();
				fh.framehome.setVisible(true);
				framecadastroprofessor.dispose();
			}
		});
		btnvoltar.setForeground(Color.WHITE);
		btnvoltar.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnvoltar.setBackground(new Color(0, 30, 130));
		btnvoltar.setBounds(712, 593, 166, 35);
		framecadastroprofessor.getContentPane().add(btnvoltar);
	}
}
