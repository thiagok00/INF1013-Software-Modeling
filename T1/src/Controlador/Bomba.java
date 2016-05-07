package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

public class Bomba extends Observable implements ActionListener {

	private Timer t;
	private Integer nivel;
	private ControladorMaquina maquina;
	
	Bomba(ControladorMaquina m) {
		this.maquina = m;
		t = new Timer(1000,this);
	}
	
	public void start() {
		System.out.println("Bomba começou");
		nivel = 10;
		t.start();
	}
	
	
	public void stop() {
		t.stop();
		System.out.println("Bomba parou");
		maquina.timeOver();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		nivel--;
		this.setChanged();
		this.notifyObservers(nivel);
		System.out.println("Nivel Tanque "+nivel+"0%");

		if (nivel == 0){
			this.stop();
		}
		
	}
	
	
	
}
