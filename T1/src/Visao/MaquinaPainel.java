package Visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Controlador.Bomba;
import Controlador.Motor;
import Controlador.Valvula;


public class MaquinaPainel extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private String maquinaImgPath = "Imgs/maquina-1.jpg";
	private BufferedImage maquinaImg = null;
	private int rectHeight = 0;
	
	
	public MaquinaPainel() {
		this.setBounds(100,0,474+40+10,474+10);	

	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			maquinaImg = ImageIO.read(new File(maquinaImgPath));
			   
			}
			catch(IOException e) {
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
		g.drawImage(maquinaImg, 0, 0, 474, 474,null);
		
		int yRect = 474 - rectHeight;
		g.setColor(Color.BLUE);
		g.fillRect(474, yRect, 40, rectHeight);
		g.setColor(Color.BLACK);
		g.drawRect(474, 0, 40, 474);
	}

	private void trocaImgMaquinaLigada() {
		
		if (maquinaImgPath ==  "Imgs/maquina-3.jpg" || maquinaImgPath == "Imgs/maquina-1.jpg" )
			maquinaImgPath = "Imgs/maquina-2.jpg";
		else if (maquinaImgPath == "Imgs/maquina-2.jpg")
			maquinaImgPath = "Imgs/maquina-3.jpg";
		
		this.repaint();
	}
	
	private void atualizaImgTanque(Integer i) {
		if (i == 0)
			rectHeight = 0;
		else 
			rectHeight = (int)(474*(float)i/10);
		this.repaint();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Bomba) {
			Integer i = (Integer) arg;
			atualizaImgTanque(i);
		}
		else if (o instanceof Motor) {
			Boolean ligado = (Boolean) arg;
			if(ligado == true){
				this.trocaImgMaquinaLigada();
			}
			else {
				maquinaImgPath = "Imgs/maquina-1.jpg";
				this.repaint();
			}
			
		}
		else if (o instanceof Valvula) {
			Integer i = (Integer) arg;
			atualizaImgTanque(i);
		}
		
	}
	
	
}
