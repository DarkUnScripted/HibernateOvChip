package nl.hu.dp.data;

import nl.hu.dp.domain.Adres;
import nl.hu.dp.domain.Reiziger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class AdresDAOHibernate implements AdresDAO{

    private Session currentSession;

    public AdresDAOHibernate(Session session){
        this.currentSession = session;
    }

    private Session getCurrentSession() {
        return currentSession;
    }

    @Override
    public boolean save(Adres adres) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().save(adres);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Adres adres) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().update(adres);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Adres adres) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().delete(adres);
        transaction.commit();
        return true;
    }

    @Override
    public Adres findById(int id) {
        Adres adres = (Adres) getCurrentSession().get(Adres.class, id);
        return adres;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        Adres adres = (Adres) getCurrentSession().get(Adres.class, reiziger.getId());
        return adres;
    }

    @Override
    public List<Adres> findAll() {
        List<Adres> adresses = (List<Adres>) getCurrentSession().createQuery("from Adres").list();
        return adresses;
    }
}
