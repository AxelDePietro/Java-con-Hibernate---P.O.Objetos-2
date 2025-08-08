package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;

import datos.Ticket;


public class TicketDao {

    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        if (tx != null) tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos (TicketDao)", he);
    }

    // Crear Ticket
    public int crearTicket(Ticket t) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(t).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    // Traer un Ticket por ID
    public Ticket traerTicket(int idTicket) {
        Ticket t = null;
        try {
            iniciaOperacion();
            t = session.get(Ticket.class, idTicket);
            if (t != null) {
                // Fuerza la carga de las asociaciones lazy
                Hibernate.initialize(t.getCliente());
                Hibernate.initialize(t.getPrioridad());
                Hibernate.initialize(t.getEstado());
                Hibernate.initialize(t.getCategoria());
                Hibernate.initialize(t.getLstActualizaciones());
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
        return t;
    }

    // Traer todos los tickets
    public List<Ticket> traerTodos() {
        List<Ticket> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("FROM Ticket t " +
                    "JOIN FETCH t.categoria " +
                    "JOIN FETCH t.estado " +
                    "JOIN FETCH t.prioridad " +
                    "LEFT JOIN FETCH t.lstActualizaciones " +
                    "JOIN FETCH t.cliente", Ticket.class).list();

        } finally {
            session.close();
        }
        return lista;
    }

    // Actualizar Ticket
    public void actualizar(Ticket t) {
        try {
            iniciaOperacion();
            session.update(t);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    //Traer lista de actualizaciones
    public Ticket traerTicketYActualizaciones (int idTicket) throws HibernateException{
    	Ticket t = null;
    	try {
    		iniciaOperacion();
            String hql = "from Ticket t left join fetch t.lstActualizaciones a left join fetch a.empleado where t.idTicket = :idTicket";
    		t = (Ticket) session.createQuery(hql).setParameter("idTicket", idTicket).uniqueResult();
    	} finally {
    		session.close();
    	} return t;
    }
    // Eliminar Ticket
    public void eliminar(Ticket t) {
        try {
            iniciaOperacion();
            session.delete(t);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
}