package test;

import negocio.PrioridadAbm;
import datos.Prioridad;

public class TestPrioridad {
    public static void main(String[] args) {
        PrioridadAbm abm1 = new PrioridadAbm();
        PrioridadAbm abm2 = new PrioridadAbm();
        PrioridadAbm abm3 = new PrioridadAbm();

        // Agregar una prioridad
        int idAlta = abm1.agregarPrioridad("Alta");
        System.out.println("Prioridad agregada con ID: " + idAlta);

        int idBaja = abm2.agregarPrioridad("Baja");
        System.out.println("Prioridad agregada con ID: " + idBaja);

        int idMedia = abm3.agregarPrioridad("Media");
        System.out.println("Prioridad agregada con ID: " + idMedia);

        // Traerla y mostrarla
        Prioridad prioridad = abm1.traerPrioridad(idAlta);
        if (prioridad != null) {
            System.out.println("Prioridad existente: " + prioridad);
        } else {
            System.out.println("No se encontró la prioridad con ID: " + idAlta);
        }
        
        /*

        // Modificar la prioridad
        prioridad.setTipo("Muy Alta");
        try {
            abm1.modificarPrioridad(prioridad);
            System.out.println("Prioridad modificada a: " + prioridad.getTipo());
        } catch (RuntimeException e) {
            System.out.println("Error al modificar prioridad: " + e.getMessage());
        }

        // Eliminar la prioridad
        try {                                                      
            abm1.eliminarPrioridad(idAlta);
            System.out.println("Prioridad con ID " + idAlta + " eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar prioridad: " + e.getMessage());
        }
        */                                             
    } 
}
