package test;

import datos.Usuario;
import datos.Cliente;
import datos.Empleado;
import negocio.UsuarioAbm;

public class TestUsuario {

	public static void main(String[] args) {
		
		
		// Crear un Cliente
        Cliente cliente = new Cliente("Juan", "Pérez", 12345678, null, 1001);
        
        // Crear un Empleado
        Empleado empleado = new Empleado("Ana", "Gómez", 87654321, null, "Manager", "12345");
        
        // Usar el ABM para crear los usuarios
        UsuarioAbm usuarioAbm = UsuarioAbm.getInstance();
        
        // Guardar Cliente
        
        try {
        int idCliente = usuarioAbm.crearUsuario(cliente);
        System.out.println("Cliente creado con ID: " + idCliente);
        
        // Guardar Empleado
        int idEmpleado = usuarioAbm.crearUsuario(empleado);
        System.out.println("Empleado creado con ID: " + idEmpleado);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        
        
        // Traemos un Cliente por ID
        Usuario clienteRecuperado = usuarioAbm.traerUsuario(1); 
        if (clienteRecuperado != null) {
            System.out.println("Cliente recuperado: " + clienteRecuperado);
        }
        
        // Traemos un Empleado por ID
        Usuario empleadoRecuperado = usuarioAbm.traerUsuario(2); 
        if (empleadoRecuperado != null) {
            System.out.println("Empleado recuperado: " + empleadoRecuperado);
        }
        
		
		/*
		
		  Usuario usuarioAEliminar = usuarioAbm.traerUser(3);
	        if (usuarioAEliminar != null) {
	            usuarioAbm.eliminarUsuario(usuarioAEliminar);
	            System.out.println("Usuario con ID " + 3 + " ha sido eliminado.");
	        } else {
	            System.out.println("Usuario no encontrado.");
	        }
	        
	        */

	}

}
