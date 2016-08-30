package tallerMecanico;

public class ReparacionMecanica extends Reparacion implements IPromocionable{
	
	public static void registrar() {
		
		Trabajo t = new ReparacionMecanica();
		Taller.registrarTrabajo(t);
	}

	@Override
	public Double precioDePromocion() {
		return this.calcularPrecio()*0.8;
	}

	@Override
	public double getHorasTope() {
		return horasDiarias*14;
	}

}
