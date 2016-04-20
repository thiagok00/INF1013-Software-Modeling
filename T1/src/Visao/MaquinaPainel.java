package Visao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MaquinaPainel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton start;
	
	public MaquinaPainel() {
		this.setBounds(200,0,700,700);	
		start = new JButton("START");
		start.addActionListener(this);
		add(start);
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("started");
	}
	
	
}
