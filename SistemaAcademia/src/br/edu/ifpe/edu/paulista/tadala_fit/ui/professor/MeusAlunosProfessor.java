package br.edu.ifpe.edu.paulista.tadala_fit.ui.professor;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.edu.paulista.tadala_fit.ui.ConsultaAlunoPerfil;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;
import br.edu.ifpe.paulista.tadala_fit.core.ReadController;

import javax.swing.JTextField;

public class MeusAlunosProfessor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textPesquisa;
	protected Professor professorAtual;
	private Object matricula;
	private String nome;
	private JButton btnVerPerfil;
	private JButton btnPrescreverTreino;

	public Object getMatricula() {
		return matricula;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MeusAlunosProfessor dialog = new MeusAlunosProfessor();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MeusAlunosProfessor() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 105, 592, 575);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matr\u00EDcula", "Nome", "Peso", "Altura", "BF", "Comorbidade"
			}
		));
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) {
		            int linha = table.getSelectedRow();
		            if (linha >= 0) {
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                int coluna= 0; 
		                matricula = model.getValueAt(linha, coluna);
		                int coluna1 = 1;
		                nome = (String) model.getValueAt(linha,coluna1);
		            }
		        }
		    }
		});
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnVerPerfil.setEnabled(true);
				btnPrescreverTreino.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		
		btnPrescreverTreino = new JButton("Prescrever Treino");
		btnPrescreverTreino.setFont(new Font("Arial", Font.BOLD, 13));
		btnPrescreverTreino.setEnabled(false);
		btnPrescreverTreino.setBackground(Color.WHITE);
		btnPrescreverTreino.setBounds(751, 465, 174, 36);
		contentPanel.add(btnPrescreverTreino);
		
		btnVerPerfil = new JButton("Ver Perfil");
		btnVerPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer matriculafiltered = (Integer) matricula;
				Integer matricula = matriculafiltered.intValue();
				ConsultaAlunoPerfil cap;
				try {
					cap = new ConsultaAlunoPerfil(matricula,nome);
					cap.setModal(true);
					cap.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnVerPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnVerPerfil.setEnabled(false);
		btnVerPerfil.setBackground(Color.WHITE);
		btnVerPerfil.setBounds(751, 389, 174, 36);
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
		
		JButton btnconsultar = new JButton("Consultar Alunos");
		btnconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Aluno> aluno;
				try {
					if (modelo.getRowCount() != 0) {
						modelo.setRowCount(0);
					}
					int matriculaProf = professorAtual.getMatricula();
					aluno = ReadController.getMyAlunos(matriculaProf);
					if (aluno != null) {
						for(Aluno a: aluno) {
							modelo.addRow(new Object[]{
									a.getMatricula(),
									a.getNome(),
									a.getPeso(),
									a.getAltura(),
									a.getBf(),
									a.getComorbidade()
							});
						}	
					}else {
						JOptionPane.showMessageDialog(null,"Você não possui nenhum aluno");
					}
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}		
			}
		});
		btnconsultar.setFont(new Font("Arial", Font.BOLD, 13));
		btnconsultar.setBackground(Color.WHITE);
		btnconsultar.setBounds(751, 316, 174, 36);
		contentPanel.add(btnconsultar);
		
		JLabel lblNewLabel = new JLabel("Seus Alunos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(77, 13, 188, 46);
		contentPanel.add(lblNewLabel);
		
	}
	public void getProfessor(Professor professorLogado) {
		professorAtual = professorLogado;
	}
}
