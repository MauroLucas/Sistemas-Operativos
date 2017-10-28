package modelo;

public class Proceso {
	
	private int cputime;
	private int cantBloqueo;
	private int cantCPU2;
	private boolean ejecutando;
	private boolean bloqueado;
	private boolean terminado;
	
	public Proceso(int cputime, int cantBloqueo, int cantCPU2, boolean ejecutando, boolean bloqueado,
			boolean terminado) {
		super();
		this.cputime = cputime;
		this.cantBloqueo = cantBloqueo;
		this.cantCPU2 = cantCPU2;
		this.ejecutando = ejecutando;
		this.bloqueado = bloqueado;
		this.terminado = terminado;
	}

	public int getCputime() {
		return cputime;
	}

	public void setCputime(int cputime) {
		this.cputime = cputime;
	}

	public int getCantBloqueo() {
		return cantBloqueo;
	}

	public void setCantBloqueo(int cantBloqueo) {
		this.cantBloqueo = cantBloqueo;
	}

	public int getCantCPU2() {
		return cantCPU2;
	}

	public void setCantCPU2(int cantCPU2) {
		this.cantCPU2 = cantCPU2;
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

}
