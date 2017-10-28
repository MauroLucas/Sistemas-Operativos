package modelo;

public class Proceso {
	
	private int cpuTime;
	private int ioBlocking;
	private boolean ejecutando;
	private boolean bloqueado;
	private boolean terminado;
	
	public Proceso(int cpuTime, int ioBlocking, boolean ejecutando, boolean bloqueado, boolean terminado) {
		super();
		this.cpuTime = cpuTime;
		this.ioBlocking = ioBlocking;
		this.ejecutando = ejecutando;
		this.bloqueado = bloqueado;
		this.terminado = terminado;
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

}
