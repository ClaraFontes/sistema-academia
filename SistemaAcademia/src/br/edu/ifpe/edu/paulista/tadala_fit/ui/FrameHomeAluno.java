package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class FrameHomeAluno {

	protected JFrame framehomealuno;
	protected Aluno alunoAtual;
	protected FrameHomeAluno window;
	protected JTextField txtboasvindas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHomeAluno window = new FrameHomeAluno();
					window.framehomealuno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameHomeAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		framehomealuno = new JFrame();
		framehomealuno.getContentPane().setForeground(new Color(255, 255, 255));
		framehomealuno.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameHomeAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		framehomealuno.setResizable(false);
		framehomealuno.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja fechar a aplicação?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					framehomealuno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					framehomealuno.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		framehomealuno.getContentPane().setBackground(new Color(0, 79, 157));
		framehomealuno.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 65, 130));
		panel.setBounds(44, 11, 258, 708);
		framehomealuno.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameHomeAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel.setBounds(30, 53, 200, 159);
		panel.add(lblNewLabel);
		
		JButton btnverperfil = new JButton("Meu Perfil");
		btnverperfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PerfilAluno fa = new PerfilAluno();
				fa.getAluno(alunoAtual);
				fa.setModal(true);
				fa.setVisible(true);
			}
		});
		btnverperfil.setBackground(new Color(240, 240, 240));
		btnverperfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnverperfil.setBounds(45, 305, 176, 33);
		panel.add(btnverperfil);
		
		JButton btnconsultartreino = new JButton("Consultar Treino");
		btnconsultartreino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreinoAluno ta = new TreinoAluno();
				ta.getAluno(alunoAtual);
				ta.setModal(true);
				ta.setVisible(true);
			}
		});
		btnconsultartreino.setBackground(new Color(255, 255, 255));
		btnconsultartreino.setFont(new Font("Arial", Font.BOLD, 13));
		btnconsultartreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnconsultartreino.setBounds(45, 371, 176, 33);
		panel.add(btnconsultartreino);
		
		JButton btnsair = new JButton("Sair");
		btnsair.setBackground(new Color(255, 255, 255));
		btnsair.setFont(new Font("Arial", Font.BOLD, 13));
		btnsair.setBounds(45, 436, 176, 33);
		panel.add(btnsair);
		btnsair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja sair?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin fl = new FrameLogin();
					fl.framelogin.setVisible(true);
					framehomealuno.dispose();
				}else {
	
			  }
		    }
		});
		
		JLabel lblNewLabel_3 = new JLabel("Bem vindo(a),");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(40, 226, 95, 14);
		panel.add(lblNewLabel_3);
		
		txtboasvindas = new JTextField();
		txtboasvindas.setDisabledTextColor(new Color(255, 255, 255));
		txtboasvindas.setForeground(new Color(255, 255, 255));
		txtboasvindas.setBackground(new Color(0, 65, 130));
		txtboasvindas.setBorder(null);
		txtboasvindas.setEnabled(false);
		txtboasvindas.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtboasvindas.setBounds(133, 207, 97, 20);
		panel.add(txtboasvindas);
		txtboasvindas.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrameHomeAluno.class.getResource("/assets_loginFrame/Logotipo_academia_personal_trainner__1_-removebg-preview.png")));
		lblNewLabel_1.setBounds(380, 113, 481, 442);
		framehomealuno.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2023 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(472, 679, 324, 40);
		framehomealuno.getContentPane().add(lblNewLabel_2);
		framehomealuno.setTitle("TadalaFit - Versão - 1.0");
		framehomealuno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framehomealuno.setBounds(100, 100, 1024, 769);
	}

	public void getAluno(Aluno alunoLogado) {
		alunoAtual = alunoLogado;
		txtboasvindas.setText(alunoLogado.getNome());
		
	}
}
