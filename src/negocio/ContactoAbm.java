package negocio;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;
import datos.Usuario;

public class ContactoAbm {

    private static ContactoAbm instancia = null;
    private ContactoDao dao = new ContactoDao();
    
    public ContactoAbm() {
        dao = ContactoDao.getInstance(); // Usar instancia única de ContactoDao
    }
    

    public static ContactoAbm getInstance() {
        if (instancia == null)
            instancia = new ContactoAbm();
        return instancia;
    }

    public int crearContacto(int numero, String mail, Usuario usuario) {
    	
    	if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser null.");
        }
        if (mail == null) {
            throw new IllegalArgumentException("El email no puede estar vacío.");
        }
        Contacto existe = dao.traerContactoPorNumero(numero);
        if(existe != null) {
        	throw new IllegalArgumentException("El contacto ya existe.");
        }
		Contacto c = new Contacto(numero, mail, usuario);
		return dao.crearContacto(c);
		}
	

    public void eliminarContacto(int idContacto) {
        Contacto c = dao.traerContacto(idContacto);
        if (c == null) {
            throw new RuntimeException("Contacto no encontrado.");
        }
        dao.eliminarContacto(c);
    }

    public void modificarContacto(Contacto c) {
        Contacto existe = dao.traerContacto(c.getIdContacto());
        if (existe == null) {
            throw new RuntimeException("Contacto no encontrado.");
        }
        dao.modificarContacto(c);
    }

    public Contacto traerContacto(int idContacto) {
        return dao.traerContacto(idContacto);
    }
}
