package State;

public class EnchendoTanque extends MaquinaState {

	@Override
	public String getStatus() {
		return "Enchendo Tanque";
	}
	
	public EnchendoTanque() {
		MaquinaState.maquina.valvula.open();
	}
	
	@Override
	public MaquinaState full() {
		return new Enxaguando();
	}

	
}
