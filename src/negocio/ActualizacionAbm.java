package negocio;

import dao.ActualizacionDao;
import datos.Actualizacion;
import datos.Ticket;
import datos.Empleado;
import java.time.LocalDateTime;

public class ActualizacionAbm {

    private ActualizacionDao actualizacionDao = new ActualizacionDao();

	public Actualizacion agregarActualizacion(String contenido, Empleado empleado, Ticket ticket) throws Exception {
		if (contenido == null || contenido.trim().isEmpty()) {
			throw new Exception("El contenido de la actualizacion no puede estar vacío.");
		}
		
		Actualizacion actualizacion = new Actualizacion();
		actualizacion.setContenido(contenido);
		actualizacion.setFechaActualizacion(LocalDateTime.now());
		if (empleado == null) {
		    throw new Exception("El empleado no puede ser nulo.");
		}
		actualizacion.setEmpleado(empleado);
		if (ticket == null) {
		    throw new Exception("El ticket no puede ser nulo.");
		}
		actualizacion.setTicket(ticket);
		
		int id = actualizacionDao.crearActualizacion(actualizacion);
		actualizacion.setIdActualizacion(id);
		
	    // Agregar la actualización a la lista de actualizaciones del ticket
	    ticket.getLstActualizaciones().add(actualizacion);
		return actualizacion;
	}

    public Actualizacion traerActualizacion(int idActualizacion) {
        return actualizacionDao.traer(idActualizacion);
    }

    public void actualizarActualizacion(Actualizacion actualizacion) throws Exception {
    	if (actualizacion == null) {
    	    throw new Exception("La actualización no puede ser nula.");
    	}
        if (!actualizacionDao.estaAsociadaATickets(actualizacion.getIdActualizacion())) {
            throw new RuntimeException("No se puede modificar la prioridad porque no está asociada a tickets.");
        }
        actualizacionDao.actualizar(actualizacion);
    }

    public void eliminarActualizacion(int idActualizacion) throws Exception {
    	if (actualizacionDao.estaAsociadaATickets(idActualizacion)) {
            throw new Exception("No se puede eliminar la Actualizacion porque está asociada a tickets.");
        }
        Actualizacion actualizacion = actualizacionDao.traer(idActualizacion);
        if (actualizacion == null) {
            throw new Exception("Actualizacion no encontrada.");
        }
        actualizacionDao.eliminarActualizacion(actualizacion);
    }

}
