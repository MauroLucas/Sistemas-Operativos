package modelo;
import java.io.*;
import java.util.*;

public class LecturaArchivo {
	
	public static List<Proceso> lecturaArchivo() throws Exception {
		FileReader fr= new FileReader("scheduling.conf");
		BufferedReader br= new BufferedReader(fr);
		String linea;
		int numprocess=0;
		int meandev=0;
		int contp=0;
		boolean cargado=false;
		int procesosintroducidos=0;
		while((linea=br.readLine())!=null){
			if(linea.contains("-process")){
				procesosintroducidos++;
			}
		}
		fr.close();
		br.close();
		fr=new FileReader("scheduling.conf");
		br=new BufferedReader(fr);
		int[] timeproceso=new int[procesosintroducidos];
		while((linea=br.readLine())!=null){
		StringTokenizer st= new StringTokenizer(linea);
		if(linea.contains("numprocess")){
			while (st.hasMoreTokens() && !cargado){
	           String s2 = st.nextToken();
	           if(esCadenaNumeros(s2)){
	        	   numprocess=Integer.valueOf(s2);
	        	   cargado=true;
	           }
	        }
		}
		}
		fr.close();
		br.close();
		if(numprocess!=procesosintroducidos) throw new Exception("Se cargaron una cantidad diferente de procesos a la cantidad indicada.");
		fr=new FileReader("scheduling.conf");
		br=new BufferedReader(fr);
		while((linea=br.readLine())!=null){
			StringTokenizer st= new StringTokenizer(linea);
			cargado=false;
			if(linea.contains("meandev")){
				while (st.hasMoreTokens() && !cargado){
		           String s2 = st.nextToken();
		           if(esCadenaNumeros(s2)){
		        	   meandev=Integer.valueOf(s2);
		        	   cargado=true;
		           }
		        }
			}
			cargado=false;
			if(linea.contains("-process") && numprocess!=0){
				while (st.hasMoreTokens() && !cargado){
		           String s2 = st.nextToken();
		           if(esCadenaNumeros(s2)){
		        	   timeproceso[contp]=Integer.valueOf(s2);
		        	   contp++;
		        	   cargado=true;
		           }
		        }
			}
			cargado=false;
		}
		List<Proceso> procesos=new ArrayList<Proceso>();
		int i=0;
		while(i<numprocess){
			procesos.add(new Proceso(procesos.size()+1,meandev,timeproceso[i],false,false,false));
			i++;
		}
		fr.close();
		br.close();
		return procesos;
	}
	
	public static boolean esCadenaNumeros(String cadena) {
		boolean numerica=true;
		int i=0;
		char c;
		while(numerica && i<cadena.length()){
				c=cadena.charAt(i);
				if(!Character.isDigit(c)){
					numerica=false;
				}
				i++;
		}
		return numerica;
	}

}