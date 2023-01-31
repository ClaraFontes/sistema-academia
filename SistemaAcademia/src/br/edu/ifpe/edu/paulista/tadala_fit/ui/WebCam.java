package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
import java.awt.Font;
import java.awt.FlowLayout;


public class WebCam extends JDialog {

    private static final long serialVersionUID = 1L;
    private Webcam webcam = Webcam.getDefault();
    private JButton btntirarfoto;
    
    public WebCam() {
    	setSize(new Dimension(700, 570));
    	setResizable(false);
    	addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowClosing(WindowEvent e) {
    			if (JOptionPane.showConfirmDialog(null, "deseja encerrar as consultas","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
    				webcam.close();
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
        if (webcam != null && webcam.isOpen()) {
            webcam.close();
        }
        webcam.open();
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setFPSDisplayed(true);
        webcamPanel.setLayout(null);
        btntirarfoto = new JButton("Tirar Foto");
        btntirarfoto.setFont(new Font("Tahoma", Font.BOLD, 13));
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        getContentPane().add(webcamPanel);
        getContentPane().add(btntirarfoto);
        btntirarfoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ImageIO.write(webcam.getImage(),"PNG", new File("imagem.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }finally {
                	webcam.close();
                	dispose();
                }
            }
        });
    	setModal(true);
    	setVisible(true);
    	pack();
       }
    
}
