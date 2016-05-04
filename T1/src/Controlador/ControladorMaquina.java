package Controlador;

import State.MaquinaState;

public class ControladorMaquina {

	public Bomba bomba = new Bomba(this);
	public Valvula valvula = new Valvula(this);
	public Motor motor = new Motor(this);
	private MaquinaState state = MaquinaState.getInitialState(this);
	public int ciclo = 0;
	
	public void start() {
		MaquinaState ms = state.start();
		if (ms != null)
			state = ms;
	}
	
	public void timeOver() {
		MaquinaState ms = state.timeOver();
		if (ms != null)
			state = ms;
	}
	
	public void full() {
		MaquinaState ms = state.full();
		if (ms != null)
			state = ms;
	}
	
}
