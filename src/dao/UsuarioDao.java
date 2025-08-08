package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction; 

import datos.Usuario;
import datos.Empleado;
import datos.Cliente;

public class UsuarioDao {
	
	private static Session session; 
	private Transaction tx; 
	private static UsuarioDao instancia = null; 
	
	protected UsuarioDao() {}
	
	public static UsuarioDao getInstance() {
		if(instancia == null)
			instancia = new UsuarioDao();
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso a datos", he);
	}
	
	public int crearUsuario(Usuario u) {
		int id = 0; 
		try {
			iniciaOperacion();
			id = (int)session.save(u);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	public void eliminarUsuario(Usuario u) {
		try {
			iniciaOperacion();
			session.delete(u);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void modificarUsuario(Usuario u) {
		try {
			iniciaOperacion();
			session.update(u);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he; 
		}finally {
			session.close();
		}
	}
	
	public Usuario traerUsuario(int idUsuario) {
		Usuario u = null; 
		try {
			iniciaOperacion();
			u = (Usuario) session.get(Cliente.class, idUsuario);
			if (u == null) {
	            u = (Usuario) session.get(Empleado.class, idUsuario); // o Cliente.class
	        }
		}finally {
			session.close();
		}
		return u;
	}
	
	public Usuario traerUsuarioPorDni(int dni) {
		Usuario u = null; 
		try {
			iniciaOperacion();
			u = (Usuario) session.createQuery("from Usuario u where u.dni = :dni")
					.setParameter("dni", dni)
					.uniqueResult();
	        
		}finally {
			session.close();
		}
		return u;
	}
	
	

}
