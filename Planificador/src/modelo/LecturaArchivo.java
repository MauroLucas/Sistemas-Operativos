package modelo;
import java.io.*;
import java.util.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LecturaArchivo {
	
	static final Logger logResults = Logger.getLogger("resultsLogger");
	
	public static List<Proceso> lecturaArchivo() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
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
		if(linea.contains("numprocess")){
			StringTokenizer st= new StringTokenizer(linea);
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
			cargado=false;
			if(linea.contains("meandev")){
				StringTokenizer st= new StringTokenizer(linea);
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
				StringTokenizer st= new StringTokenizer(linea);
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
		logResults.debug("Planificador 'Round-robin v2.0'");
		logResults.debug("CPU Time (Global): " + meandev);
		logResults.debug("Quantum: " + String.valueOf(obtenerQuantum()));
		logResults.debug("***************************************************************");
		logResults.debug("Procesos por orden de finalizacion");
		logResults.debug("");
		return procesos;
	}
	
	public static int obtenerQuantum() throws Exception {
		int quantum=0;
		FileReader fr= new FileReader("scheduling.conf");
		BufferedReader br= new BufferedReader(fr);
		String linea;
		boolean cargado=false;
		while((linea=br.readLine())!=null){
			if(linea.contains("-quantum")){
				StringTokenizer st= new StringTokenizer(linea);
				while (st.hasMoreTokens() && !cargado){
		           String s2 = st.nextToken();
		           if(esCadenaNumeros(s2)){
		        	   quantum=Integer.valueOf(s2);
		        	   cargado=true;
		           }
		        }
			}
			}
		fr.close();
		br.close();
		return quantum;
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