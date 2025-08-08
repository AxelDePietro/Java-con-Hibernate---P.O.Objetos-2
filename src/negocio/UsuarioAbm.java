package negocio;

import dao.UsuarioDao;
import datos.Usuario;


public class UsuarioAbm {
	
	private static UsuarioAbm instancia = null; 
	private UsuarioDao dao; 
	protected UsuarioAbm() {
		dao = UsuarioDao.getInstance();
	}
	
	public static UsuarioAbm getInstance() {
		if(instancia == null)
			instancia = new UsuarioAbm();
		return instancia; 
	}
	
	public int crearUsuario(Usuario u) {
		
		if (u == null) {
			throw new IllegalArgumentException("El usuario no puede ser nulo.");
		}
		
		Usuario existente = dao.traerUsuarioPorDni(u.getDni());
		if (existente != null) {
			throw new RuntimeException("Ya existe un usuario con el DNI: " + u.getDni());
		}

		
		
		return dao.crearUsuario(u);
	}
	
	public void eliminarUsuario(Usuario u) {
		Usuario existe = dao.traerUsuario(u.getIdUsuario());
		if(existe == null) {
			throw new RuntimeException("El usuario no existe.");
		}
		dao.eliminarUsuario(u);
	}
	
	public void modificarUsuario(Usuario u) {
		Usuario existe = dao.traerUsuario(u.getIdUsuario());
		if(existe == null) {
			throw new RuntimeException("El usuario no existe.");
		}
		
		Usuario porDni = dao.traerUsuarioPorDni(u.getDni());
		if (porDni != null && porDni.getIdUsuario() != u.getIdUsuario()) {
			throw new RuntimeException("Ya existe otro usuario con el DNI: " + u.getDni());
		}
		dao.modificarUsuario(u);
	}
	
	public Usuario traerUsuario(int idUsuario) {
		return dao.traerUsuario(idUsuario);
	}
	
	
	
    
}
	
