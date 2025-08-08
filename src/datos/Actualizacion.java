package datos;

import java.time.LocalDateTime;

public class Actualizacion {
	
	private int idActualizacion;
	private String contenido;
	private LocalDateTime fechaActualizacion;
	private Empleado empleado;
	private Ticket ticket;
	
	
	public Actualizacion() {
		
	}
	
	public  Actualizacion (String contenido, LocalDateTime fechaActualizacion, Empleado empleado, Ticket ticket) {
		super();
		this.contenido = contenido;
		this.fechaActualizacion = fechaActualizacion;
		this.empleado = empleado;
		this.ticket = ticket;
	}
	
	
	//Getters y Setters
	public int getIdActualizacion() {
		return idActualizacion;
	}
	public void setIdActualizacion(int idActualizacion) {
		this.idActualizacion = idActualizacion;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String toString() {
	    return "Actualizacion {\n" +
	           "  idActualizacion: " + idActualizacion + ",\n" +
	           "  contenido: \"" + contenido + "\",\n" +
	           "  fechaActualizacion: " + fechaActualizacion + ",\n" +
	           "  empleado: " + (empleado != null ? empleado.getNombre() + " " + empleado.getApellido() : "null") + ",\n" +
	           "  ticket: " + (ticket != null ? "ID=" + ticket.getIdTicket() + ", título=\"" + ticket.getTitulo() + "\"" : "null") + "\n" +
	           "}";
	}
	

}
