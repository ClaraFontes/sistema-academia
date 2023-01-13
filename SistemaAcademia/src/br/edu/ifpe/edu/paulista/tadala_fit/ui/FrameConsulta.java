package br.edu.ifpe.edu.paulista.tadala_fit.ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrameConsulta {

	protected JFrame frameconsulta;
	protected JTable table;
	private JTextField pesquisa;
	private JTextField teste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameConsulta window = new FrameConsulta();
					window.frameconsulta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public FrameConsulta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameconsulta = new JFrame();
		frameconsulta.getContentPane().setBackground(new Color(0, 79, 157));
		frameconsulta.getContentPane().setLayout(null);
		frameconsulta.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja fechar a aplicação?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					frameconsulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}else {
					frameconsulta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir Matrícula");
		btnExcluir.setEnabled(false);
		btnExcluir.setBackground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 13));
		btnExcluir.setBounds(766, 265, 174, 36);
		frameconsulta.getContentPane().add(btnExcluir);
		
		JButton btnPerfil = new JButton("Ver Perfil");
		btnPerfil.setEnabled(false);
		btnPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnPerfil.setBackground(Color.WHITE);
		btnPerfil.setBounds(766, 412, 174, 36);
		frameconsulta.getContentPane().add(btnPerfil);
		
		JButton btnRenovar = new JButton("Renovar Pagamento");
		btnRenovar.setEnabled(false);
		btnRenovar.setFont(new Font("Arial", Font.BOLD, 13));
		btnRenovar.setBackground(Color.WHITE);
		btnRenovar.setBounds(766, 338, 174, 36);
		frameconsulta.getContentPane().add(btnRenovar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameHome fh = new FrameHome();
				fh.framehome.setVisible(true);
				frameconsulta.dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(766, 566, 174, 36);
		frameconsulta.getContentPane().add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 99, 592, 592);
		frameconsulta.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnExcluir.setEnabled(true);
				btnRenovar.setEnabled(true);
				btnPerfil.setEnabled(true);
			}
		});
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Email", "Status"
			}
		));
		scrollPane.setViewportView(table);
		
		pesquisa = new JTextField();
		pesquisa.setFont(new Font("Arial", Font.PLAIN, 13));
		pesquisa.setBounds(78, 62, 440, 26);
		frameconsulta.getContentPane().add(pesquisa);
		pesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* Quando clicado, fazer a consulta de acordo com o nome que foi escrito. 
					A consulta será feita dentro do banco de dados e depois mostrada. */
				
				String nome = teste.getText(); // nome pesquisado
				String email = ""; // email de acordo com o nome pesquisado
				String status = ""; // status de acordo com o nome pesquisado
				
				//adiciona nova linha
				// as linhas presentes nessa table "consulta" serão de acordo com a quantidade de alunos matriculados no banco de dados.
				DefaultTableModel consulta = (DefaultTableModel) table.getModel();
				consulta.addRow(new String[] {nome, email, status});
				
				
				
			}
		});
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 13));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(528, 62, 142, 26);
		frameconsulta.getContentPane().add(btnPesquisar);
		
		teste = new JTextField();
		teste.setFont(new Font("Arial", Font.PLAIN, 13));
		teste.setBounds(438, 27, 210, 20);
		frameconsulta.getContentPane().add(teste);
		teste.setColumns(10);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(FrameConsulta.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		logo.setBounds(753, 82, 200, 139);
		frameconsulta.getContentPane().add(logo);
		
		JButton btnCriart = new JButton("Criar Treino");
		btnCriart.setFont(new Font("Arial", Font.BOLD, 13));
		btnCriart.setEnabled(false);
		btnCriart.setBackground(Color.WHITE);
		btnCriart.setBounds(766, 487, 174, 36);
		frameconsulta.getContentPane().add(btnCriart);
		frameconsulta.setBounds(100, 100, 1025, 769);
		frameconsulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameconsulta.setResizable(true);
	}
}
