package datos;

import java.util.Set;

public class Cliente extends Usuario {
	
	private int nroCliente; 

	private Set<Ticket> tickets;
	
	public Cliente() {
	}
	
	public Cliente(String nombre, String apellido, int dni, Contacto contacto, int nroCliente) {
		super(nombre, apellido, dni, contacto);
		this.nroCliente = nroCliente;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}
	
	public Set<Ticket> getTickets() {
	    return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
	    this.tickets = tickets;
	}

	@Override
	public String toString() {
	    return "Cliente {\n" +
	           "  nroCliente: " + nroCliente + "\n" +
	           "}";
	}
	
}
