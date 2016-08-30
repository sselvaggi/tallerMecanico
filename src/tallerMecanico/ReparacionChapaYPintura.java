package tallerMecanico;

public class ReparacionChapaYPintura extends Reparacion{
	public static void registrar(){
		Taller.registrarTrabajo(new ReparacionChapaYPintura());
	}
	
	@Override
	public double getHorasTope() {
		return horasDiarias*21;
	}
}
