package br.edu.ifpe.edu.paulista.tadala_fit.ui.professor;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.edu.ifpe.edu.paulista.tadala_fit.ui.WebCam;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;
import br.edu.ifpe.paulista.tadala_fit.core.UpdateController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class PerfilProfessor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textmatricula;
	private JTextField textnome;
	private JFormattedTextField texttelefone;
	private JTextField textemail;
	private JTextField textCref;
	private JLabel lblfoto;
	private JButton btneditar;
	private JButton btnenviar;
	private Blob imagemBlob;
	private Blob imagemBlobnova;
	private String telefoneT;
	private String emailT;
	private JButton btntirarfoto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PerfilProfessor dialog = new PerfilProfessor();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PerfilProfessor(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja sair do perfil?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				}else {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setBounds(100, 100, 1008, 717);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 79, 157));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblfoto = new JLabel("");
		lblfoto.setIcon(new ImageIcon(PerfilProfessor.class.getResource("/assets_loginFrame/user.png")));
		lblfoto.setBounds(54, 99, 157, 169);
		contentPanel.add(lblfoto);
		
		JLabel lblmatricula = new JLabel("MATRICULA:");
		lblmatricula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblmatricula.setForeground(Color.WHITE);
		lblmatricula.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblmatricula.setBounds(244, 129, 101, 20);
		contentPanel.add(lblmatricula);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNome.setBounds(244, 165, 101, 20);
		contentPanel.add(lblNome);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblTelefone.setBounds(244, 195, 101, 20);
		contentPanel.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmail.setBounds(244, 225, 101, 20);
		contentPanel.add(lblEmail);
		
		JLabel lblCref = new JLabel("CREF:");
		lblCref.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCref.setForeground(Color.WHITE);
		lblCref.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCref.setBounds(244, 261, 101, 20);
		contentPanel.add(lblCref);
		
		textmatricula = new JTextField();
		textmatricula.setForeground(Color.WHITE);
		textmatricula.setFont(new Font("Arial", Font.BOLD, 20));
		textmatricula.setEnabled(false);
		textmatricula.setColumns(10);
		textmatricula.setBorder(null);
		textmatricula.setBackground(new Color(0, 79, 157));
		textmatricula.setBounds(367, 131, 200, 20);
		contentPanel.add(textmatricula);
		
		textnome = new JTextField();
		textnome.setForeground(Color.WHITE);
		textnome.setFont(new Font("Arial", Font.BOLD, 20));
		textnome.setEnabled(false);
		textnome.setColumns(10);
		textnome.setBorder(null);
		textnome.setBackground(new Color(0, 79, 157));
		textnome.setBounds(367, 167, 364, 20);
		contentPanel.add(textnome);
		
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
			texttelefone = new JFormattedTextField(mascaraTelefone);
			} catch (ParseException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
		texttelefone.setForeground(Color.WHITE);
		texttelefone.setFont(new Font("Arial", Font.BOLD, 20));
		texttelefone.setEnabled(false);
		texttelefone.setColumns(10);
		texttelefone.setBorder(null);
		texttelefone.setBackground(new Color(0, 79, 157));
		texttelefone.setBounds(367, 197, 258, 20);
		contentPanel.add(texttelefone);
		
		textemail = new JTextField();
		textemail.setEnabled(false);
		textemail.setForeground(Color.WHITE);
		textemail.setFont(new Font("Arial", Font.BOLD, 20));
		textemail.setColumns(10);
		textemail.setBorder(null);
		textemail.setBackground(new Color(0, 79, 157));
		textemail.setBounds(355, 227, 349, 20);
		contentPanel.add(textemail);
		
		textCref = new JTextField();
		textCref.setForeground(Color.WHITE);
		textCref.setFont(new Font("Arial", Font.BOLD, 20));
		textCref.setEnabled(false);
		textCref.setColumns(10);
		textCref.setBorder(null);
		textCref.setBackground(new Color(0, 79, 157));
		textCref.setBounds(355, 263, 157, 20);
		contentPanel.add(textCref);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 65, 130));
		panel_2.setBounds(23, 350, 956, 10);
		contentPanel.add(panel_2);
		
		btneditar = new JButton("Alterar Informações");
		btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texttelefone.setBorder( new TitledBorder("") );
				textemail.setBorder( new TitledBorder("") );
				texttelefone.setEnabled(true);
				textemail.setEnabled(true);
				btntirarfoto.setVisible(true);
				btntirarfoto.setEnabled(true);
				btnenviar.setEnabled(true);
				btnenviar.setVisible(true);
				btneditar.setVisible(false);
				btneditar.setEnabled(false);
			}
		});
		
		btneditar.setForeground(Color.WHITE);
		btneditar.setFont(new Font("Arial", Font.BOLD, 16));
		btneditar.setFocusPainted(false);
		btneditar.setBackground(new Color(0, 69, 130));
		btneditar.setBounds(274, 575, 200, 40);
		contentPanel.add(btneditar);
		
		btnenviar = new JButton("Submeter");
		btnenviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnenviar.setVisible(false);
				btnenviar.setEnabled(false);				
				texttelefone.setEnabled(false);
				textemail.setEnabled(false);
				texttelefone.setBorder(null);
				textemail.setBorder(null);
				try {
					String telefone = texttelefone.getText();
					String email = textemail.getText();
					Integer matricula = Integer.parseInt(textmatricula.getText());
					if (telefone.equals(telefoneT) && email.equals(emailT)&& imagemBlob.equals(imagemBlobnova)){
						JOptionPane.showMessageDialog(null,"Atualize pelo menos um dado para realizar a alteração");
						btneditar.setVisible(true);
						btneditar.setEnabled(true);
						btntirarfoto.setVisible(false);
						btntirarfoto.setEnabled(false);
					}else {
						UpdateController.UpdateProfessor(telefone,email,matricula,imagemBlobnova);
						btneditar.setVisible(true);
						btneditar.setEnabled(true);
						btntirarfoto.setVisible(false);
						btntirarfoto.setEnabled(false);
					}
				} catch (NumberFormatException e5) {
					texttelefone.setBorder( new TitledBorder("") );
					texttelefone.setEnabled(true);
					btnenviar.setEnabled(true);
					btnenviar.setVisible(true);
					JOptionPane.showMessageDialog(null,"Preencha o campo TELEFONE corretamente com números válidos");
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
					e4.printStackTrace();
			
				}
			}
		});
		
		btnenviar.setVisible(false);
		btnenviar.setEnabled(false);
		textemail.setEnabled(false);
		texttelefone.setEnabled(false);

		textemail.setBorder(null);
		texttelefone.setBorder(null);
		btnenviar.setEnabled(false);
		btnenviar.setForeground(Color.WHITE);
		btnenviar.setFont(new Font("Arial", Font.BOLD, 16));
		btnenviar.setFocusPainted(false);
		btnenviar.setBackground(new Color(0, 69, 130));
		btnenviar.setBounds(504, 575, 200, 40);
		btnenviar.setVisible(false);
		contentPanel.add(btnenviar);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(PerfilProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(22, 476, 200, 130);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2023 Tadalafit All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(342, 630, 342, 40);
		contentPanel.add(lblNewLabel_2);
		
		btntirarfoto = new JButton("Tirar Foto");
		btntirarfoto.setVisible(false);
		btntirarfoto.setEnabled(false);
		btntirarfoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WebCam webcam = new WebCam();
				if(webcam.getWebcam() != null) {
					webcam.setModal(true);
					webcam.setVisible(true);
					lblfoto.setIcon(new ImageIcon(WebCam.carregarFoto()));
					try {
						imagemBlobnova = new javax.sql.rowset.serial.SerialBlob(WebCam.imgemBlob());
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btntirarfoto.setBorder(null);
		btntirarfoto.setBounds(79, 265, 93, 20);
		contentPanel.add(btntirarfoto);
	}

	public void getProfessor(Professor professorLogado) throws IOException {		
		textmatricula.setText(Integer.toString(professorLogado.getMatricula()));
		textnome.setText(professorLogado.getNome());
		texttelefone.setText(professorLogado.getTelefone());
		textemail.setText(professorLogado.getEmail());
		textCref.setText(professorLogado.getCref());
		telefoneT = professorLogado.getTelefone();
		emailT = professorLogado.getEmail();
		Blob foto = professorLogado.getImage();
		if (foto != null) {
			try {
			byte[] data = foto.getBytes(1,(int) foto.length());
			InputStream is = new ByteArrayInputStream(data);
			BufferedImage image = ImageIO.read(is);
			BufferedImage resizedImage = new BufferedImage(150, 150, image.getType());
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(image, 0, 0, 150, 150, null);
			g.dispose();
			lblfoto.setIcon(new ImageIcon(resizedImage));
			imagemBlob = new javax.sql.rowset.serial.SerialBlob(foto);
			imagemBlobnova = new javax.sql.rowset.serial.SerialBlob(foto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} else {
			
		}
		
		
	}
}
