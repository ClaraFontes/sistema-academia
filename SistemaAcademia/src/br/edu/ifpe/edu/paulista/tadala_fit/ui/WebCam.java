package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.FlowLayout;


public class WebCam extends JDialog {

    private static final long serialVersionUID = 1L;
    private Webcam webcam = Webcam.getDefault();
    
    public  Webcam getWebcam() {
		return webcam;
	}

	private JButton btntirarfoto;
    protected static String caminhofoto;
    private static  Blob imagemBlob;
    
    public WebCam() {
        if (webcam != null) {
        	   if (webcam.isOpen()) {
               	webcam.close();
               }
        	 setSize(new Dimension(700, 570));
           	setResizable(false);
           	addWindowListener(new WindowAdapter() {
           		@Override
           		public void windowClosing(WindowEvent e) {
           			if (JOptionPane.showConfirmDialog(null, "deseja fechar camera?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
           				if (webcam != null) {
           					webcam.close();
           				}
       					setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       				}else {
       					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
       				}
           		}
           	});
           	getContentPane().setBackground(new Color(0, 79, 157));
           	setIconImage(Toolkit.getDefaultToolkit().getImage(WebCam.class.getResource("/assets_loginFrame/logotipo200x200.png")));
           	setTitle("Tadalafit - Webcam");
        	Dimension size = WebcamResolution.VGA.getSize();
        	webcam.setViewSize(size);
            webcam.close();
            webcam.open();
            WebcamPanel webcamPanel = new WebcamPanel(webcam);
            webcamPanel.setFPSDisplayed(true);
            webcamPanel.setLayout(null);
            getContentPane().add(webcamPanel);
            btntirarfoto = new JButton("Tirar Foto");
            btntirarfoto.setFont(new Font("Tahoma", Font.BOLD, 13));
            getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            getContentPane().add(btntirarfoto);
            btntirarfoto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Boolean sucesso = ImageIO.write(webcam.getImage(),"PNG", new File("imagem.png"));
                        if (sucesso) {
                        	File foto = new File("imagem.png");
                        	caminhofoto = foto.getAbsolutePath();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }finally {
                    	webcam.close();
                    	dispose();
                    }
                }
            });
        	pack();
        }
        if (webcam == null) {
        	JOptionPane.showMessageDialog(null,"Você não possui uma webcam conectada!\n"
        			+ "Conecte uma WebCam para prosseguir com o cadastro");
        }
    }
    
    public static BufferedImage carregarFoto() {
		BufferedImage fotoperfil = null;
		BufferedImage resizedImage = null;
		try {
			fotoperfil = ImageIO.read(new File(WebCam.caminhoCarregarFoto()));
			resizedImage = new BufferedImage(150, 150, fotoperfil.getType());
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(fotoperfil, 0, 0, 150, 150, null);
			g.dispose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resizedImage;
    }
    	
    public static String caminhoCarregarFoto() {
    	return caminhofoto;
    }
    public static Blob imgemBlob() {
    	File image = new File (WebCam.caminhoCarregarFoto());
		FileInputStream inputstream;
		try {
			inputstream = new FileInputStream(image);
			byte[] imagepronta = new byte[(int) image.length()];
			inputstream.read(imagepronta);
			inputstream.close();
			imagemBlob = new javax.sql.rowset.serial.SerialBlob(imagepronta);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imagemBlob;
    	
    }
}