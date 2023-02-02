package br.edu.ifpe.edu.paulista.tadala_fit.ui.professor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class MeusAlunosProfessor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MeusAlunosProfessor dialog = new MeusAlunosProfessor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MeusAlunosProfessor() {
		setBounds(100, 100, 1024, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 79, 157));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MeusAlunosProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		logo.setBounds(736, 96, 200, 139);
		contentPanel.add(logo);
		
		JButton btnAssumir = new JButton("Assumir Aluno");
		btnAssumir.setEnabled(false);
		btnAssumir.setFont(new Font("Arial", Font.BOLD, 13));
		btnAssumir.setBackground(Color.WHITE);
		btnAssumir.setBounds(750, 378, 174, 36);
		contentPanel.add(btnAssumir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 105, 592, 575);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Peso", "Altura", "BF", "Comorbidade"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnPrescreverTreino = new JButton("Prescrever Treino");
		btnPrescreverTreino.setFont(new Font("Arial", Font.BOLD, 13));
		btnPrescreverTreino.setEnabled(false);
		btnPrescreverTreino.setBackground(Color.WHITE);
		btnPrescreverTreino.setBounds(750, 450, 174, 36);
		contentPanel.add(btnPrescreverTreino);
		
		JButton btnVerPerfil = new JButton("Ver Perfil");
		btnVerPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnVerPerfil.setEnabled(false);
		btnVerPerfil.setBackground(Color.WHITE);
		btnVerPerfil.setBounds(750, 313, 174, 36);
		contentPanel.add(btnVerPerfil);
		
		textPesquisa = new JTextField();
		textPesquisa.setFont(new Font("Arial", Font.PLAIN, 13));
		textPesquisa.setColumns(10);
		textPesquisa.setBounds(77, 69, 440, 26);
		contentPanel.add(textPesquisa);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 13));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(527, 69, 142, 26);
		contentPanel.add(btnPesquisar);
	}

}
