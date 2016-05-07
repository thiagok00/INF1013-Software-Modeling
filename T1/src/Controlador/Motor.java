package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

public class Motor extends Observable implements ActionListener {

	private Timer t;
	private int max;
	private int cont;
	private ControladorMaquina maquina;
	
	Motor(ControladorMaquina m) {
		this.maquina = m;
	}
	
	
	public void slow() {
		t = new Timer(100,this);
		cont = 0;
		max = 100;
		t.start();
		System.out.println("Motor ligado modo slow.");
	}

	public void fast() {
		t = new Timer(50,this);
		cont = 0;
		max = 200;
		t.start();
		System.out.println("Motor ligado modo fast.");
	}
	
	public void stop() {
		t.stop();
		System.out.println("Motor desligado.");
		maquina.timeOver();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		cont++;
		this.setChanged();
		if(cont < max)
			this.notifyObservers(new Boolean(true));
		else {
			this.notifyObservers(new Boolean(false));
			this.stop();
		}
	}
	
}
