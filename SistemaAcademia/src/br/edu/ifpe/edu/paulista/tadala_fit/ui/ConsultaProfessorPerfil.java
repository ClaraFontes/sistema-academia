package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;
import br.edu.ifpe.paulista.tadala_fit.core.ReadController;
import br.edu.ifpe.paulista.tadala_fit.core.UpdateController;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class ConsultaProfessorPerfil extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textmatricula;
	private JTextField textnome;
	private JTextField texttelefone;
	private JTextField textemail;
	private JTextField textcref;
	private Blob imagemBlob;
	private Blob imagemNova;
	private JButton btnenviar;
	private JButton btneditar;
	private Professor pesquisaProfessor;
	private JButton btnfoto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Integer matricula = null;
			String nome = null;
			ConsultaProfessorPerfil dialog = new ConsultaProfessorPerfil(matricula, nome);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaProfessorPerfil(Integer matricula, String nome) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaProfessorPerfil.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		setBounds(100, 100, 1024, 720);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 79, 157));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblfoto = new JLabel("");
		lblfoto.setIcon(new ImageIcon(ConsultaProfessorPerfil.class.getResource("/assets_loginFrame/user.png")));
		lblfoto.setBounds(47, 102, 157, 169);
		contentPanel.add(lblfoto);
		
		btnfoto = new JButton("Tirar Foto");
		btnfoto.setVisible(false);
		btnfoto.setEnabled(false);
		btnfoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WebCam webcam = new WebCam();
				if(webcam.getWebcam() != null) {
					webcam.setModal(true);
					webcam.setVisible(true);
					lblfoto.setIcon(new ImageIcon(WebCam.carregarFoto()));
					imagemNova = WebCam.imgemBlob();
				}
			}
		});
		btnfoto.setBorder(null);
		btnfoto.setBounds(78, 269, 93, 20);
		contentPanel.add(btnfoto);
		
		JLabel lblmatricula = new JLabel("MATRICULA:");
		lblmatricula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblmatricula.setForeground(Color.WHITE);
		lblmatricula.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblmatricula.setBounds(269, 137, 101, 20);
		contentPanel.add(lblmatricula);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNome.setBounds(269, 173, 101, 20);
		contentPanel.add(lblNome);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblTelefone.setBounds(269, 203, 101, 20);
		contentPanel.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmail.setBounds(269, 233, 101, 20);
		contentPanel.add(lblEmail);
		
		JLabel lblCref = new JLabel("CREF:");
		lblCref.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCref.setForeground(Color.WHITE);
		lblCref.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCref.setBounds(269, 269, 101, 20);
		contentPanel.add(lblCref);
		
		textmatricula = new JTextField();
		textmatricula.setText("0");
		textmatricula.setForeground(Color.WHITE);
		textmatricula.setFont(new Font("Arial", Font.BOLD, 20));
		textmatricula.setEnabled(false);
		textmatricula.setColumns(10);
		textmatricula.setBorder(null);
		textmatricula.setBackground(new Color(0, 79, 157));
		textmatricula.setBounds(380, 138, 139, 20);
		contentPanel.add(textmatricula);
		
		textnome = new JTextField();
		textnome.setText((String) null);
		textnome.setForeground(Color.WHITE);
		textnome.setFont(new Font("Arial", Font.BOLD, 20));
		textnome.setEnabled(false);
		textnome.setColumns(10);
		textnome.setBorder(null);
		textnome.setBackground(new Color(0, 79, 157));
		textnome.setBounds(380, 169, 345, 20);
		contentPanel.add(textnome);
		
		texttelefone = new JTextField();
		texttelefone.setText((String) null);
		texttelefone.setForeground(Color.WHITE);
		texttelefone.setFont(new Font("Arial", Font.BOLD, 16));
		texttelefone.setEnabled(false);
		texttelefone.setColumns(10);
		texttelefone.setBorder(null);
		texttelefone.setBackground(new Color(0, 79, 157));
		texttelefone.setBounds(381, 202, 300, 20);
		contentPanel.add(texttelefone);
		
		textemail = new JTextField();
		textemail.setText((String) null);
		textemail.setForeground(Color.WHITE);
		textemail.setFont(new Font("Arial", Font.BOLD, 16));
		textemail.setEnabled(false);
		textemail.setColumns(10);
		textemail.setBorder(null);
		textemail.setBackground(new Color(0, 79, 157));
		textemail.setBounds(380, 233, 318, 20);
		contentPanel.add(textemail);
		
		textcref = new JTextField();
		textcref.setText("0");
		textcref.setForeground(Color.WHITE);
		textcref.setFont(new Font("Arial", Font.BOLD, 20));
		textcref.setEnabled(false);
		textcref.setColumns(10);
		textcref.setBorder(null);
		textcref.setBackground(new Color(0, 79, 157));
		textcref.setBounds(380, 271, 139, 20);
		contentPanel.add(textcref);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 65, 130));
		panel_2.setBounds(29, 364, 956, 10);
		contentPanel.add(panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(ConsultaProfessorPerfil.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(29, 529, 200, 130);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2023 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setBounds(339, 619, 342, 40);
		contentPanel.add(lblNewLabel_2);
		
		btnenviar = new JButton("Submeter");
		btnenviar.setVisible(false);
		btnenviar.setEnabled(false);
		btnenviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texttelefone.setBorder(null);
				textemail.setBorder(null);
				try {
					String telefone = texttelefone.getText();
					String email = textemail.getText();
					Integer matricula = Integer.parseInt(textmatricula.getText());
					String telefoneT = pesquisaProfessor.getTelefone();
					String emailT = pesquisaProfessor.getEmail();
					if (telefone.equals(telefoneT) && email.equals(emailT) && imagemBlob.equals(imagemNova)){
						JOptionPane.showMessageDialog(null,"Mude pelo menos um dado para realizar o update");
						btneditar.setVisible(true);
						btneditar.setEnabled(true);
					}else{
						UpdateController.UpdateProfessor(telefone, email, matricula, imagemNova);
						btneditar.setVisible(true);
						btneditar.setEnabled(true);
						btnenviar.setVisible(false);
						btnenviar.setEnabled(false);
					}
				} catch (RuntimeException e1) {
					e1.printStackTrace();
					texttelefone.setBorder( new TitledBorder("") );
					textemail.setBorder( new TitledBorder("") );
					texttelefone.setEnabled(true);
					textemail.setEnabled(true);
					btnenviar.setEnabled(true);
					btnenviar.setVisible(true);
					JOptionPane.showMessageDialog(null,"Preencha todos os campos");
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				} catch (SQLException e3) {
					e3.printStackTrace();
				} catch (Exception e4) {
					JOptionPane.showMessageDialog(null,"Preencha os campos corretamente");
			
				}
			}
		});
		btnenviar.setForeground(Color.WHITE);
		btnenviar.setFont(new Font("Arial", Font.BOLD, 16));
		btnenviar.setFocusPainted(false);
		btnenviar.setBackground(new Color(0, 69, 130));
		btnenviar.setBounds(525, 569, 200, 40);
		contentPanel.add(btnenviar);
		
		btneditar = new JButton("Alterar Informações");
		btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texttelefone.setBorder( new TitledBorder("") );
				textemail.setBorder( new TitledBorder("") );
				texttelefone.setEnabled(true);
				textemail.setEnabled(true);
				btnenviar.setEnabled(true);
				btnenviar.setVisible(true);
				btneditar.setVisible(false);
				btneditar.setEnabled(false);
				btnfoto.setEnabled(true);
				btnfoto.setVisible(true);
			}
		});
		btneditar.setForeground(Color.WHITE);
		btneditar.setFont(new Font("Arial", Font.BOLD, 16));
		btneditar.setFocusPainted(false);
		btneditar.setBackground(new Color(0, 69, 130));
		btneditar.setBounds(282, 569, 200, 40);
		contentPanel.add(btneditar);
		
		try {
			pesquisaProfessor = ReadController.getProfessorFiltered(matricula, nome);
			textmatricula.setText(Integer.toString(pesquisaProfessor.getMatricula()));
			textnome.setText(pesquisaProfessor.getNome());
			texttelefone.setText(pesquisaProfessor.getTelefone());
			textemail.setText(pesquisaProfessor.getEmail());
			textcref.setText(pesquisaProfessor.getCref());
			Blob foto = pesquisaProfessor.getImage();
			if (foto != null) {
				byte[] data = foto.getBytes(1,(int) foto.length());
				InputStream is = new ByteArrayInputStream(data);
				BufferedImage image = ImageIO.read(is);
				BufferedImage resizedImage = new BufferedImage(150, 150, image.getType());
				Graphics2D g = resizedImage.createGraphics();
				g.drawImage(image, 0, 0, 150, 150, null);
				g.dispose();
				lblfoto.setIcon(new ImageIcon(resizedImage));
				imagemBlob = new javax.sql.rowset.serial.SerialBlob(foto);
				imagemNova = new javax.sql.rowset.serial.SerialBlob(foto);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
