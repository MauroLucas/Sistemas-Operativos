package modelo;
import java.util.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AlgoritmoPlanificacion {
	
	 private int quantum;
	 private int quantumSobrante;
	 private int ejecuciones;
	 private List<Proceso> colaListos;
	 private List<Proceso> colaBloqueados;
	 private List<Proceso> colaTerminados;
	 static final Logger logProcesses = Logger.getLogger("processesLogger");
	 static final Logger logResults = Logger.getLogger("resultsLogger");
	 
	 
	 public AlgoritmoPlanificacion(int quantum, List<Proceso> colaListos) {
		 this.quantum = quantum;
		 this.quantumSobrante = 0;
		 this.colaListos = new ArrayList<Proceso>(colaListos);
		 this.colaBloqueados = new ArrayList<Proceso>();
		 this.colaTerminados = new ArrayList<Proceso>();
		 this.ejecuciones = 0;
		 PropertyConfigurator.configure("log4j.properties");
		 
		 this.procesarCola();
	 }
	 
	
	 public List<Proceso> getListaColaTerminados(){
		 return this.colaTerminados;
	 }
	 
	 public List<Proceso> getListaColaListos(){
		 return this.colaListos;
	 }
	 
	 private void procesarCola() {
		//Mientras exista una proceso sin terminar se seguigan ejecutando los procesos.
		 while(colaListos.size()!=0 || colaBloqueados.size()!=0) { 
			 trabajarProcesos();
		 }
	 }
	 
	 private void trabajarProcesos() {
		 Proceso p = this.primeroColaListos();
		 //Ejecuto proceso que no llego a consumir el quantum
		
		 if(ejecuciones <= (quantum + quantumSobrante) && p!=null) {
			 if(quantumSobrante>0) {
				 quantumSobrante -=1;
			 }
			 p.ejecucionProceso();
			 ejecuciones += 1;
			 this.logProcesses.debug("Process: " + String.valueOf(p.getId()) + " ejecutando.");
			 if(p.isBloqueado() || p.isTerminado()) {
				 //Si al terminar la ejecucion el proceso no llega a consumir todo el quantum, esa diferencia la aprobecha elproximo proceso.
				 if(ejecuciones < (quantum + quantumSobrante) ) {
					 quantumSobrante += (quantum + quantumSobrante) - ejecuciones;
				 }
				//Si el proceso termino de ejecutar reinica el quantum
				 ejecuciones = 0;
			 }
			
			 
		 }
		 //Los procesos que llegan al limite del quantum se agregar al final de la colaListos
		 else{
			 
			 if(p!=null) {
				 ejecuciones=0;
				 colaListos.remove(p);
				 colaListos.add(p); 
			 }
			 
		 }
		 //Procesos Bloqueados ejecutan procedimientos de E/S
		 for(Proceso pBloqueado : colaBloqueados) {
			 pBloqueado.ejecucionES();
		 }
		this.reposicionarProcesos();
	 }
	 
	 //Reposiciono los procesos en sus colas correspondientes
	 private void reposicionarProcesos() {
		 //Los procesos que no esten bloqueado en la cola de bloqueados pasan a la cola de listos
		 List<Proceso> procesosListos = new ArrayList<Proceso>();
		 for(Proceso p : colaBloqueados) {
			 if(!p.isBloqueado()) {
				 procesosListos.add(p);
			 }	
		 }
		 for(Proceso p : procesosListos) {
			 colaBloqueados.remove(p);
			 colaListos.add(p);
			 this.logProcesses.debug("Process: " + String.valueOf(p.getId()) + " registrado en Cola de Listos.");
		 }
		 
		 //Los procesos bloqueados en cola de listas pasan a la cola de bloqueados
		 List<Proceso> procesosBloqueados = new ArrayList<Proceso>();
		 List<Proceso> procesosTerminados = new ArrayList<Proceso>();
		 for(Proceso proceso : colaListos) {
			 if(proceso.isBloqueado()) {
				 procesosBloqueados.add(proceso);
				 this.logProcesses.debug("Process: " + String.valueOf(proceso.getId()) + " bloqueo de Entrada/Salida."); 
			 }
			//Los procesos terminados pasan a la cola de terminados
			 if (proceso.isTerminado()) {
				 procesosTerminados.add(proceso);
				 this.logProcesses.debug("Process: " + String.valueOf(proceso.getId()) + " terminado.");
				 this.logResults.debug("Proceso " + String.valueOf(proceso.getId()) +  " - I/O Blocking > " + String.valueOf(proceso.getIoBlocking()) 
				 		+ " - Cantidad de Bloqueos > " + String.valueOf(proceso.getCantBloqueos()));
			 }
			
		 }
		 
		 for(Proceso p : procesosBloqueados) {
			 colaBloqueados.add(p);
			 colaListos.remove(p);
		 }
		 
		 for(Proceso p : procesosTerminados) {
			 colaTerminados.add(p);
			 colaListos.remove(p);
		 }
		 
		 
	 }
	 
	 //Este metodo busca siempre al proximo proceso que este en la lista//
	 
	 private Proceso primeroColaListos() {
		 Proceso p =null;
		 int i=0;
		 boolean encontrado=false;
		 while(i<colaListos.size() && encontrado==false) {
			 if(colaListos.get(i)!=null) {
				 encontrado=true;
				 p = colaListos.get(i);
			 }
			 i++;
		 }
		 return p;
	 }
	 
	
	 
	 
	 
	 
	 

}
