package test;

import datos.Actualizacion;
import datos.Empleado;
import datos.Ticket;
import negocio.ActualizacionAbm;
import negocio.UsuarioAbm;
import negocio.TicketAbm;


public class TestActualizacion {
    public static void main(String[] args) {
        try {
        	//Instanciar ABMs
        	UsuarioAbm usuarioAbm = UsuarioAbm.getInstance();
        	TicketAbm ticketAbm = new TicketAbm();
        	ActualizacionAbm actualizacionAbm   = new ActualizacionAbm();
        	
        	//Trae instancias
        	Empleado empleado = (Empleado) usuarioAbm.traerUsuario(2);
        	Ticket ticket = ticketAbm.traerTicket(1);
        	
        	
        	//Crea la actualizacion
        	Actualizacion actu1 = actualizacionAbm.agregarActualizacion("Se reseteo el password", empleado, ticket);
        	
        	int idActu1= actu1.getIdActualizacion();
            System.out.println("Actualización creada con ID: " + idActu1);
            
            
            //Traer y mostrar la actualizacion
            Actualizacion traerActu1 = actualizacionAbm.traerActualizacion(1);
            System.out.println("Primer actualizacion: " + traerActu1);
            
            traerActu1.setContenido("Esperando respuesta del Cliente");
            actualizacionAbm.actualizarActualizacion(traerActu1);
            System.out.println("Cambios realizados: "+ actualizacionAbm.traerActualizacion(1));
            
            
            /*
            //Eliminar
            actualizacionAbm.eliminarActualizacion(idActu1);
            System.out.println("Eliminada actualizacion ID "+ idActu1);
            */

        	}catch (Exception e) {
                e.printStackTrace();
            }
            
        }
}
