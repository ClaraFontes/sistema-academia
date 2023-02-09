package br.edu.ifpe.edu.paulista.tadala_fit.ui.professor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JTextField;
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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.edu.paulista.tadala_fit.ui.ConsultaAlunoPerfil;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;
import br.edu.ifpe.paulista.tadala_fit.core.ReadController;
import br.edu.ifpe.paulista.tadala_fit.core.UpdateController;

public class AlunosSemProfessor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object matricula;
	private String nome;
	protected Professor professorAtual;
	private JButton btnVerPerfil;
	private JButton btnAssumir;
	

	public Object getMatricula() {
		return matricula; 
	}
	
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
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(AlunosSemProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
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
				btnAssumir.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		
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
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
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
		
		btnAssumir = new JButton("Assumir Aluno");
		btnAssumir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer matriculafiltered = (Integer) matricula;
				Integer matricula = matriculafiltered.intValue();
				Integer matriculaProf = professorAtual.getMatricula();
				try {
					UpdateController.assumeAluno(matriculaProf, matricula);
				} catch (RuntimeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAssumir.setFont(new Font("Arial", Font.BOLD, 13));
		btnAssumir.setEnabled(false);
		btnAssumir.setBackground(Color.WHITE);
		btnAssumir.setBounds(750, 456, 174, 36);
		contentPanel.add(btnAssumir);
		
		JButton btnconsultar = new JButton("Consultar Alunos");
		
		
		btnconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Aluno> aluno;
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								"Matrícula", "Nome", "Peso", "Altura", "BF", "Comorbidade"
						}
					){
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
						return false;
						}
					});
				try {
					if (modelo.getRowCount() != 0) {
						modelo.setRowCount(0);
					}
					aluno = ReadController.getAlunosWithoutProf();
					if (aluno != null) {
	                    for(Aluno a: aluno) {
	                    	DefaultTableModel modelo = (DefaultTableModel) table.getModel();
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
	                        JOptionPane.showMessageDialog(null,"Não existe nenhum aluno cadastrado");
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
		btnconsultar.setBounds(750, 305, 174, 36);
		contentPanel.add(btnconsultar);
	}
	
	public void getProfessor(Professor professorLogado) {
		professorAtual = professorLogado;
	}
}
