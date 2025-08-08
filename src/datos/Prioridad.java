package datos;

public class Prioridad {
	private int idPrioridad;
	private String tipo;
	private Ticket ticket;

	public Prioridad() {
		// TODO Auto-generated constructor stub
	}

	public Prioridad(String tipo, Ticket ticket) {
		super();
		this.tipo = tipo;
		this.ticket = ticket;
	}

	public int getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(int idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Prioridad [idPrioridad=" + idPrioridad + ", tipo=" + tipo + ", ticket=" + ticket + "]";
	}
	
	}

