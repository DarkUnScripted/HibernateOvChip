package nl.hu.dp.data;

import nl.hu.dp.domain.Reiziger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO {

    private Session currentSession;

    private Session getCurrentSession() {
        return currentSession;
    }

    public ReizigerDAOHibernate( Session session ){
        this.currentSession = session;
    }

    @Override
    public boolean save(Reiziger reiziger) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().save(reiziger);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Reiziger reiziger) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().update(reiziger);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().delete(reiziger);
        transaction.commit();
        return true;
    }

    @Override
    public Reiziger findById(int id) {
        Reiziger reiziger = (Reiziger) getCurrentSession().get(Reiziger.class, id);
        return reiziger;
    }

    @Override
    public List<Reiziger> findByGbdatum(Date datum) {
        List<Reiziger> reizigers = (List<Reiziger>) getCurrentSession().createQuery("from Reiziger where geboortedatum = '" + datum + "'").list();
        return reizigers;
    }

    @Override
    public List<Reiziger> findAll() {
        List<Reiziger> reizigers = (List<Reiziger>) getCurrentSession().createQuery("from Reiziger").list();
        return reizigers;
    }
}
