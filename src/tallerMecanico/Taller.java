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

		Taller.trabajos=new HashMap<Integer, Trabajo>();
		boolean salir=false;
		do{
			System.out.println(Taller.separador);
			System.out.println("ingrese una opción:");
			System.out.println("1 Registrar un trabajo");
			System.out.println("2 Mostrar trabajos pendientes");
			System.out.println("3 Dar de baja un trabajo");
			System.out.println("4 Mostrar trabajos finalizados");
			System.out.println("5 Calcular precio de trabajo");
			System.out.println("6 Registrar horas");
			System.out.println("7 Registrar materiales");
			System.out.println("8 Verificar horas disponibles");
			System.out.println("9 Totalizar descuentos");
			
			Taller.teclado=new Scanner(System.in);
			Integer opcion = teclado.nextInt();
			
			switch(opcion){
			case 1:
				Trabajo.registrar();
				break;
			case 2:
				Trabajo t;
			
				Iterator<Trabajo> it = trabajos.values().iterator();
				while(it.hasNext()){
					t = it.next();
					if (t.isPendiente()){
						t.mostrar();
					}
				}
				break;
			case 3:
				System.out.println("Ingrese el ID del trabajo que desea borrar: ");
				Integer key=teclado.nextInt();
				Taller.trabajos.remove(key);
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
