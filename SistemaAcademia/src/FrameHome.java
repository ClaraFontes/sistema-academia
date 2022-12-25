import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;

public class FrameHome {

	protected JFrame framehome;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHome window = new FrameHome();
					window.framehome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framehome = new JFrame();
		framehome.setResizable(false);
		framehome.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja fechar a aplicação?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					framehome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					framehome.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		framehome.setBackground(new Color(0, 128, 128));
		framehome.getContentPane().setBackground(new Color(0, 128, 128));
		framehome.setTitle("TadalaFit - Versão - 1.0");
		framehome.setIconImage(Toolkit.getDefaultToolkit().getImage(FrameHome.class.getResource("/assets_loginFrame/Logotipo academia personal trainner (1).png")));
		framehome.setBounds(100, 100, 1024, 720);
		framehome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framehome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 100));
		panel.setBounds(10, 11, 215, 659);
		framehome.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameHome.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel.setBounds(10, 11, 178, 159);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar Aluno");
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameCadastro fc = new FrameCadastro();
				fc.framecadastro.setVisible(true);
	
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(45, 189, 129, 33);
		panel.add(btnNewButton);
		
		JButton btnConsulta = new JButton("Consultar Aluno");
		btnConsulta.setBounds(45, 281, 129, 33);
		panel.add(btnConsulta);
		
		JButton btnConsulta_1 = new JButton("......");
		btnConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsulta_1.setBorder(UIManager.getBorder("Button.border"));
		btnConsulta_1.setBounds(45, 363, 129, 33);
		panel.add(btnConsulta_1);
		
		JButton btnConsulta_1_1 = new JButton("Deslogar");
		btnConsulta_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameLogin fl = new FrameLogin();
				fl.framelogin.setVisible(true);
				framehome.dispose();
			}
		});
		btnConsulta_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsulta_1_1.setBounds(45, 441, 129, 33);
		panel.add(btnConsulta_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(391, 630, 324, 40);
		framehome.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(new Rectangle(0, 0, 100, 1000));
		lblNewLabel_1.setIcon(new ImageIcon(FrameHome.class.getResource("/assets_loginFrame/Logotipo_academia_personal_trainner__1_-removebg-preview.png")));
		lblNewLabel_1.setBounds(303, 101, 481, 442);
		framehome.getContentPane().add(lblNewLabel_1);
		
	}
}
