package tallerMecanico;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Taller {
	public static Scanner teclado;
	private static HashMap<Integer, Trabajo> trabajos;
	private static Integer ultimoID=1;
	public static String separador="---------------------------------------------------";
	public static void main(String[] args) {
		Taller.teclado=new Scanner(System.in);
		Taller.trabajos=new HashMap<Integer, Trabajo>();
		Taller taller = new Taller();
		taller.mostrarMenu();
		
		
	}
	public void mostrarMenu(){
		boolean salir=false;
		do{
			Iterator<Integer> it = Taller.trabajos.keySet().iterator();
			Trabajo currentTrabajo = null;
			System.out.println(Taller.separador);
			System.out.println("1 Registrar un trabajo");
			System.out.println("2 Mostrar trabajos pendientes");
			System.out.println("3 Dar de baja un trabajo");
			System.out.println("4 Mostrar trabajos finalizados");
			System.out.println("5 Calcular precio de trabajo");
			System.out.println("6 Registrar horas");
			System.out.println("7 Registrar materiales");
			System.out.println("8 Verificar horas disponibles");
			System.out.println("9 Totalizar descuentos");
			System.out.println("0 Salir");
			
			System.out.print("Ingrese una opción: ");
			Integer opcion = teclado.nextInt();
			System.out.println(Taller.separador);			
			Integer id;
			switch(opcion){
			case 1:
				Trabajo.registrar();
				break;
			case 2:
				while(it.hasNext()){
					id = it.next();
					currentTrabajo = Taller.trabajos.get(id);					
					if (currentTrabajo.isPendiente()){
						System.out.println("ID: "+id);
						currentTrabajo.mostrar();
					}
				}
				break;
			case 3:
				System.out.println("Ingrese el ID del trabajo que desea borrar: ");
				Integer key=teclado.nextInt();
				Taller.trabajos.remove(key);
				break;
			case 4:
				while(it.hasNext()) {
					id = it.next();
					currentTrabajo = Taller.trabajos.get(id);
					if(!currentTrabajo.isPendiente()) {
						System.out.println("ID: "+id);
						currentTrabajo.mostrar();
					}
				}
				break;
			case 5:
				currentTrabajo=seleccionarTrabajo();
				if (currentTrabajo == null){
					System.out.println("No existe el trabajo con el ID ingresado");
				}
				else{
					try{
						IPromocionable trabajoPromo=(IPromocionable) currentTrabajo;
						System.out.println("El precio promo es: $"+trabajoPromo.precioDePromocion());
					}
					catch(ClassCastException e){
						System.out.println("El precio es: $"+currentTrabajo.calcularPrecio());
					}
					if (currentTrabajo.isPendiente()==true){
						System.out.println("Este trabajo está pendiente");
					}
				
				}
				break;
			case 6:
				currentTrabajo=seleccionarTrabajo();
				if (currentTrabajo == null){
					System.out.println("No existe el trabajo con el ID ingresado");				
				}
				else{
					System.out.println("Ingrese cantidad de horas a registrar");
					currentTrabajo.registrarHoras(teclado.nextDouble());
					System.out.println("Horas acumuladas: "+currentTrabajo.getHoras());
				}
				break;
			case 7:
				currentTrabajo=seleccionarTrabajo();
				if (currentTrabajo == null){
					System.out.println("No existe el trabajo con el ID ingresado");				
				}
				else{
					if( currentTrabajo instanceof Revision) {
						System.out.println("No se puede ingresar meteriales a una Revision");
					}
					else {
						Reparacion reparacion = (Reparacion) currentTrabajo;
						System.out.println("Ingrese monto de materiales utilizados");
						reparacion.registrarMateriales(teclado.nextDouble());
						System.out.println("Monto de materiales acumulados: "+ reparacion.getMateriales());
					}
					
				}
				break;
			case 8:
				currentTrabajo=seleccionarTrabajo();
				if (currentTrabajo == null){
					System.out.println("No existe el trabajo con el ID ingresado");				
				}
				else{
					System.out.println("Horas disponibles: "+currentTrabajo.calcularHorasDisponibles());
				}
				break;
			case 9:
				Double totalDescuento = 0.0;
				while (it.hasNext()){
					currentTrabajo = trabajos.get(it.next());
					if (currentTrabajo instanceof Revision && !currentTrabajo.isPendiente()){
						IPromocionable promocionable = (IPromocionable) currentTrabajo;
						totalDescuento += currentTrabajo.calcularPrecio() - promocionable.precioDePromocion();
					}					
				}
				System.out.println("La sumatoria de lo descontado a las revisiones finalizadas es: $"+totalDescuento);
				break;
			case 0:
				System.out.println("Chau");
				salir=true;
				break;
			}

		}while (salir==false);

	}
	
	public static void registrarTrabajo(Trabajo t) {
		Taller.trabajos.put(ultimoID, t);
		ultimoID++;
		
	}
	public static Trabajo seleccionarTrabajo(){
		System.out.println("Ingrese el ID del trabajo: ");
		return Taller.trabajos.get(teclado.nextInt());
	}


}
