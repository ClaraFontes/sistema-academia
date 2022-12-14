import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JList;
import java.awt.Checkbox;
import javax.swing.JCheckBoxMenuItem;

public class FrameLogin {

	private JFrame frmlogintadalafit;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblloginmensagem = new JLabel("");
	private Checkbox admincheckbox = new Checkbox("      Admin");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin window = new FrameLogin();
					window.frmlogintadalafit.setVisible(true);
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
		frmlogintadalafit = new JFrame();
		frmlogintadalafit.getContentPane().setFont(new Font("04b", Font.PLAIN, 11));
		frmlogintadalafit.getContentPane().setBackground(new Color(255, 255, 255));
		frmlogintadalafit.setBackground(new Color(0, 64, 64));
		frmlogintadalafit.getContentPane().setForeground(UIManager.getColor("Button.background"));
		frmlogintadalafit.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/assets_loginFrame/tadalafit.png")));
		frmlogintadalafit.setForeground(new Color(255, 255, 255));
		frmlogintadalafit.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmlogintadalafit.setResizable(false);
		frmlogintadalafit.setTitle("TadalaFit - Versão - 1.0");
		frmlogintadalafit.setBounds(100, 100, 1024, 768);
		frmlogintadalafit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmlogintadalafit.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(331, 352, 324, 54);
		frmlogintadalafit.getContentPane().add(panel);
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
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setBounds(331, 441, 324, 54);
		frmlogintadalafit.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPassword.setEchoChar('●');
				txtPassword.setText("");
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
		lblNewLabelI.setIcon(new ImageIcon(FrameLogin.class.getResource("/assets_loginFrame/tadalafit.png")));
		lblNewLabelI.setBounds(255, 84, 500, 295);
		frmlogintadalafit.getContentPane().add(lblNewLabelI);
		
		
		admincheckbox.setBackground(UIManager.getColor("Button.background"));
		admincheckbox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		admincheckbox.setForeground(new Color(0, 0, 0));
		admincheckbox.setBounds(449, 530, 95, 22);
		frmlogintadalafit.getContentPane().add(admincheckbox);
		lblloginmensagem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtUsername.getText().equals("") || txtUsername.getText().equals("User")||
				txtPassword.getText().equals("") || txtUsername.getText().equals("Senha")){
					lblloginmensagem.setText("Preencha todos os campos!!");
				}
				if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin") && admincheckbox.getState()) {
					JOptionPane.showMessageDialog(null, ("Login Efetuado"));
					lblloginmensagem.setText("");
			    }
				else if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin") && admincheckbox.getState() == false){
					lblloginmensagem.setText("Admin Marque a Checkbox!");
			
		        }
		  }
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(434, 558, 125, 40);
		frmlogintadalafit.getContentPane().add(btnNewButton);
		

		
		lblloginmensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblloginmensagem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblloginmensagem.setBounds(289, 502, 414, 22);
		frmlogintadalafit.getContentPane().add(lblloginmensagem);
	}
}
