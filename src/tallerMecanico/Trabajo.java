package tallerMecanico;

public abstract class Trabajo {
	private boolean pendiente=true;
	private double horas;
	protected final double horasDiarias = 8;
	public static void registrar() {
		// TODO Auto-generated method stub
		System.out.println("Qué tipo de trabajo?");
		System.out.println("1 Reparación mecánica");
		System.out.println("2 Reparación chapa y pintura");
		System.out.println("3 Revisión");
		
		Integer opcion = Taller.teclado.nextInt();
		
		switch(opcion){
		case 1:
			ReparacionMecanica.registrar();
			break;
		case 2:
			ReparacionChapaYPintura.registrar();
			break;
		case 3:
			Revision.registrar();
			break;
		default:
			System.out.println("Ingrese 1, 2 o 3");
			break;
			
		}
	}

	public boolean isPendiente() {
		return this.pendiente;
	}

	public void mostrar() {
		System.out.println("Tipo: "+this.getClass().toString());
		System.out.println("Pendiente: "+pendiente);
	}

	public double calcularPrecio() {
		double precio=0;
		if(this.getClass().getName()=="tallerMecanico.ReparacionMecanica"){
			Reparacion reparacion = (Reparacion) this;
			precio =(this.getHoras()*100) + (reparacion.materiales*1.25);			
		}
		else if(this.getClass().getName()=="tallerMecanico.ReparacionChapaYPintura"){
			Reparacion reparacion = (Reparacion) this;
			precio =(this.getHoras()*100) + (reparacion.materiales*1.5);
		}
		else if(this.getClass().getName()=="tallerMecanico.Revision"){
			precio =(this.getHoras()*100) + 200;
		}
		return precio;
	}

	public void registrarHoras(double horas) {
		this.horas = this.horas + horas;
		if (horas >= getHorasTope()){
			this.pendiente = false;
		}
	}

	public double getHoras() {
		return horas;
	}

	public double calcularHorasDisponibles() {
		return getHorasTope() - horas;
	}

	public abstract double getHorasTope();

}
