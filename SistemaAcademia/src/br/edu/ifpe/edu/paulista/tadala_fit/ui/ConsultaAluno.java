package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.DeleteController;
import br.edu.ifpe.paulista.tadala_fit.core.ReadController;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ScrollPaneConstants;

public class ConsultaAluno extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTable table;
	private JTextField Pesquisar;
	protected Aluno alunoatual;
	private Object matricula;

	public Object getMatricula() {
		return matricula;
	}

	/**
	 * Launch the application.
	 */
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
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que gostaria de Excluir esse Aluno?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					JOptionPane.showMessageDialog(null, "Aluno Excluido com sucesso!\n"
							+ "realize a consulta novamente para listar os dados atualizados");
					Integer matriculafiltered = (Integer) matricula;
					Integer matricula = matriculafiltered.intValue();
					try {
						DeleteController.deleteAluno(matricula);
					} catch (ClassNotFoundException | RuntimeException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					
				}
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 13));
		btnExcluir.setEnabled(false);
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(766, 376, 174, 36);
		panel.add(btnExcluir);
		
		JButton btnPerfil = new JButton("Ver Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer matriculafiltered = (Integer) matricula;
				Integer matricula = matriculafiltered.intValue();
				ConsultaAlunoPerfil cap = new ConsultaAlunoPerfil(matricula);
				cap.setModal(true);
				cap.setVisible(true);
			}
		});
		btnPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnPerfil.setEnabled(false);
		btnPerfil.setBackground(Color.WHITE);
		btnPerfil.setBounds(766, 450, 174, 36);
		panel.add(btnPerfil);
		
		JButton btnCriartreinos = new JButton("Criar Treino");
		btnCriartreinos.setFont(new Font("Arial", Font.BOLD, 13));
		btnCriartreinos.setEnabled(false);
		btnCriartreinos.setBackground(Color.WHITE);
		btnCriartreinos.setBounds(766, 525, 174, 36);
		panel.add(btnCriartreinos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setInheritsPopupMenu(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		scrollPane.setBounds(78, 99, 592, 592);
		panel.add(scrollPane);
		
		table = new JTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) {
		            int linha = table.getSelectedRow();
		            if (linha >= 0) {
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                int coluna= 0; 
		                matricula = model.getValueAt(linha, coluna);
		                System.out.print(matricula+"\n");
		            }
		        }
		    }
		});
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnExcluir.setEnabled(true);
				btnPerfil.setEnabled(true);
				btnCriartreinos.setEnabled(true);
			}
		});
		table.setBounds(213, 93, 1, 1);
		table.setFont(new Font("Arial", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Telefone", "Status"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(81);
		table.getColumnModel().getColumn(1).setMinWidth(22);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ConsultaAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		logo.setBounds(752, 82, 200, 139);
		panel.add(logo);
		
		Pesquisar = new JTextField();
		Pesquisar.setFont(new Font("Arial", Font.PLAIN, 13));
		Pesquisar.setColumns(10);
		Pesquisar.setBounds(78, 62, 440, 26);
		panel.add(Pesquisar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 13));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(528, 62, 142, 26);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer pesquisa = Integer.parseInt(Pesquisar.getText());
					table.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Id", "Nome", "Telefone", "Status"
							}
						));
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					Aluno pesquisaAluno = ReadController.getAlunoFiltered(pesquisa);
						modelo.addRow(new Object[]{
								pesquisaAluno.getMatricula(),
								pesquisaAluno.getNome(),
								pesquisaAluno.getTelefone(),
								pesquisaAluno.getQtdDiasUltimoPagamento() > 30 ? "Inadinplente" : "Pago"
						});	
						
				} catch (NumberFormatException e5) {
					JOptionPane.showMessageDialog(null,"Insira uma matrícula válida pra realizar a pesquisa!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null,"preencha o campo!");
				}
			}
		});
		panel.add(btnPesquisar);
		
		JButton btnconsultar = new JButton("Consultar Alunos");
		btnconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Id", "Nome", "Telefone", "Status"
						}
					));
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				ArrayList<Aluno> aluno;
				try {
					aluno = ReadController.getAllAlunos();
					for(Aluno a: aluno) {
						modelo.addRow(new Object[]{
								a.getMatricula(),
								a.getNome(),
								a.getTelefone(),
								a.getQtdDiasUltimoPagamento() > 30 ? "Inadinplente" : "Pago"
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
		});
		btnconsultar.setFont(new Font("Arial", Font.BOLD, 13));
		btnconsultar.setBackground(Color.WHITE);
		btnconsultar.setBounds(766, 304, 174, 36);
		panel.add(btnconsultar);
	}
}