package State;

class EsvaziandoTanque extends MaquinaState {

	@Override
	public String getStatus() {
		return "Esvaziando Tanque";
	}

	EsvaziandoTanque() {
		maquina.bomba.start();
	}
	
	@Override
	public MaquinaState timeOver() {
		return new Centrifugando();
	}
}
