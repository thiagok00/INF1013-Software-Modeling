package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;


public class Valvula extends Observable implements ActionListener {

	private boolean opened = false;
	private final ControladorMaquina maquina;
	private Integer nivel = 0;
	private Timer t;
	
	Valvula(ControladorMaquina m) {
		this.maquina = m;
		t = new Timer(1000,this);
	}
	
	
	public void open() {
		
		if (!opened) {
			opened = true;		
			System.out.println("Valvula Aberta");
			nivel = 0;
			t.start();

		}	
	}
	public void close(){ 
		if(opened){
			opened = false;
			System.out.println("Valvula Fechada");
			this.maquina.full();
		}
	}
	
	boolean get() {
		return opened;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		nivel++;
		System.out.println("Nivel Tanque "+nivel+"0%");
		this.setChanged();
		this.notifyObservers(nivel);
		
		if (nivel == 10) {
			t.stop();
			this.close();
		}
			
		
		
	}
	
	
	
	
}
