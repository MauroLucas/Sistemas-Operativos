package test;
import modelo.*;
import java.util.List;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		
		Proceso proceso1 = new Proceso(1,4,2,false,false,false);
		Proceso proceso2 = new Proceso(2,4,5,false,false,false);
		Proceso proceso3 = new Proceso(3,4,3,false,false,false);
		Proceso proceso4 = new Proceso(4,4,1,false,false,false);
		
		List<Proceso> lista = new ArrayList<Proceso>();
		lista.add(proceso1);
		lista.add(proceso2);
		lista.add(proceso3);
		lista.add(proceso4);
		
		AlgoritmoPlanificacion algoritmo = new AlgoritmoPlanificacion(3,lista);
		//System.out.println(algoritmo.getListaColaListos());
		System.out.println(algoritmo.getListaColaTerminados());
	
		
	}
	
	

}
