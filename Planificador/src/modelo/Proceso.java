package modelo;

public class Proceso {
	
	private int cantCPU1;
	private int cantBloqueo;
	private int cantCPU2;
	private boolean ejecutando;
	private boolean bloqueado;
	private boolean terminado;
	
	public Proceso(int cantCPU1, int cantBloqueo, int cantCPU2, boolean ejecutando, boolean bloqueado,
			boolean terminado) {
		super();
		this.cantCPU1 = cantCPU1;
		this.cantBloqueo = cantBloqueo;
		this.cantCPU2 = cantCPU2;
		this.ejecutando = ejecutando;
		this.bloqueado = bloqueado;
		this.terminado = terminado;
	}

	public int getCantCPU1() {
		return cantCPU1;
	}

	public void setCantCPU1(int cantCPU1) {
		this.cantCPU1 = cantCPU1;
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
