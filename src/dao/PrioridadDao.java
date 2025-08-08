package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Prioridad;      

public class PrioridadDao {
    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos (PrioridadDao)", he);
    }

    public int agregar(Prioridad objeto) {
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

    public Prioridad traer(int idPrioridad) {
        Prioridad objeto = null;
        try {
            iniciaOperacion();
            objeto = (Prioridad) session.get(Prioridad.class, idPrioridad);
        } finally {
            session.close();
        }
        return objeto;
    }

    public void actualizar(Prioridad objeto) {
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

    public void eliminar(Prioridad objeto) {
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
    
    public Prioridad traerPorTipo(String tipo) {
        Prioridad prioridad = null;
        try {
            iniciaOperacion();
            prioridad = (Prioridad) session.createQuery("from Prioridad p where p.tipo = :tipo")
                                           .setParameter("tipo", tipo)
                                           .uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return prioridad;
    }
    
    public boolean estaAsociadaATickets(int idPrioridad) {
        boolean asociada = false;
        try {
            iniciaOperacion();
            Long cantidad = session.createQuery(
                "select count(t) from Ticket t where t.prioridad.id = :idPrioridad", Long.class)
                .setParameter("idPrioridad", idPrioridad)
                .uniqueResult();
            asociada = cantidad > 0;
        } finally {
            session.close();
        }
        return asociada;
    }

}