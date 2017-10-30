package test;
import modelo.*;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		
		try{
			List<Proceso> lista = /*new ArrayList<Proceso>()*/LecturaArchivo.lecturaArchivo();
			for(Proceso p: lista){
				System.out.println(p);
			}
			AlgoritmoPlanificacion algoritmo = new AlgoritmoPlanificacion(LecturaArchivo.obtenerQuantum(),lista);
			System.out.println(algoritmo.getListaColaTerminados());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
