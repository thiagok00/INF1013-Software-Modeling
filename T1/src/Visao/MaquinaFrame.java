package Visao;

import javax.swing.JFrame;

import Controlador.*;


public class MaquinaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public final int WIDTH_DEFAULT = 650;
	public final int HEIGHT_DEFAULT = 550;
	public final MaquinaPainel mpainel;
	public final StartPainel spainel;

	public final ControladorMaquina maquina;

	public MaquinaFrame() {
		this.setLayout(null);
		setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		maquina = new ControladorMaquina();
		
		
		mpainel = new MaquinaPainel();
		getContentPane().add(mpainel);
		spainel = new StartPainel(maquina);
		getContentPane().add(spainel);
		
		
	}
	
	
	public static void main(String[] args) {
		
		MaquinaFrame frame = new MaquinaFrame();
		
		/* Colocando painel para observar */
		frame.maquina.bomba.addObserver(frame.mpainel);
		frame.maquina.motor.addObserver(frame.mpainel);
		frame.maquina.valvula.addObserver(frame.mpainel);
		
		frame.setVisible(true);
	}

	
	
}
