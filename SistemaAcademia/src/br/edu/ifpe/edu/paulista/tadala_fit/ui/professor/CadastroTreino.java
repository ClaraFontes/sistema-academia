package br.edu.ifpe.edu.paulista.tadala_fit.ui.professor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.bridj.cpp.std.list;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.edu.ifpe.edu.paulista.tadala_fit.ui.aluno.TreinoAluno;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.UpdateController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CadastroTreino extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField txtboasvindas;
	protected Aluno alunoAtual;
	private String valor1;
	private String valor2;
	private String valor3;
	private JButton btnAdicionar;
	private JButton btnExcluir;
	private JButton btnEnviar;
	private JButton btnEditar;
	private ArrayList<ArrayList<String>> exercicios = new ArrayList<ArrayList<String>>();
	private ArrayList<String []> exerciciosNew = new ArrayList<String[]>();
	private ArrayList<String> exerciciosNewx = new ArrayList<String>();
	private ArrayList<ArrayList<String>> exerciciosNew2 = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> exerciciosNew3 = new ArrayList<ArrayList<String>>();
	private ArrayList<String> arrSuporte = new ArrayList<String>();
	private JTable table;
	private static String table_treino;
	private boolean celleditable = false;

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
		panel_1.setBounds(189, 196, 507, 422);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 487, 402);
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
			return celleditable;
			}
		});
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) throws IndexOutOfBoundsException {
		    		if (!e.getValueIsAdjusting()) {
			        	btnEditar.setEnabled(true);
			        	btnEnviar.setEnabled(true);
			        	btnExcluir.setEnabled(true);
		    	}       
		    }
		});
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
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> row = new ArrayList<String>();
				row.add("");
				row.add("");
				row.add("");
				modelo.addRow(new Object []{
						row.get(0),
						row.get(1),
						row.get(2)
					});	
			}
		});
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(716, 233, 121, 40);
		panel.add(btnAdicionar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 celleditable = ! celleditable;
				 table.repaint();
			}
		});
		btnEditar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEditar.setFocusPainted(false);
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(716, 322, 121, 40);
		panel.add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
				    DefaultTableModel model = (DefaultTableModel) table.getModel();
				    model.removeRow(selectedRow);
				}
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 13));
		btnExcluir.setFocusPainted(false);
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(716, 419, 121, 40);
		panel.add(btnExcluir);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(table.getRowCount());
				if (table.getRowCount() >= 1) {
					
					for (int i = 0; i < table.getRowCount(); i++) {
						   String[] row = new String[table.getColumnCount()];
						   
						   for (int j = 0; j < table.getColumnCount(); j++) {
						      row[j] = String.valueOf(table.getValueAt(i, j));
						}
						   	exerciciosNew.add(row);	
						}
						
						StringBuilder sb = new StringBuilder();
						
						for (String[] array  : exerciciosNew) {
							exerciciosNewx.removeAll(exerciciosNewx);
						  for (int p = 0; p < array.length; p++) {
							sb.delete(0, sb.length());
							
							
						    sb.append(array[p]);
						    
						    exerciciosNewx.add(sb.toString().trim());
						    

						  }
						  for (int z = 0; z < 3; z++) {
							  
							  arrSuporte.add(exerciciosNewx.get(z));
						  }
						  
						  exerciciosNew2.add(arrSuporte);
						}
						
						int chunkSize = 3;
				        AtomicInteger counter = new AtomicInteger();
				        Collection<List<String>> partitionedList = exerciciosNew2.get(0).stream().collect(Collectors.groupingBy(i -> counter.getAndIncrement() / chunkSize)).values();
				        exerciciosNew3.addAll((Collection<? extends ArrayList<String>>) partitionedList);
				        JSONObject my_obj = new JSONObject();
				        JSONArray jsonArray = new JSONArray();
				        for (List<String> list : partitionedList) {
				        	  try {
				        	    jsonArray.put(list);
				        	  } catch (JSONException e7) {
				        	    // Trate a exceção de criação de JSON, por exemplo, lançando uma exceção personalizada
				        	  }
				        	}
				        for (int l = 0; l < partitionedList.size(); l++) {
				        	Integer value = l + 1;
				        	my_obj.put(value.toString(), jsonArray.get(l));
				        }
				        
				        try {
				        	if (table_treino.equals("treino_a")){
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoA(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado A com sucesso!");
				        	} else if (table_treino.equals("treino_b")) {
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoB(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado B com sucesso!");
				        	} else if (table_treino.equals("treino_c")) {
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoC(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado C com sucesso!");
				        	} else if (table_treino.equals("treino_d")) {
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoD(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado D com sucesso!");
				        	} else if (table_treino.equals("treino_e")) {
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoE(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado E com sucesso!");
				        	}
							
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					        
					      
					} else {
						try {
							JSONObject my_obj = new JSONObject();
							my_obj = null;
				        	if (table_treino.equals("treino_a")) {
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoA(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado com sucesso");
				        	} else if (table_treino.equals("treino_b")) {
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoB(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado com sucesso");
				        	} else if (table_treino.equals("treino_c")) {
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoC(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado com sucesso");
				        	} else if (table_treino.equals("treino_d")) {
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoD(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado com sucesso");
				        	} else if (table_treino.equals("treino_e")) {
				        		Aluno alunoUpdated = UpdateController.cadastrarTreinoE(alunoAtual.getMatricula(), my_obj);
				        		JOptionPane.showMessageDialog(null,"Treino cadastrado com sucesso");
				        	}
							
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
			
			
		});
		btnEnviar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEnviar.setFocusPainted(false);
		btnEnviar.setBackground(Color.WHITE);
		btnEnviar.setBounds(716, 517, 121, 40);
		panel.add(btnEnviar);
		
		btnA.addActionListener(e -> {
			table.getSelectionModel().clearSelection();
			celleditable = false;
			table.repaint(); 
			btnEnviar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnEditar.setEnabled(false);
			btnAdicionar.setEnabled(true);
			table_treino = "treino_a";
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_a() != null) {
				exercicios.clear();
				JSONObject treino_a_JSON = alunoAtual.getTreino_a();
				for (int i = 0; i < treino_a_JSON.names().length(); i++) {
					
					String key = treino_a_JSON.names().getString(i);
					
					Integer count = i + 1;
					
					
					if (key.equals(count.toString())) {
						if (treino_a_JSON.getJSONArray(key).length() == 3) {
							
							valor1 = treino_a_JSON.getJSONArray(key).getString(0) + " ";
							valor2 = treino_a_JSON.getJSONArray(key).getString(1) + " ";
							valor3 = treino_a_JSON.getJSONArray(key).getString(2) + " ";
							
							
							exercicios.add(new ArrayList<String>() {{
				                add(valor1);
				                add(valor2);
				                add(valor3);
				                
				            }});
							
							
						} else if(treino_a_JSON.getJSONArray(key).length() == 0) {
							lblSemTreino.setText("Você ainda não tem treino");
					} else if(treino_a_JSON.getJSONArray(key).length() == 2) {
						valor1 = treino_a_JSON.getJSONArray(key).getString(0) + " ";
						valor2 = treino_a_JSON.getJSONArray(key).getString(1) + " ";
						valor3 = " ";
						exercicios.add(new ArrayList<String>() {{
			                add(valor1);
			                add(valor2);
			                add(valor3);
			                
			            }});
						
					}
				}
			}
			
			for (int c = 0; c < exercicios.size(); c++) {
				
				ArrayList<String> treinoAtual = exercicios.get(c);
				
				modelo.addRow(new Object []{
						treinoAtual.get(0),
						treinoAtual.get(1),
						treinoAtual.get(2)
					});	
			}

			} else {
				lblSemTreino.setText("Aluno(a) " + alunoAtual.getNome()+ " ainda não tem treino A");
			}			
		});
		
		btnB.addActionListener(e -> {
			celleditable = false;
			table.repaint(); 
			btnEnviar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnEditar.setEnabled(false);
			btnAdicionar.setEnabled(true);
			table_treino = "treino_b";
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_b() != null) {
				exercicios.clear();
				JSONObject treino_b_JSON = alunoAtual.getTreino_b();
				for (int i = 0; i < treino_b_JSON.names().length(); i++) {
					
					String key = treino_b_JSON.names().getString(i);
					
					Integer count = i + 1;
					
					
					if (key.equals(count.toString())) {
						if (treino_b_JSON.getJSONArray(key).length() == 3) {
							
							valor1 = treino_b_JSON.getJSONArray(key).getString(0) + " ";
							valor2 = treino_b_JSON.getJSONArray(key).getString(1) + " ";
							valor3 = treino_b_JSON.getJSONArray(key).getString(2) + " ";
							
							
							exercicios.add(new ArrayList<String>() {{
				                add(valor1);
				                add(valor2);
				                add(valor3);
				                
				            }});
							
							
						} else if(treino_b_JSON.getJSONArray(key).length() == 0) {
							lblSemTreino.setText("Você ainda não tem treino");
					} else if(treino_b_JSON.getJSONArray(key).length() == 2) {
						valor1 = treino_b_JSON.getJSONArray(key).getString(0) + " ";
						valor2 = treino_b_JSON.getJSONArray(key).getString(1) + " ";
						valor3 = " ";
						exercicios.add(new ArrayList<String>() {{
			                add(valor1);
			                add(valor2);
			                add(valor3);
			                
			            }});
						
					}
				}
			}
			
			for (int c = 0; c < exercicios.size(); c++) {
				
				ArrayList<String> treinoAtual = exercicios.get(c);
				
				modelo.addRow(new Object []{
						treinoAtual.get(0),
						treinoAtual.get(1),
						treinoAtual.get(2)
					});	
			}

			
			} else {
				lblSemTreino.setText("Aluno(a) " + alunoAtual.getNome()+ "ainda não tem treino B");
			}				
		});
		
		btnC.addActionListener(e -> {
			celleditable = false;
			table.repaint(); 
			btnEnviar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnEditar.setEnabled(false);
			btnAdicionar.setEnabled(true);
			table_treino = "treino_c";
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_c() != null) {
				exercicios.clear();
				JSONObject treino_c_JSON = alunoAtual.getTreino_c();
				for (int i = 0; i < treino_c_JSON.names().length(); i++) {
					
					String key = treino_c_JSON.names().getString(i);
					
					Integer count = i + 1;
					
					
					if (key.equals(count.toString())) {
						if (treino_c_JSON.getJSONArray(key).length() == 3) {
							
							valor1 = treino_c_JSON.getJSONArray(key).getString(0) + " ";
							valor2 = treino_c_JSON.getJSONArray(key).getString(1) + " ";
							valor3 = treino_c_JSON.getJSONArray(key).getString(2) + " ";
							
							
							exercicios.add(new ArrayList<String>() {{
				                add(valor1);
				                add(valor2);
				                add(valor3);
				                
				            }});

							
						} else if(treino_c_JSON.getJSONArray(key).length() == 0) {
							lblSemTreino.setText("Você ainda não tem treino");
					} else if(treino_c_JSON.getJSONArray(key).length() == 2) {
						valor1 = treino_c_JSON.getJSONArray(key).getString(0) + " ";
						valor2 = treino_c_JSON.getJSONArray(key).getString(1) + " ";
						valor3 = " ";
						exercicios.add(new ArrayList<String>() {{
			                add(valor1);
			                add(valor2);
			                add(valor3);
			                
			            }});
						
					}
				}
			}
			
			for (int c = 0; c < exercicios.size(); c++) {
				
				ArrayList<String> treinoAtual = exercicios.get(c);
				
				modelo.addRow(new Object []{
						treinoAtual.get(0),
						treinoAtual.get(1),
						treinoAtual.get(2)
					});	
			}

			} else {
				lblSemTreino.setText("Aluno(a) " + alunoAtual.getNome()+ " ainda não tem treino C");
			}				
		});
		
		btnD.addActionListener(e -> {
			celleditable = false;
			table.repaint(); 
			btnEnviar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnEditar.setEnabled(false);
			btnAdicionar.setEnabled(true);
			table_treino = "treino_d";
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_d() != null) {
				exercicios.clear();
				JSONObject treino_d_JSON = alunoAtual.getTreino_d();
				for (int i = 0; i < treino_d_JSON.names().length(); i++) {
					
					String key = treino_d_JSON.names().getString(i);
					
					Integer count = i + 1;
					
					
					if (key.equals(count.toString())) {
						if (treino_d_JSON.getJSONArray(key).length() == 3) {
						
							valor1 = treino_d_JSON.getJSONArray(key).getString(0) + " ";
							valor2 = treino_d_JSON.getJSONArray(key).getString(1) + " ";
							valor3 = treino_d_JSON.getJSONArray(key).getString(2) + " ";
							exercicios.add(new ArrayList<String>() {{
				                add(valor1);
				                add(valor2);
				                add(valor3);
				                
				            }});
						} else if(treino_d_JSON.getJSONArray(key).length() == 0) {
							lblSemTreino.setText("Você ainda não tem treino");
					} else if(treino_d_JSON.getJSONArray(key).length() == 2) {
						valor1 = treino_d_JSON.getJSONArray(key).getString(0) + " ";
						valor2 = treino_d_JSON.getJSONArray(key).getString(1) + " ";
						valor3 = " ";
						exercicios.add(new ArrayList<String>() {{
			                add(valor1);
			                add(valor2);
			                add(valor3);
			                
			            }});
					}
				}
			}
			
			for (int c = 0; c < exercicios.size(); c++) {
				
				ArrayList<String> treinoAtual = exercicios.get(c);
				
				modelo.addRow(new Object []{
						treinoAtual.get(0),
						treinoAtual.get(1),
						treinoAtual.get(2)
					});	
			}
			} else {
				lblSemTreino.setText("Aluno(a) " + alunoAtual.getNome()+ " ainda não tem treino D");
			}				
		});
		
		btnE.addActionListener(e -> {
			modelo.setRowCount(0);
			celleditable = false;
			table.repaint(); 
			btnEnviar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnEditar.setEnabled(false);
			btnAdicionar.setEnabled(true);
			table_treino = "treino_e";
			lblSemTreino.setText(" ");
			modelo.setRowCount(0);
			if (alunoAtual.getTreino_e() != null) {
				exercicios.clear();
				JSONObject treino_e_JSON = alunoAtual.getTreino_e();
				for (int i = 0; i < treino_e_JSON.names().length(); i++) {
					
					String key = treino_e_JSON.names().getString(i);
					
					Integer count = i + 1;
					
					
					if (key.equals(count.toString())) {
						if (treino_e_JSON.getJSONArray(key).length() == 3) {
							
							valor1 = treino_e_JSON.getJSONArray(key).getString(0) + " ";
							valor2 = treino_e_JSON.getJSONArray(key).getString(1) + " ";
							valor3 = treino_e_JSON.getJSONArray(key).getString(2) + " ";
							
							
							exercicios.add(new ArrayList<String>() {{
				                add(valor1);
				                add(valor2);
				                add(valor3);
				                
				            }});
							
							
						} else if(treino_e_JSON.getJSONArray(key).length() == 0) {
							lblSemTreino.setText("Você ainda não tem treino");
					} else if(treino_e_JSON.getJSONArray(key).length() == 2) {
						valor1 = treino_e_JSON.getJSONArray(key).getString(0) + " ";
						valor2 = treino_e_JSON.getJSONArray(key).getString(1) + " ";
						valor3 = " ";
						exercicios.add(new ArrayList<String>() {{
			                add(valor1);
			                add(valor2);
			                add(valor3);
			                
			            }});
						
					}
				}
			}
			
			for (int c = 0; c < exercicios.size(); c++) {
				
				ArrayList<String> treinoAtual = exercicios.get(c);
				
				modelo.addRow(new Object []{
						treinoAtual.get(0),
						treinoAtual.get(1),
						treinoAtual.get(2)
					});	
			}		
			
			} else {
				lblSemTreino.setText("Aluno(a) " + alunoAtual.getNome()+ " ainda não tem treino E");
			}				
		});

	}
	public void getAluno(Aluno alunoLogado) {
		alunoAtual = alunoLogado;
		
	}
}

