package br.edu.ifpe.edu.paulista.tadala_fit.ui.professor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;
import br.edu.ifpe.paulista.tadala_fit.core.ReadController;

public class AlunosSemProfessor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	protected Professor professorAtual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlunosSemProfessor dialog = new AlunosSemProfessor();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlunosSemProfessor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja encerrar as consultas?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				}else {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setBounds(100, 100, 1025, 758);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 79, 157));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(77, 69, 440, 26);
		contentPanel.add(textField);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 13));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(527, 69, 142, 26);
		contentPanel.add(btnPesquisar);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(AlunosSemProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		logo.setBounds(736, 96, 200, 139);
		contentPanel.add(logo);
		
		JButton btnVerPerfil = new JButton("Ver Perfil");
		btnVerPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnVerPerfil.setEnabled(false);
		btnVerPerfil.setBackground(Color.WHITE);
		btnVerPerfil.setBounds(750, 380, 174, 36);
		contentPanel.add(btnVerPerfil);
		
		JButton btnAssumir = new JButton("Assumir Aluno");
		btnAssumir.setFont(new Font("Arial", Font.BOLD, 13));
		btnAssumir.setEnabled(false);
		btnAssumir.setBackground(Color.WHITE);
		btnAssumir.setBounds(750, 456, 174, 36);
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
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		JButton btnconsultar = new JButton("Consultar Alunos");
		
		//tá retornando os alunos do professor e não aqueles que não tem professor
		
		/*btnconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Aluno> aluno;
				try {
					int matriculaProf = professorAtual.getMatricula();
					aluno = ReadController.getAlunosWithoutProf(matriculaProf);
					for(Aluno a: aluno) {
						modelo.addRow(new Object[]{
								a.getNome(),
								a.getPeso(),
								a.getAltura(),
								a.getBf(),
								a.getComorbidade()
						});
					}	
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}		
			}
		});*/
		
		btnconsultar.setFont(new Font("Arial", Font.BOLD, 13));
		btnconsultar.setBackground(Color.WHITE);
		btnconsultar.setBounds(750, 305, 174, 36);
		contentPanel.add(btnconsultar);
	}
	
	public void getProfessor(Professor professorLogado) {
		professorAtual = professorLogado;
	}
}
