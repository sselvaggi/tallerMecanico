package tallerMecanico;

public abstract class Reparacion extends Trabajo {

	protected double materiales;

	public void registrarMateriales(double materiales) {
		this.materiales = this.materiales + materiales;
		
	}

	public Double getMateriales() {
		return materiales;
	}
	
}

