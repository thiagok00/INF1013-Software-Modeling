package State;

import Controlador.ControladorMaquina;

public abstract class MaquinaState {

	protected static ControladorMaquina maquina;
	
	static public MaquinaState getInitialState(ControladorMaquina m) {
		MaquinaState state = (MaquinaState) new Aguardando();
		MaquinaState.maquina = m;
		return state;
	}

	public abstract String getStatus();
	public MaquinaState start(){return null;};
	public MaquinaState timeOver() {return null;} 
	public MaquinaState full() {return null;}
	
}
