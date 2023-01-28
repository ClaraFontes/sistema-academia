package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
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
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 13));
		btnExcluir.setEnabled(false);
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(766, 328, 174, 36);
		panel.add(btnExcluir);
		
		JButton btnRenovar = new JButton("Renovar Pagamento");
		btnRenovar.setFont(new Font("Arial", Font.BOLD, 13));
		btnRenovar.setEnabled(false);
		btnRenovar.setBackground(Color.WHITE);
		btnRenovar.setBounds(766, 398, 174, 36);
		panel.add(btnRenovar);
		
		JButton btnPerfil = new JButton("Ver Perfil");
		btnPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnPerfil.setEnabled(false);
		btnPerfil.setBackground(Color.WHITE);
		btnPerfil.setBounds(766, 473, 174, 36);
		panel.add(btnPerfil);
		
		JButton btnCriart = new JButton("Criar Treino");
		btnCriart.setFont(new Font("Arial", Font.BOLD, 13));
		btnCriart.setEnabled(false);
		btnCriart.setBackground(Color.WHITE);
		btnCriart.setBounds(766, 545, 174, 36);
		panel.add(btnCriart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		scrollPane.setBounds(78, 99, 592, 592);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
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
						System.out.print(a.getNome());				
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
		btnconsultar.setBounds(766, 262, 174, 36);
		panel.add(btnconsultar);
	}
}