package br.edu.ifpe.edu.paulista.tadala_fit.ui.aluno;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

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
import java.text.ParseException;
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

public class EvolucaoAluno extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private final JPanel contentPanel = new JPanel();
	public JTable table;
	protected Aluno alunoAtual;
	private Object matricula;
	private String nome;

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
					EvolucaoAluno dialog = new EvolucaoAluno();
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
	public EvolucaoAluno() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EvolucaoAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setInheritsPopupMenu(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		scrollPane.setBounds(120, 76, 592, 592);
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
		                int coluna1 = 1;
		                nome = (String) model.getValueAt(linha,coluna1);
		            }
		        }
		    }
		});
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBounds(213, 93, 1, 1);
		table.setFont(new Font("Arial", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ano", "Mês", "Altura", "Peso", "Bf"
			}
		) {
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
		logo.setIcon(new ImageIcon(EvolucaoAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		logo.setBounds(752, 82, 200, 139);
		panel.add(logo);
		
		JButton btnConsultarEvoluo = new JButton("Consultar Evolução");
		btnConsultarEvoluo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								"Ano", "Mês", "Altura", "Peso", "Bf"
						}
					));
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				ArrayList<Aluno> aluno;
				if (modelo.getRowCount() != 0) {
					modelo.setRowCount(0);
				}
				
				JSONObject my_obj = new JSONObject();
				JSONObject my_obj1 = new JSONObject();
				JSONObject my_obj2 = new JSONObject();
				JSONArray jsonArray = new JSONArray();
				JSONArray jsonArray1 = new JSONArray();
				JSONArray jsonArray2 = new JSONArray();
				JSONArray jsonArray3 = new JSONArray();
				
				my_obj = alunoAtual.getEvolucao();
				jsonArray = my_obj.names();
				
				
				for (int i = 0; i < my_obj.length(); i++) {
					String key = jsonArray.getString(i);
					jsonArray1 = my_obj.getJSONArray(key);
					for (int z = 0; z < jsonArray1.length(); z++) {
						my_obj2 = jsonArray1.getJSONObject(z);
						jsonArray2 = my_obj2.names();
						String key2 = jsonArray2.getString(0); 
						
							jsonArray3 = my_obj2.getJSONArray(key2);
							
						String mes = "";
						if (key2.equals("01")) {
							mes = "janeiro";
						} else if(key2.equals("02")) {
							mes = "feveiro";
						} else if(key2.equals("03")) {
							mes = "março";
						} else if(key2.equals("04")) {
							mes = "abril";
						} else if(key2.equals("05")) {
							mes = "maio";
						} else if(key2.equals("06")) {
							mes = "junho";
						} else if(key2.equals("07")) {
							mes = "julho";
						} else if(key2.equals("08")) {
							mes = "agosto";
						} else if(key2.equals("09")) {
							mes = "setembro";
						} else if(key2.equals("10")) {
							mes = "outubro";
						} else if(key2.equals("11")) {
							mes = "novembro";
						} else if(key2.equals("12")) {
							mes = "dezembro";
						}
							
							
							
							
							
							modelo.addRow(new Object[]{
									key,
									mes,
									jsonArray3.get(0),
									jsonArray3.get(1),
									jsonArray3.get(2)
							});
						
					}
					
				}		
			}
		});
		btnConsultarEvoluo.setFont(new Font("Arial", Font.BOLD, 13));
		btnConsultarEvoluo.setBackground(Color.WHITE);
		btnConsultarEvoluo.setBounds(788, 335, 174, 36);
		panel.add(btnConsultarEvoluo);
	}
	
	public void getAluno(Aluno alunoLogado) {
		alunoAtual = alunoLogado;
		
	}
}