package test;

import negocio.CategoriaAbm;
import datos.Categoria;

public class TestCategoria {
    public static void main(String[] args) {
        CategoriaAbm abm = new CategoriaAbm();

        try {
            int id1 = abm.agregarCategoria("Soporte Técnico");
            int id2 = abm.agregarCategoria("Reclamo Administrativo");
            int id3 = abm.agregarCategoria("Redes y Conectividad");
            int id4 = abm.agregarCategoria("Consulta General");
            int id5 = abm.agregarCategoria("Telefonía IP");

            // Traer y mostrar las categorías creadas
            System.out.println("Categorías creadas:");
            System.out.println(abm.traerCategoria(id1));
            System.out.println(abm.traerCategoria(id2));
            System.out.println(abm.traerCategoria(id3));
            System.out.println(abm.traerCategoria(id4));
            System.out.println(abm.traerCategoria(id5));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
