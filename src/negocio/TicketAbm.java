package negocio;

import java.util.List;
import java.time.LocalDateTime;

import dao.TicketDao;
import datos.Ticket;
import datos.Categoria;
import datos.Estado;
import datos.Prioridad;
import datos.Cliente;

public class TicketAbm {

	private TicketDao ticketDao = new TicketDao();

	public Ticket crearTicket(String titulo, String descripcion, Cliente cliente, Categoria categoria, Estado estado,
			Prioridad prioridad) throws Exception {
		List<Ticket> lstTickets = traerTodos();
		for(Ticket tkt : lstTickets) {
			if(tkt.getTitulo().equals(titulo) && tkt.getDescripcion().equals(descripcion)) throw new Exception("Error: el ticket ya existe\n\n");	
		}
		
		
		
		Ticket t = new Ticket();

		if (titulo == null || descripcion == null || cliente == null || categoria == null || estado == null
				|| prioridad == null) {
			throw new IllegalArgumentException("Todos los campos deben ser válidos.");
		}
		t.setTitulo(titulo);
		t.setDescripcion(descripcion);
		t.setFechaCreacion(LocalDateTime.now());
		t.setFechaCierre(null);
		t.setCliente(cliente);
		t.setCategoria(categoria);
		t.setPrioridad(prioridad);
		t.setEstado(estado);

		int id = ticketDao.crearTicket(t);
		t.setIdTicket(id); // Asignar ID generado
		return t;
	}

	public Ticket traerTicket(int idTicket) {
		// podrías agregar validaciones, logs, etc.
		return ticketDao.traerTicket(idTicket);
	}

	public List<Ticket> traerTodos() {
		return ticketDao.traerTodos();
	}

	public Ticket traerTicketYActualizaciones(int idTicket) {
		return ticketDao.traerTicketYActualizaciones(idTicket);
	}

	public void actualizarTicket(Ticket ticket) throws Exception {
		if (ticket == null || ticket.getIdTicket() <= 0) {
			throw new Exception("Ticket inválido.");
		}
		ticketDao.actualizar(ticket);
	}

	public void eliminarTicket(int idTicket) throws Exception {
		Ticket ticket = ticketDao.traerTicket(idTicket);
		if (ticket == null) {
			throw new Exception("El ticket no existe.");
		}
		ticketDao.eliminar(ticket);
	}
	
	
	
	
}