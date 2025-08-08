package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Categoria;

public class CategoriaDao {
    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos (CategoriaDao)", he);
    }
    
    public int agregar(Categoria objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }    
    
    public Categoria traer(int idCategoria) {
        Categoria objeto = null;
        try {
            iniciaOperacion();
            objeto = (Categoria) session.get(Categoria.class, idCategoria);
        } finally {
            session.close();
        }
        return objeto;
    }
    
    public void actualizar(Categoria objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public void eliminar(Categoria objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    public boolean estaAsociadaATickets(int idCategoria) {
        boolean asociada = false;
        try {
            iniciaOperacion();
            Long cantidad = session.createQuery(
                "select count(t) from Ticket t where t.categoria.id = :idCategoria", Long.class)
                .setParameter("idCategoria", idCategoria)
                .uniqueResult();
            asociada = cantidad > 0;
        } finally {
            session.close();
        }
        return asociada;
    }


}
