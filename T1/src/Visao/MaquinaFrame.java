package Visao;

import javax.swing.JFrame;


public class MaquinaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public final int WIDTH_DEFAULT = 800;
	public final int HEIGHT_DEFAULT =720;

	public MaquinaFrame(){
		this.setLayout(null);
		setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		MaquinaPainel panel = new MaquinaPainel();
		getContentPane().add(panel);
	
	}
	
	
	public static void main(String[] args) {
		
		MaquinaFrame tab = new MaquinaFrame();
		tab.setVisible(true);
	}
	
	
	
}
