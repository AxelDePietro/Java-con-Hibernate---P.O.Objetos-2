package datos;

import java.time.LocalDateTime;
import java.util.Set;

public class Ticket {

	private int idTicket;

	private String titulo;

	private String descripcion;

	private LocalDateTime fechaCreacion;

	private LocalDateTime fechaCierre;

	
	private Categoria categoria;

	private Estado estado;

	private Prioridad prioridad;
	
	private Set<Ticket> lstTickets;
	private Set<Actualizacion> lstActualizaciones;
	
	private Cliente cliente;
	
	public Ticket() {
	}

	public Ticket(String titulo, String descripcion, LocalDateTime fechaCreacion, LocalDateTime fechaCierre, Cliente cliente, Categoria categoria, Estado estado,
			Prioridad prioridad) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaCierre = fechaCierre;
		this.categoria = categoria;
		this.estado = estado;
		this.prioridad = prioridad;
		this.cliente = cliente;
	}

	// Getters y Setters

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDateTime fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
	
	public Set<Ticket> getLstTickets() {
	    return lstTickets;
	}

	public void setLstTickets(Set<Ticket> lstTickets) {
	    this.lstTickets = lstTickets;
	}
	
	public Set<Actualizacion> getLstActualizaciones() {
	    return lstActualizaciones;
	}

	public void setLstActualizaciones(Set<Actualizacion> lstActualizacion) {
	    this.lstActualizaciones = lstActualizacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
	    return "Ticket {\n" +
	           "  idTicket: " + idTicket + ",\n" +
	           "  titulo: \"" + titulo + "\",\n" +
	           "  descripcion: \"" + descripcion + "\",\n" +
	           "  fechaCreacion: " + fechaCreacion + ",\n" +
	           "  fechaCierre: " + fechaCierre + ",\n" +
	           "  categoria: " + categoria + ",\n" +
	           "  estado: " + estado + ",\n" +
	           "  prioridad: " + prioridad + ",\n" +
	           "  cliente: " + (cliente != null ? cliente.toString() : "null") + "\n" +
	           "}";
	}
	
}