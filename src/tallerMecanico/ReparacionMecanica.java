package tallerMecanico;

public class ReparacionMecanica extends Reparacion{
	
	public static void registrar() {
		
		Trabajo t = new ReparacionMecanica();
		Taller.registrarTrabajo(t);
	}

}
