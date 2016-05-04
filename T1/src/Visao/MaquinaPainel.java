package Visao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.Bomba;
import Controlador.Motor;
import Controlador.Valvula;


public class MaquinaPainel extends JPanel implements ActionListener, Observer{

	private static final long serialVersionUID = 1L;
	
	public MaquinaPainel() {
		this.setBounds(100,0,700,700);	

	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image maquina=null;
		try {
			maquina=ImageIO.read(new File("Imgs/maquina-1.jpg"));
			   
			}
			catch(IOException e) {
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
		g.drawImage(maquina, 0, 0, 474, 474,null);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Bomba) {
			
		}
		else if (o instanceof Motor) {
			
		}
		else if (o instanceof Valvula) {
			Integer i = (Integer) arg;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("started");
	}
	
	
}
