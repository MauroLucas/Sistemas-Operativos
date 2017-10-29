package modelo;

public class Proceso {
	
	private int id;
	private int cpuTime;
	private int ioBlocking;
	private int cantEjecuciones;
	
	private boolean ejecutando;
	private boolean bloqueado;
	private boolean terminado;
	
	public Proceso(int id,int cpuTime, int ioBlocking, boolean ejecutando, boolean bloqueado, boolean terminado) {
		super();
		this.id=id;
		this.cpuTime = cpuTime;
		this.ioBlocking = ioBlocking;
		this.ejecutando = ejecutando;
		this.bloqueado = bloqueado;
		this.terminado = terminado;
		cantEjecuciones=0;
		
		
	}

	public int getCputime() {
		return cpuTime;
	}

	public void setCputime(int cputime) {
		this.cpuTime = cputime;
	}

	public int getCantBloqueo() {
		return ioBlocking;
	}

	public void setCantBloqueo(int ioBlocking) {
		this.ioBlocking = ioBlocking;
	}

	public boolean isEjecutando() {
		return ejecutando;
	}

	public void setEjecutando(boolean ejecutando) {
		this.ejecutando = ejecutando;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getIoBloquing() {
		return this.ioBlocking;
	}
	
	//Al llamar a este metodo se tendra en cuenta que el proceso ejecuta solo una vez procemiento de ES y 
	//dejara de estar bloqueado
	public void ejecucionES() {
		this.bloqueado=false;
	}
	
	public void ejecucionProceso() {
		this.cpuTime -= 1;
		this.cantEjecuciones +=1;
		if(this.cantEjecuciones==this.ioBlocking) {
			this.cantEjecuciones=0;
			this.bloqueado=true;
			
		}
		 if(this.cpuTime==0) {
		 	 this.bloqueado=false;
			 this.terminado=true;
		}
		
	}

	@Override
	public String toString() {
		return "Proceso [id=" + id + ", cpuTime=" + cpuTime + ", ioBlocking=" + ioBlocking + ", cantEjecuciones="
				+ cantEjecuciones + ", ejecutando=" + ejecutando + ", bloqueado=" + bloqueado + ", terminado="
				+ terminado + "]";
	}
	
	

}
