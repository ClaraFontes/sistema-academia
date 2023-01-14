package br.edu.ifpe.edu.paulista.tadala_fit.ui;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import br.edu.ifpe.paulista.tadala_fit.core.AccessController;
import br.edu.ifpe.paulista.tadala_fit.core.Administrador;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JCheckBox;
public class FrameLogin {

	protected JFrame framelogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblloginmensagem = new JLabel("");

	

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin window = new FrameLogin();
					window.framelogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameLogin() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framelogin = new JFrame();
		framelogin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja fechar a aplicação?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					framelogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					framelogin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	
		framelogin.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		framelogin.getContentPane().setFont(new Font("04b", Font.PLAIN, 11));
		framelogin.getContentPane().setBackground(new Color(0, 79, 157));
		framelogin.setBackground(new Color(0, 79, 157));
		framelogin.getContentPane().setForeground(UIManager.getColor("Button.background"));
		framelogin.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/assets_loginFrame/Logotipo academia personal trainner (1).png")));
		framelogin.setForeground(new Color(255, 255, 255));
		framelogin.setFont(new Font("Arial Black", Font.PLAIN, 12));
		framelogin.setResizable(false);
		framelogin.setTitle("TadalaFit - Versão - 1.0");
		framelogin.setBounds(100, 100, 1024, 768);
		framelogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 65, 130));
		panel.setBounds(331, 352, 324, 54);
		framelogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("User")) {
					txtUsername.setText("");
				}
				else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("User");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUsername.setText("User");
		txtUsername.setBounds(10, 11, 239, 32);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameLogin.class.getResource("/assets_loginFrame/icons8-user-30.png")));
		lblNewLabel.setBounds(272, 11, 30, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 65, 130));
		panel_1.setBounds(331, 441, 324, 54);
		framelogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPassword.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getPassword().toString().equals("")) {
					txtPassword.setText("Senha");
					

				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtPassword.setText("Senha");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPassword.setBounds(10, 11, 239, 32);
		panel_1.add(txtPassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrameLogin.class.getResource("/assets_loginFrame/icons8-forgot-password-30.png")));
		lblNewLabel_1.setBounds(272, 11, 30, 32);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabelI = new JLabel("");
		lblNewLabelI.setIcon(new ImageIcon(FrameLogin.class.getResource("/assets_loginFrame/Logotipo_academia_personal_trainner__1_-removebg-preview.png")));
		lblNewLabelI.setBounds(255, 84, 500, 295);
		framelogin.getContentPane().add(lblNewLabelI);
		lblloginmensagem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JCheckBox chckbxAdm = new JCheckBox("ADMIN");
		chckbxAdm.setBounds(402, 513, 74, 22);
		framelogin.getContentPane().add(chckbxAdm);
		
		JCheckBox chckbxAluno = new JCheckBox("ALUNO");
		chckbxAluno.setBounds(511, 513, 74, 22);
		framelogin.getContentPane().add(chckbxAluno);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String user = txtUsername.getText();
				String password = new String(txtPassword.getPassword());
				
				try {
					if (chckbxAluno.isSelected() && chckbxAdm.isSelected()) {
						lblloginmensagem.setText("Marque apenas uma caixa.");
					} else if (!chckbxAluno.isSelected() && !chckbxAdm.isSelected()) {
						lblloginmensagem.setText("Marque alguma caixa.");
					} else if (chckbxAdm.isSelected()) {
						Administrador admLogado = AccessController.loginAdm(user, password);
						if (admLogado != null) {
							JOptionPane.showMessageDialog (null, "Login Efetuado");
							FrameHome fh = new FrameHome();
							fh.framehome.setVisible(true);
							fh.getAdm(admLogado);
							framelogin.dispose();
					} else {
						lblloginmensagem.setText("Usuário ou senha incorretos.");
					}
					
					} else if (chckbxAluno.isSelected()) { 
						Aluno alunoLogado = AccessController.loginAluno(user, password);
						if (alunoLogado != null) {
							JOptionPane.showMessageDialog (null, "Login Efetuado");
							FrameHomeAluno fa = new FrameHomeAluno();
							fa.framehomealuno.setVisible(true);
							fa.getAluno(alunoLogado);
							framelogin.dispose();
					} else {
						lblloginmensagem.setText("Usuário ou senha incorretos.");
						}
						
						}
					
					/*if (chckbxAluno.isSelected() && chckbxAdm.isSelected()) {
						lblloginmensagem.setText("Marque apenas uma caixa.");
					}
					
					if (chckbxAluno.isSelected() || chckbxAdm.isSelected() == false) {
						lblloginmensagem.setText("Marque alguma caixa.");
					}*/
				} catch (ClassNotFoundException | SQLException e1) {
					lblloginmensagem.setText("Erro inesperado, tente novamente.");
				System.out.println(e1.getMessage());
				} catch (RuntimeException e2) {
					lblloginmensagem.setText("Campos vazios ou usuário e senha incorretos.");
					System.out.println(e2);
				} catch (Exception e3) {
					System.out.println(e3);
				} 

		  }
		});
		
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(402, 567, 184, 40);
		framelogin.getContentPane().add(btnNewButton);
		

		
		lblloginmensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblloginmensagem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblloginmensagem.setBounds(295, 619, 414, 22);
		framelogin.getContentPane().add(lblloginmensagem);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(348, 678, 324, 40);
		framelogin.getContentPane().add(lblNewLabel_2);
		
		
	}
}