package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class ConsultaAluno extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField;
	private JTextField teste;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			ConsultaAluno dialog = new ConsultaAluno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaAluno dialog = new ConsultaAluno();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaAluno() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja encerrar as consultas","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				}else {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1025, 769);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 79, 157));
		panel.setBounds(0, 0, 1011, 732);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnExcluir = new JButton("Excluir Matrícula");
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 13));
		btnExcluir.setEnabled(false);
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(766, 296, 174, 36);
		panel.add(btnExcluir);
		
		JButton btnRenovar = new JButton("Renovar Pagamento");
		btnRenovar.setFont(new Font("Arial", Font.BOLD, 13));
		btnRenovar.setEnabled(false);
		btnRenovar.setBackground(Color.WHITE);
		btnRenovar.setBounds(766, 369, 174, 36);
		panel.add(btnRenovar);
		
		JButton btnPerfil = new JButton("Ver Perfil");
		btnPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnPerfil.setEnabled(false);
		btnPerfil.setBackground(Color.WHITE);
		btnPerfil.setBounds(766, 443, 174, 36);
		panel.add(btnPerfil);
		
		JButton btnCriart = new JButton("Criar Treino");
		btnCriart.setFont(new Font("Arial", Font.BOLD, 13));
		btnCriart.setEnabled(false);
		btnCriart.setBackground(Color.WHITE);
		btnCriart.setBounds(766, 518, 174, 36);
		panel.add(btnCriart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 99, 592, 592);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnExcluir.setEnabled(true);
				btnRenovar.setEnabled(true);
				btnPerfil.setEnabled(true);
				btnCriart.setEnabled(true);
			}
		});
		table.setBounds(213, 93, 1, 1);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Email", "Status"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ConsultaAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		logo.setBounds(752, 82, 200, 139);
		panel.add(logo);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(78, 62, 440, 26);
		panel.add(textField);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 13));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(528, 62, 142, 26);
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
		panel.add(btnPesquisar);
		
		teste = new JTextField();
		teste.setFont(new Font("Arial", Font.PLAIN, 13));
		teste.setColumns(10);
		teste.setBounds(438, 27, 210, 20);
		panel.add(teste);
	}
}
