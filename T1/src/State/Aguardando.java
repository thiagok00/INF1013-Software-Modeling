package State;

class Aguardando extends MaquinaState {

	@Override
	public String getStatus() {
		return "Aguardando";
	}
	
	@Override
	public MaquinaState start(){
		maquina.ciclo = 1;
		return new EnchendoTanque();
	}

}
