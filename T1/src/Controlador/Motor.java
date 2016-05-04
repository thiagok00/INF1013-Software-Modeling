package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

public class Motor extends Observable implements ActionListener {

	Timer t;
	double max;
	private ControladorMaquina maquina;
	
	Motor(ControladorMaquina m) {
		this.maquina = m;
	}
	
	
	public void slow() {
		t = new Timer(100,this);
		max = 0.0;
		t.start();
		System.out.println("Motor ligado modo slow.");
	}

	public void fast() {
		t = new Timer(50,this);
		max = 0.0;
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
		max += 0.1;
		this.setChanged();
		if(max < 5.0)
			this.notifyObservers(new Boolean(true));
		else {
			this.notifyObservers(new Boolean(false));
			this.stop();
		}
	}
	
}
