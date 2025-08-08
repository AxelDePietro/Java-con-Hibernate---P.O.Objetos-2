package negocio;

import dao.EstadoDao;
import datos.Estado;

public class EstadoAbm {
	
	private EstadoDao dao = new EstadoDao();
	
	public int crearEstado(String tipo) throws Exception {
		Estado estadoExistente = traerEstadoPorTipo(tipo);
		// Si el estado ya existe, se lanza una excepción con el estado existente
		if(estadoExistente!=null) throw new Exception ("Error: el estado ya existe, " + estadoExistente);
		
    	Estado estado = new Estado();
    	estado.setTipo(tipo);
        return dao.crearEstado(estado);
	}
	
	public void actualizarEstado(Estado e) {
		Estado existe = dao.traerEstado(e.getIdEstado());
		if(existe == null) {
			// Si el estado no se encuentra, se lanza una excepción con el mensaje adecuado
			throw new RuntimeException("Error, el estado no existe.");
		}
		dao.actualizarEstado(e);
	}
	
	public Estado traerEstado(int idEstado) {
		Estado estado = dao.traerEstado(idEstado);
        if (estado == null) {
            // Si no se encuentra el estado con el ID proporcionado, se lanza una excepción.
            throw new RuntimeException("Error: el estado con ID " + idEstado + " no existe.");
        }
		return dao.traerEstado(idEstado);
	}
	
	public Estado traerEstadoPorTipo(String tipo) {
		return dao.traerEstadoPorTipo(tipo);
	}

}
