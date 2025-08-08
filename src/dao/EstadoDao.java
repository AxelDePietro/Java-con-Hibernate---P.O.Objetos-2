package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Estado;

public class EstadoDao {

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos (EstadoDao)", he);
	}

	public int crearEstado(Estado e) {
		int id = 0;
		try {
			iniciaOperacion();
			id = (int) session.save(e);
			tx.commit(); // Commit de la transacción
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he; // Rethrow de la excepción para que la capa superior pueda manejarla
		} finally {
			// Cierra la sesión solo si está abierta
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return id;
	}

	public void actualizarEstado(Estado e) {
		try {
			iniciaOperacion();
			session.update(e);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Estado traerEstado(int idEstado) {
		Estado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Estado) session.get(Estado.class, idEstado);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Estado traerEstadoPorTipo(String tipo) {
		Estado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Estado) session.createQuery("FROM Estado e WHERE e.tipo = :tipo", Estado.class)
					.setParameter("tipo", tipo).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

}
