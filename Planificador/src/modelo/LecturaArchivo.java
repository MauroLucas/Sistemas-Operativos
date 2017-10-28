package modelo;
import java.io.*;
import java.util.*;

public class LecturaArchivo {
	
	public static void lecturaArchivo() throws Exception {
		FileReader fr= new FileReader("scheduling.conf");
		BufferedReader br= new BufferedReader(fr);
		String linea;
		int numprocess=0;
		boolean cargado=false;
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