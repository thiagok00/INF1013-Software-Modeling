package State;

class Enxaguando extends MaquinaState {


	@Override
	public String getStatus() {
		return "Enxaguando";
	}
	
	Enxaguando() {
		maquina.motor.slow();
	}

	@Override
	public MaquinaState timeOver() {
		return new EsvaziandoTanque();
	}
	
	
}
