package tallerMecanico;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Taller {
	public static Scanner teclado;
	private static HashMap<Integer, Trabajo> trabajos;
	private static Integer ultimoID=1;
	public static String separador="---------------------------------------------------";
	public static void main(String[] args) {
		Taller.teclado=new Scanner(System.in);
		Taller.trabajos=new HashMap<Integer, Trabajo>();
		boolean salir=false;
		do{
			Iterator<Integer> it = Taller.trabajos.keySet().iterator();
			Trabajo currentTrabajo;
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
			
			System.out.print("Ingrese una opción: ");
			Integer opcion = teclado.nextInt();
			System.out.println(Taller.separador);			
			switch(opcion){
			case 1:
				Trabajo.registrar();
				break;
			case 2:
				while(it.hasNext()){
					currentTrabajo = Taller.trabajos.get(it.next());
					if (currentTrabajo.isPendiente()){
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
					currentTrabajo = Taller.trabajos.get(it.next());
					if(!currentTrabajo.isPendiente()) {
						currentTrabajo.mostrar();
					}
				}
				break;
			case 9:
				salir=true;
				break;
			}
			
		}while (salir==false);
	}
	public static void registrarTrabajo(Trabajo t) {
		Taller.trabajos.put(ultimoID, t);
		ultimoID++;
		
	}


}
