package br.edu.ifpe.edu.paulista.tadala_fit.ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import br.edu.ifpe.paulista.tadala_fit.core.Administrador;
import java.awt.Rectangle;
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
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAluno fc;
				try {
					fc = new CadastroAluno();
					fc.setModal(true);
					fc.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastro.setFont(new Font("Arial", Font.BOLD, 13));
		btnCadastro.setBackground(new Color(255, 255, 255));

		btnCadastro.setBounds(43, 241, 176, 33);
		panel.add(btnCadastro);
		
		JButton btnConsultaAluno = new JButton("Consultar Aluno");
		btnConsultaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaAluno fcon = new ConsultaAluno();
				fcon.setModal(true);
				fcon.setVisible(true);
			}
		});
		btnConsultaAluno.setFont(new Font("Arial", Font.BOLD, 13));
		btnConsultaAluno.setBackground(new Color(255, 255, 255));
		btnConsultaAluno.setBounds(43, 372, 151, 33);
		btnConsultaAluno.setBounds(43, 385, 176, 33);

		panel.add(btnConsultaAluno);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Arial", Font.BOLD, 13));
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja sair?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin fl = new FrameLogin();
					fl.framelogin.setVisible(true);
					framehome.dispose();
				}else {
	
			  }
		    }
		});
		btnSair.setBounds(43, 527, 176, 33);
		panel.add(btnSair);
		
		JButton btnCadastroProf = new JButton("Cadastrar Professor");
		btnCadastroProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProfessor cp;
				try {
					cp = new CadastroProfessor();
					cp.setModal(true);
					cp.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		btnCadastroProf.setFont(new Font("Arial", Font.BOLD, 13));
		btnCadastroProf.setBackground(Color.WHITE);
		btnCadastroProf.setBounds(43, 323, 151, 33);
		btnCadastroProf.setBounds(43, 312, 176, 33);
		panel.add(btnCadastroProf);
		
		JButton btnConsultaProf = new JButton("Consultar Professor");
		btnConsultaProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaProfessor fconProf = new ConsultaProfessor();
				fconProf.setModal(true);
				fconProf.setVisible(true);
				
			}
		});
		btnConsultaProf.setFont(new Font("Arial", Font.BOLD, 13));
		btnConsultaProf.setBackground(Color.WHITE);
		btnConsultaProf.setBounds(43, 454, 176, 33);
		panel.add(btnConsultaProf);
		
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
