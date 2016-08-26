package tallerMecanico;

public class Trabajo {
	private boolean pendiente=true;
	public static void registrar() {
		// TODO Auto-generated method stub
		System.out.println("Qu� tipo de trabajo?");
		System.out.println("1 Reparaci�n mec�nica");
		System.out.println("2 Reparaci�n chapa y pintura");
		System.out.println("3 Revisi�n");
		
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

}
