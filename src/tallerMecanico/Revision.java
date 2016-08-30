package tallerMecanico;

public class Revision extends Trabajo implements IPromocionable{
	
	public static void registrar(){
		
		Taller.registrarTrabajo(new Revision());
	}

	@Override
	public Double precioDePromocion() {
		return this.calcularPrecio()*0.8;
	}

	@Override
	public double getHorasTope() {
		return horasDiarias*7;
	}

}
