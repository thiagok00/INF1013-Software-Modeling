package State;

class Centrifugando extends MaquinaState {

	@Override
	public String getStatus() {

		return "Centrifugando";
	}
	
	Centrifugando() {
		maquina.motor.fast();
	}
	
	@Override
	public MaquinaState timeOver() {
		
		if(maquina.ciclo == 1){
			System.out.println("Fim do primeiro ciclo");
			maquina.ciclo++;
			return new EnchendoTanque();
		}
		System.out.println("Fim do segundo ciclo");
		return new Aguardando();
	}

}
