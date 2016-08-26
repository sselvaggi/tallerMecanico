package tallerMecanico;

public class Revision extends Trabajo implements IPromocionable{
	
	public static void registrar(){
		
		Taller.registrarTrabajo(new Revision());
	}

}
