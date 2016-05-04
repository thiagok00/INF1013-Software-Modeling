package State;

public class Aguardando extends MaquinaState {

	@Override
	public String getStatus() {
		return "Aguardando";
	}
	
	@Override
	public MaquinaState start(){
		
		MaquinaState.maquina.valvula.open();
		
		return new EnchendoTanque();
	}

}
