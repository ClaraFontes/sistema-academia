package br.edu.ifpe.edu.paulista.tadala_fit.ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import br.edu.ifpe.paulista.tadala_fit.core.Administrador;

import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Font;

public class FrameHome {

	protected JFrame framehome;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHome window = new FrameHome();
					window.framehome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framehome = new JFrame();
		framehome.setResizable(false);
		framehome.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja fechar a aplicação?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					framehome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					framehome.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		framehome.setBackground(new Color(0, 128, 128));
		framehome.getContentPane().setBackground(new Color(0, 79, 157));
		framehome.setTitle("TadalaFit - Versão - 1.0");
		framehome.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameHome.class.getResource("/assets_loginFrame/Logotipo academia personal trainner (1).png")));
		framehome.setBounds(100, 100, 1024, 769);
		framehome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framehome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 65, 130));
		panel.setBounds(44, 11, 258, 708);
		framehome.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameHome.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel.setBounds(30, 53, 200, 159);
		panel.add(lblNewLabel);
		
		JButton btnCadastro = new JButton("Matricular Aluno");
		btnCadastro.setFont(new Font("Arial", Font.BOLD, 13));
		btnCadastro.setBackground(new Color(255, 255, 255));
		btnCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameCadastroAluno fc = new FrameCadastroAluno();
				fc.framecadastro.setVisible(true);
				framehome.dispose();
	
			}
		});
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastro.setBounds(43, 241, 176, 33);
		panel.add(btnCadastro);
		
		JButton btnConsulta = new JButton("Consultar Aluno");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameConsulta fcon = new FrameConsulta();
				fcon.frameconsulta.setVisible(true);
				framehome.dispose();
			}
		});
		btnConsulta.setFont(new Font("Arial", Font.BOLD, 13));
		btnConsulta.setBackground(new Color(255, 255, 255));
		btnConsulta.setBounds(54, 399, 151, 33);
		btnConsulta.setBounds(43, 385, 176, 33);

		panel.add(btnConsulta);
		
		JButton btnBoleto = new JButton("Novo boleto");
		btnBoleto.setFont(new Font("Arial", Font.BOLD, 13));
		btnBoleto.setBackground(new Color(255, 255, 255));
		btnBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBoleto.setBorder(UIManager.getBorder("Button.border"));
		btnBoleto.setBounds(43, 456, 176, 33);
		panel.add(btnBoleto);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Arial", Font.BOLD, 13));
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameLogin fl = new FrameLogin();
				fl.framelogin.setVisible(true);
				framehome.dispose();
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setBounds(43, 533, 176, 33);
		panel.add(btnSair);
		
		JButton btnCadastro_1 = new JButton("Cadastro de Professor");
		btnCadastro_1.setFont(new Font("Arial", Font.BOLD, 13));
		btnCadastro_1.setBackground(Color.WHITE);
		btnCadastro_1.setBounds(54, 341, 151, 33);
		btnCadastro_1.setBounds(43, 312, 176, 33);
		panel.add(btnCadastro_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(472, 679, 324, 40);
		framehome.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(new Rectangle(0, 0, 100, 1000));
		lblNewLabel_1.setIcon(new ImageIcon(FrameHome.class.getResource("/assets_loginFrame/Logotipo_academia_personal_trainner__1_-removebg-preview.png")));
		lblNewLabel_1.setBounds(380, 113, 481, 442);
		framehome.getContentPane().add(lblNewLabel_1);
		
	}

	public void getAdm(Administrador admLogado) {
		// TODO Auto-generated method stub
		
	}
}
