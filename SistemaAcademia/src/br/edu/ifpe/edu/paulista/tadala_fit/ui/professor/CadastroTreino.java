package br.edu.ifpe.edu.paulista.tadala_fit.ui.professor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.json.JSONObject;

import br.edu.ifpe.edu.paulista.tadala_fit.ui.aluno.TreinoAluno;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;

public class CadastroTreino extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField txtboasvindas;
	protected Aluno alunoAtual;
	private String chave;
	private String valor1;
	private String valor2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Integer matricula = null;
			CadastroTreino dialog = new CadastroTreino(matricula);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroTreino(Integer matricula) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja voltar?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				}else {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TreinoAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		setResizable(false);
		setTitle("Tadalafit - Versão 1.0");
		setBounds(100, 100, 1024, 768);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 79, 157));
		panel.setBounds(0, 0, 1008, 729);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TreinoAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel.setBounds(22, 518, 204, 200);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2023 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setBounds(320, 663, 342, 40);
		panel.add(lblNewLabel_2);
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnB.setFocusPainted(false);
		btnB.setBackground(Color.WHITE);
		btnB.setBounds(320, 117, 121, 40);
		panel.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnC.setFocusPainted(false);
		btnC.setBackground(Color.WHITE);
		btnC.setBounds(451, 117, 121, 40);
		panel.add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnD.setFocusPainted(false);
		btnD.setBackground(Color.WHITE);
		btnD.setBounds(585, 117, 121, 40);
		panel.add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnE.setFocusPainted(false);
		btnE.setBackground(Color.WHITE);
		btnE.setBounds(716, 117, 121, 40);
		panel.add(btnE);
		
		JLabel lblNewLabel_1 = new JLabel("TREINOS");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(461, 74, 168, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 65, 130));
		panel_1.setBounds(189, 196, 649, 422);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 10, 487, 402);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome do exerc\u00EDcio", "Repeti\u00E7\u00F5es", "Observa\u00E7\u00F5es"
			}
		){
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {
			return false;
			}
		});
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();		
		scrollPane.setViewportView(table);
		
		txtboasvindas = new JTextField();
		txtboasvindas.setForeground(Color.WHITE);
		txtboasvindas.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtboasvindas.setEnabled(false);
		txtboasvindas.setDisabledTextColor(Color.WHITE);
		txtboasvindas.setColumns(10);
		txtboasvindas.setBorder(null);
		txtboasvindas.setBackground(new Color(0, 79, 157));
		txtboasvindas.setBounds(279, 57, 97, 20);
		panel.add(txtboasvindas);
		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnA.setFocusPainted(false);
		btnA.setBackground(Color.WHITE);
		btnA.setBounds(189, 117, 121, 40);
		panel.add(btnA);
		
		JLabel lblSemTreino = new JLabel("");
		lblSemTreino.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemTreino.setForeground(new Color(255, 255, 255));
		lblSemTreino.setFont(new Font("Arial", Font.BOLD, 14));
		lblSemTreino.setBounds(330, 167, 354, 20);
		panel.add(lblSemTreino);
		lblSemTreino.setBackground(new Color(0, 0, 0));
		
		btnA.addActionListener(e -> {
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_a() != null) {
				JSONObject treino_a_JSON = alunoAtual.getTreino_a();
				for (int i = 0; i < treino_a_JSON.names().length(); i++) {
					
					String key = treino_a_JSON.names().getString(i);
					
					chave = key;
					
						if (treino_a_JSON.getJSONArray(key).length() == 2) {
							
							valor1 = treino_a_JSON.getJSONArray(key).getString(0) + " ";
							valor2 = treino_a_JSON.getJSONArray(key).getString(1) + " ";
							modelo.addRow(new Object []{
									chave,
									valor1,
									valor2
								});
						} else if(treino_a_JSON.getJSONArray(key).length() == 0) {
							lblSemTreino.setText("Você ainda não tem treino");
						}else {
							String value = treino_a_JSON.getJSONArray(key).getString(0);
							modelo.addRow(new Object []{
									chave,
									value,
									" "
								});
						}					
					
				}
			
			} else {
				lblSemTreino.setText("Você ainda não tem treino A");
			}			
		});
		
		btnB.addActionListener(e -> {
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_b() != null) {
				JSONObject treino_b_JSON = alunoAtual.getTreino_b();
			for (int i = 0; i < treino_b_JSON.names().length(); i++) {
				
				String key = treino_b_JSON.names().getString(i);
				
				chave = key;
				
					if (treino_b_JSON.getJSONArray(key).length() == 2) {
						
						valor1 = treino_b_JSON.getJSONArray(key).getString(0) + " ";
						valor2 = treino_b_JSON.getJSONArray(key).getString(1) + " ";
			
						modelo.addRow(new Object []{
								chave,
								valor1,
								valor2,
							});
					} else if(treino_b_JSON.getJSONArray(key).length() == 0) {
						lblSemTreino.setText("Você ainda não tem treino");
						}
					else {
						List<String> chavesadicionadas = new ArrayList<>();
						String value = "";
						value += treino_b_JSON.getJSONArray(key).getString(0) + " ";
						if (!chavesadicionadas.contains(key)) {
						      modelo.addRow(new Object []{
						         chave,
						         value,
						      });
						      chavesadicionadas.add(key);
						   } else {
						      modelo.addRow(new Object []{
						         "",
						         value,
						     });	
						   }
					}
				
			}
			
			} else {
				lblSemTreino.setText("Você ainda não tem treino B");
			}			
		});
		
		btnC.addActionListener(e -> {
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_c() != null) {
				JSONObject treino_c_JSON = alunoAtual.getTreino_c();
			for (int i = 0; i < treino_c_JSON.names().length(); i++) {
				
				String key = treino_c_JSON.names().getString(i);
				
				chave = key;
				
					if (treino_c_JSON.getJSONArray(key).length() == 2) {
						
						valor1 = treino_c_JSON.getJSONArray(key).getString(0) + " ";
						valor2 = treino_c_JSON.getJSONArray(key).getString(1) + " ";
						modelo.addRow(new Object []{
								chave,
								valor1,
								valor2
							});
					} else if(treino_c_JSON.getJSONArray(key).length() == 0) {
						lblSemTreino.setText("Você ainda não tem treino");
					}
					else {
						String value = treino_c_JSON.getJSONArray(key).getString(0);
						modelo.addRow(new Object []{
								chave,
								value,
								" "
							});
					}				

			}
			
			} else {
				lblSemTreino.setText("Você ainda não tem treino C");
			}			
		});
		
		btnD.addActionListener(e -> {
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_d() != null) {
				JSONObject treino_d_JSON = alunoAtual.getTreino_d();
			for (int i = 0; i < treino_d_JSON.names().length(); i++) {
				
				String key = treino_d_JSON.names().getString(i);
				
				chave = key;
			
					if (treino_d_JSON.getJSONArray(key).length() == 2) {
						
						valor1 = treino_d_JSON.getJSONArray(key).getString(0) + " ";
						valor2 = treino_d_JSON.getJSONArray(key).getString(1) + " ";
						modelo.addRow(new Object []{
								chave,
								valor1,
								valor2
							});
					} else if(treino_d_JSON.getJSONArray(key).length() == 0) {
						lblSemTreino.setText("Você ainda não tem treino");
					}
					else {
						String value = treino_d_JSON.getJSONArray(key).getString(0);
						modelo.addRow(new Object []{
								chave,
								value,
								" "
							});
					}				
			}
			//modelo.removeRow(modelo.getRowCount()-1);
			
			} else {
				lblSemTreino.setText("Você ainda não tem treino D");
			}			
		});
		
		btnE.addActionListener(e -> {
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_e() != null) {
				JSONObject treino_e_JSON = alunoAtual.getTreino_e();
			for (int i = 0; i < treino_e_JSON.names().length(); i++) {
				
				String key = treino_e_JSON.names().getString(i);
				
				chave = key;
				
					if (treino_e_JSON.getJSONArray(key).length() == 2) {
						
						valor1 = treino_e_JSON.getJSONArray(key).getString(0) + " ";
						valor2 = treino_e_JSON.getJSONArray(key).getString(1) + " ";
						modelo.addRow(new Object []{
								chave,
								valor1,
								valor2
							});
					} else if(treino_e_JSON.getJSONArray(key).length() == 0) {
						lblSemTreino.setText("Você ainda não tem treino");
					}
					else {
						String value = treino_e_JSON.getJSONArray(key).getString(0);
						modelo.addRow(new Object []{
								chave,
								value,
								" "
							});
					}				
			}
			
			} else {
				lblSemTreino.setText("Você ainda não tem treino E");
			}			
		});

	}
}

