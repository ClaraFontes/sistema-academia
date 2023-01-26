package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;
import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import br.edu.ifpe.paulista.tadala_fit.core.Aluno;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

public class TreinoAluno extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton btnA;
	protected JTextArea txttreinos;
	protected JTextField txtboasvindas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreinoAluno dialog = new TreinoAluno();
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
	public TreinoAluno() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setBounds(320, 663, 342, 40);
		panel.add(lblNewLabel_2);
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnB.setFocusPainted(false);
		btnB.setBackground(Color.WHITE);
		btnB.setBounds(320, 129, 121, 40);
		panel.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnC.setFocusPainted(false);
		btnC.setBackground(Color.WHITE);
		btnC.setBounds(451, 129, 121, 40);
		panel.add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnD.setFocusPainted(false);
		btnD.setBackground(Color.WHITE);
		btnD.setBounds(585, 129, 121, 40);
		panel.add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnE.setFocusPainted(false);
		btnE.setBackground(Color.WHITE);
		btnE.setBounds(716, 129, 121, 40);
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
		
		txttreinos = new JTextArea();
		txttreinos.setBounds(134, 34, 376, 388);
		panel_1.add(txttreinos);
		txttreinos.setForeground(new Color(255, 255, 255));
		txttreinos.setBackground(new Color(0, 65, 130));
		txttreinos.setFont(new Font("Arial Black", Font.BOLD, 19));
		txttreinos.setDisabledTextColor(new Color(0, 0, 0));
		txttreinos.setEditable(false);
		
		JLabel lblNewLabel_3 = new JLabel("Bem vindo(a):");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(189, 60, 95, 14);
		panel.add(lblNewLabel_3);
		
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
		
		btnA = new JButton("A");
		btnA.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnA.setFocusPainted(false);
		btnA.setBackground(Color.WHITE);
		btnA.setBounds(189, 129, 121, 40);
		panel.add(btnA);

	}
		public void getAluno(Aluno alunoLogado) {
			txtboasvindas.setText(alunoLogado.getNome());
			btnA.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//txttreinos.setText(alunoLogado.getTreino_a());
					//System.out.println(alunoLogado.getTreino_a());
				}
			});
		}
}
