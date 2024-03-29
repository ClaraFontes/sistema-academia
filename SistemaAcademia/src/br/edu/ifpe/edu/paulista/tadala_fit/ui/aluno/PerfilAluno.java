package br.edu.ifpe.edu.paulista.tadala_fit.ui.aluno;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.SwingConstants;
import br.edu.ifpe.edu.paulista.tadala_fit.ui.WebCam;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.UpdateController;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PerfilAluno extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel perfilaluno = new JPanel();
	protected JTextField txtnome;
	protected JFormattedTextField txttelefone;
	protected JTextField txtdata;
	protected JFormattedTextField txtpeso;
	protected JTextField txtcomorbidade;
	protected JTextField txtcpf;
	protected JTextField txtemail;
	protected JFormattedTextField txtaltura;
	protected JFormattedTextField txtbf;
	protected JTextField txtstatus;
	private JTextField txtmatricula;
	private JButton btneditar;
	private JButton btnenviar;
	private JLabel lblfoto;
	private Blob imagemBlob;
	private Blob imagemBlobnova;
	private JButton btnfoto;
	private String telefoneT;
	private String emailT;
	private Double alturaT;
	private Double pesoT;
	private Double bfT;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try { 
			PerfilAluno dialog = new PerfilAluno();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public PerfilAluno() throws ParseException{
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
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PerfilAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		setTitle("Taladafit - Versão 1.0");
		setResizable(false);
		getContentPane().setBackground(new Color(0, 79, 157));
		setBounds(100, 100, 1024, 720);
		getContentPane().setLayout(null);
		perfilaluno.setBorder(null);
		perfilaluno.setBounds(0, 0, 1008, 681);
		perfilaluno.setBackground(new Color(0, 79, 157));
		getContentPane().add(perfilaluno);
		perfilaluno.setLayout(null);
		
		lblfoto = new JLabel("");
		lblfoto.setIcon(new ImageIcon(PerfilAluno.class.getResource("/assets_loginFrame/user.png")));
		lblfoto.setBounds(47, 102, 157, 169);
		perfilaluno.add(lblfoto);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 65, 130));
		panel_2.setBounds(23, 350, 956, 10);
		perfilaluno.add(panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(PerfilAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(23, 526, 200, 130);
		perfilaluno.add(lblNewLabel_1_1);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblTelefone.setBounds(214, 148, 101, 24);
		perfilaluno.add(lblTelefone);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(242, 117, 72, 20);
		perfilaluno.add(lblNewLabel_1);
		
		txtnome = new JTextField();
		txtnome.setBorder(null);
		txtnome.setEnabled(false);
		txtnome.setBackground(new Color(0, 79, 157));
		txtnome.setForeground(new Color(255, 255, 255));
		txtnome.setFont(new Font("Arial", Font.BOLD, 20));
		txtnome.setBounds(324, 118, 139, 20);
		perfilaluno.add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setBounds(342, 630, 342, 40);
		perfilaluno.add(lblNewLabel_2);
		
		JLabel lblDataNasc = new JLabel("DATA NASC:");
		lblDataNasc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDataNasc.setBounds(214, 186, 101, 24);
		perfilaluno.add(lblDataNasc);
		
		JLabel lblPeso = new JLabel("PESO:");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPeso.setBounds(243, 221, 72, 24);
		perfilaluno.add(lblPeso);
		
		JLabel lblComorbidade = new JLabel("COMORBIDADE:");
		lblComorbidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComorbidade.setForeground(Color.WHITE);
		lblComorbidade.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblComorbidade.setBounds(202, 255, 113, 24);
		perfilaluno.add(lblComorbidade);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCpf.setBounds(479, 148, 72, 24);
		perfilaluno.add(lblCpf);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmail.setBounds(479, 185, 72, 26);
		perfilaluno.add(lblEmail);
		
		JLabel lblAltura = new JLabel("ALTURA:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblAltura.setBounds(479, 221, 72, 24);
		perfilaluno.add(lblAltura);
		
		JLabel lblBf = new JLabel("BF:");
		lblBf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBf.setForeground(Color.WHITE);
		lblBf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblBf.setBounds(656, 221, 72, 24);
		perfilaluno.add(lblBf);
		
		JLabel lblSatus = new JLabel("STATUS:");
		lblSatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSatus.setForeground(Color.WHITE);
		lblSatus.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblSatus.setBounds(300, 417, 139, 24);
		perfilaluno.add(lblSatus);
		
		MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
		txttelefone = new JFormattedTextField(mascaraTelefone);
		txttelefone.setForeground(Color.WHITE);
		txttelefone.setFont(new Font("Arial", Font.BOLD, 16));
		txttelefone.setEnabled(false);
		txttelefone.setColumns(10);
		txttelefone.setBorder(null);
		txttelefone.setBackground(new Color(0, 79, 157));
		txttelefone.setBounds(325, 151, 139, 20);
		perfilaluno.add(txttelefone);
		
		txtdata = new JTextField();
		txtdata.setForeground(Color.WHITE);
		txtdata.setFont(new Font("Arial", Font.BOLD, 16));
		txtdata.setEnabled(false);
		txtdata.setColumns(10);
		txtdata.setBorder(null);
		txtdata.setBackground(new Color(0, 79, 157));
		txtdata.setBounds(324, 189, 139, 20);
		perfilaluno.add(txtdata);
		
		MaskFormatter mascaraPeso = new MaskFormatter("*****");
		mascaraPeso.setValidCharacters("0123456789. ");
		txtpeso = new JFormattedTextField(mascaraPeso);
		txtpeso.setForeground(Color.WHITE);
		txtpeso.setFont(new Font("Arial", Font.BOLD, 16));
		txtpeso.setEnabled(false);
		txtpeso.setColumns(10);
		txtpeso.setBorder(null);
		txtpeso.setBackground(new Color(0, 79, 157));
		txtpeso.setBounds(324, 224, 72, 20);
		perfilaluno.add(txtpeso);
		
		txtcomorbidade = new JTextField();
		txtcomorbidade.setForeground(Color.WHITE);
		txtcomorbidade.setFont(new Font("Arial", Font.BOLD, 16));
		txtcomorbidade.setEnabled(false);
		txtcomorbidade.setColumns(10);
		txtcomorbidade.setBorder(null);
		txtcomorbidade.setBackground(new Color(0, 79, 157));
		txtcomorbidade.setBounds(324, 258, 139, 20);
		perfilaluno.add(txtcomorbidade);
		
		txtcpf = new JTextField();
		txtcpf.setForeground(Color.WHITE);
		txtcpf.setFont(new Font("Arial", Font.BOLD, 16));
		txtcpf.setEnabled(false);
		txtcpf.setColumns(10);
		txtcpf.setBorder(null);
		txtcpf.setBackground(new Color(0, 79, 157));
		txtcpf.setBounds(556, 151, 139, 20);
		perfilaluno.add(txtcpf);
		
		txtemail = new JTextField();
		txtemail.setForeground(Color.WHITE);
		txtemail.setFont(new Font("Arial", Font.BOLD, 16));
		txtemail.setEnabled(false);
		txtemail.setColumns(10);
		txtemail.setBorder(null);
		txtemail.setBackground(new Color(0, 79, 157));
		txtemail.setBounds(556, 189, 139, 20);
		perfilaluno.add(txtemail);
		
		MaskFormatter mascaraAltura = new MaskFormatter("#.##");
		txtaltura = new JFormattedTextField(mascaraAltura);
		txtaltura.setForeground(Color.WHITE);
		txtaltura.setFont(new Font("Arial", Font.BOLD, 16));
		txtaltura.setEnabled(false);
		txtaltura.setColumns(10);
		txtaltura.setBorder(null);
		txtaltura.setBackground(new Color(0, 79, 157));
		txtaltura.setBounds(556, 224, 44, 20);
		perfilaluno.add(txtaltura);
		
		MaskFormatter mascaraBf = new MaskFormatter("***");
		mascaraBf.setValidCharacters("0123456789. ");
		txtbf = new JFormattedTextField(mascaraBf);
		txtbf.setForeground(Color.WHITE);
		txtbf.setFont(new Font("Arial", Font.BOLD, 16));
		txtbf.setEnabled(false);
		txtbf.setColumns(10);
		txtbf.setBorder(null);
		txtbf.setBackground(new Color(0, 79, 157));
		txtbf.setBounds(738, 224, 31, 20);
		perfilaluno.add(txtbf);
		
		txtstatus = new JTextField();
		txtstatus.setHorizontalAlignment(SwingConstants.CENTER);
		txtstatus.setForeground(new Color(0, 255, 51));
		txtstatus.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtstatus.setEnabled(false);
		txtstatus.setColumns(10);
		txtstatus.setBorder(null);
		txtstatus.setBackground(new Color(0, 79, 157));
		txtstatus.setBounds(440, 420, 139, 20);
		perfilaluno.add(txtstatus);
		
		btnenviar = new JButton("Submeter");
		btnenviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnenviar.setVisible(false);
				btnenviar.setEnabled(false);
				txtemail.setEnabled(false);
				txttelefone.setEnabled(false);
				txtemail.setBorder(null);
				txttelefone.setBorder(null);
				try {
					String telefone = txttelefone.getText();
					String email = txtemail.getText();
					Double altura = Double.parseDouble(txtaltura.getText());
					Double peso = Double.parseDouble(txtpeso.getText());
					Double bf = Double.parseDouble(txtbf.getText());
					Integer matricula = Integer.parseInt(txtmatricula.getText());
					if (email.equals(emailT)&& telefone.equals(telefoneT) && altura.equals(alturaT) && peso.equals(pesoT) && bf.equals(bfT) && imagemBlob.equals(imagemBlobnova)){
						JOptionPane.showMessageDialog(null,"Atualize pelo menos um dado para realizar a alteração");
						btneditar.setVisible(true);
						btneditar.setEnabled(true);
						btnfoto.setVisible(false);
						btnfoto.setEnabled(false);
					}else {
						UpdateController.UpdateAlunoAluno(telefone,email,altura,peso,bf,matricula,imagemBlobnova);
						btneditar.setVisible(true);
						btneditar.setEnabled(true);
						btnfoto.setVisible(false);
						btnfoto.setEnabled(false);
					}
				} catch (NumberFormatException e5) {
					txttelefone.setBorder( new TitledBorder("") );
					txtemail.setBorder(new TitledBorder(""));
					txtemail.setEnabled(true);
					txttelefone.setEnabled(true);
					btnenviar.setEnabled(true);
					btnenviar.setVisible(true);
					JOptionPane.showMessageDialog(null,"Preencha os campos ALTURA, PESO E BF corretamente com números válidos");
				} catch (RuntimeException e1) {
					e1.printStackTrace();
					txttelefone.setBorder( new TitledBorder("") );
					txtemail.setBorder(new TitledBorder(""));
					txtemail.setEnabled(true);
					txttelefone.setEnabled(true);
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
		btnenviar.setFocusPainted(false);
		btnenviar.setVisible(false);
		btnenviar.setEnabled(false);
		btnenviar.setForeground(Color.WHITE);
		btnenviar.setFont(new Font("Arial", Font.BOLD, 16));
		btnenviar.setBackground(new Color(0, 69, 130));
		btnenviar.setBounds(520, 577, 175, 40);
		perfilaluno.add(btnenviar);
		
		btneditar = new JButton("Alterar Informações");
		btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txttelefone.setBorder( new TitledBorder("") );
				txttelefone.setEnabled(true);
				txtemail.setBorder(new TitledBorder(""));
				txtemail.setEnabled(true);
				btnenviar.setEnabled(true);
				btnenviar.setVisible(true);
				btnfoto.setVisible(true);
				btnfoto.setEnabled(true);
				btneditar.setVisible(false);
				btneditar.setEnabled(false);
			}
		});
		btneditar.setFocusPainted(false);
		btneditar.setForeground(Color.WHITE);
		btneditar.setFont(new Font("Arial", Font.BOLD, 16));
		btneditar.setBackground(new Color(0, 69, 130));
		btneditar.setBounds(274, 575, 200, 40);
		perfilaluno.add(btneditar);
		
		JLabel lblmatricula = new JLabel("MATRICULA:");
		lblmatricula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblmatricula.setForeground(Color.WHITE);
		lblmatricula.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblmatricula.setBounds(214, 86, 101, 20);
		perfilaluno.add(lblmatricula);
		
		txtmatricula = new JTextField();
		txtmatricula.setForeground(Color.WHITE);
		txtmatricula.setFont(new Font("Arial", Font.BOLD, 20));
		txtmatricula.setEnabled(false);
		txtmatricula.setColumns(10);
		txtmatricula.setBorder(null);
		txtmatricula.setBackground(new Color(0, 79, 157));
		txtmatricula.setBounds(324, 87, 139, 20);
		perfilaluno.add(txtmatricula);
		
		JLabel lblKg = new JLabel("Kg");
		lblKg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKg.setForeground(Color.WHITE);
		lblKg.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblKg.setBounds(345, 221, 72, 24);
		perfilaluno.add(lblKg);
		
		JLabel lblKg_1 = new JLabel("m");
		lblKg_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKg_1.setForeground(Color.WHITE);
		lblKg_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblKg_1.setBounds(545, 221, 78, 24);
		perfilaluno.add(lblKg_1);
		
		JLabel lblKg_1_1 = new JLabel("%");
		lblKg_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKg_1_1.setForeground(Color.WHITE);
		lblKg_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblKg_1_1.setBounds(702, 221, 78, 24);
		perfilaluno.add(lblKg_1_1);
		
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
					try {
						imagemBlobnova = new javax.sql.rowset.serial.SerialBlob(WebCam.imgemBlob());
					}catch (NullPointerException e1) {
					} catch (SerialException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnfoto.setBorder(null);
		btnfoto.setBounds(78, 269, 93, 20);
		perfilaluno.add(btnfoto);
	
	}
	
	public void getAluno(Aluno alunoLogado) throws IOException {
		txtmatricula.setText(Integer.toString(alunoLogado.getMatricula()));
		txtnome.setText(alunoLogado.getNome());
		txtcpf.setText(alunoLogado.getCpf());
		txttelefone.setText(alunoLogado.getTelefone());
		txtemail.setText(alunoLogado.getEmail());
		txtdata.setText(alunoLogado.getData_nascimento());
		txtaltura.setText(Double.toString(alunoLogado.getAltura()));
		txtpeso.setText(Double.toString(alunoLogado.getPeso()));
		txtbf.setText(Double.toString(alunoLogado.getBf()));
		txtcomorbidade.setText(alunoLogado.getComorbidade());
		telefoneT = alunoLogado.getTelefone();
		emailT = alunoLogado.getEmail();
		alturaT = alunoLogado.getAltura();
		pesoT = alunoLogado.getPeso();
		bfT = alunoLogado.getBf();
		Blob foto = alunoLogado.getImage();
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
		if (alunoLogado.getQtdDiasUltimoPagamento() < 30) {
			txtstatus.setText("Pago");
		} else if (alunoLogado.getQtdDiasUltimoPagamento() > 30 || alunoLogado.getQtdDiasUltimoPagamento() < 180) {
			txtstatus.setText("Inadinplente");
		} else if (alunoLogado.getQtdDiasUltimoPagamento() >= 180) {
			txtstatus.setText("Inativo");
		}
	}
}
