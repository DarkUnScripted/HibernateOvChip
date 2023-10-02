package nl.hu.dp.data;

import nl.hu.dp.domain.OVChipkaart;
import nl.hu.dp.domain.Product;
import nl.hu.dp.domain.Reiziger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO{

    private Session currentSession;

    public OVChipkaartDAOHibernate(Session session){
        this.currentSession = session;
    }

    private Session getCurrentSession() {
        return currentSession;
    }

    @Override
    public boolean save(OVChipkaart ovChipkaart) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().save(ovChipkaart);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(OVChipkaart ovChipkaart) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().update(ovChipkaart);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(OVChipkaart ovChipkaart) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().delete(ovChipkaart);
        transaction.commit();
        return true;
    }

    @Override
    public ArrayList<OVChipkaart> findByReiziger(Reiziger reiziger) {
        ArrayList<OVChipkaart> ovChipkaarten = (ArrayList<OVChipkaart>) getCurrentSession().createQuery("from OVChipkaart where reiziger  = "  +  reiziger.getId()).list();
        return ovChipkaarten;
    }

    @Override
    public List<OVChipkaart> findAll() {
        ArrayList<OVChipkaart> ovChipkaarten = (ArrayList<OVChipkaart>) getCurrentSession().createQuery("from OVChipkaart").list();
        return ovChipkaarten;
    }

    @Override
    public OVChipkaart findByKaartnummer(int nummer) {
        OVChipkaart ovChipkaart = (OVChipkaart) getCurrentSession().get(OVChipkaart.class, nummer);
        return ovChipkaart;
    }

    @Override
    public ArrayList<OVChipkaart> findByProduct(Product product) {
        ArrayList<OVChipkaart> ovChipkaarten = (ArrayList<OVChipkaart>) getCurrentSession().createQuery("from OVChipkaart where producten  = "  + product).list();
        return ovChipkaarten;
    }
}
