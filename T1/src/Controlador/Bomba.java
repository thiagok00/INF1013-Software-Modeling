package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

public class Bomba extends Observable implements ActionListener {

	public void start() {
		System.out.println("Bomba começou");
		Timer t = new Timer(1000,this);
		t.addActionListener(this);
	}
	public void stop() {
		System.out.println("Bomba parou");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
}
