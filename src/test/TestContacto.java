package test;

import negocio.ContactoAbm;
import negocio.UsuarioAbm;
import datos.Contacto;
import datos.Usuario;

public class TestContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		UsuarioAbm usuarioAbm = UsuarioAbm.getInstance();
		Usuario usuario = usuarioAbm.traerUsuario(1);
		System.out.println("Usuario: " + usuario);
		System.out.println(usuario.getIdUsuario());
		
		ContactoAbm contactoAbm = new ContactoAbm();
		
		contactoAbm.crearContacto(1122334455, "juancitoP@hotmail.com", usuario);
		
		
		System.out.println("contacto: " + contactoAbm.traerContacto(1));

	}

}
