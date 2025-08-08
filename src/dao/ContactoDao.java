package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Contacto;

public class ContactoDao {

    private static Session session;
    private Transaction tx;
    private static ContactoDao instancia = null;

    public ContactoDao() {}

    public static ContactoDao getInstance() {
        if (instancia == null)
            instancia = new ContactoDao();
        return instancia;
    }

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Error en la capa de acceso a datos", he);
    }

    public int crearContacto(Contacto c) {
        int id = 0;
        try {
            iniciaOperacion();
            id = (int) session.save(c);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public Contacto traerContacto(int idContacto) {
        Contacto c = null;
        try {
            iniciaOperacion();
            c = session.get(Contacto.class, idContacto);
        } finally {
            session.close();
        }
        return c;
    }

    public void modificarContacto(Contacto c) {
        try {
            iniciaOperacion();
            session.update(c);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminarContacto(Contacto c) {
        try {
            iniciaOperacion();
            session.delete(c);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }
    
    public Contacto traerContactoPorNumero(int numero) {
        Session session = null;
        Contacto contacto = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            contacto = session.createQuery("from Contacto c where c.numero = :numero", Contacto.class)
                              .setParameter("numero", numero)
                              .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Error al buscar el contacto por número.");
        } finally {
            if (session != null) session.close();
        }

        return contacto;
    }
}
