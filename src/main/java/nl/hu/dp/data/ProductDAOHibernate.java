package nl.hu.dp.data;

import nl.hu.dp.domain.OVChipkaart;
import nl.hu.dp.domain.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAOHibernate implements ProductDAO {

    private Session currentSession;

    public ProductDAOHibernate(Session session) {
        this.currentSession = session;
    }

    private Session getCurrentSession() {
        return currentSession;
    }

    @Override
    public boolean save(Product product) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().save(product);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Product product) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().update(product);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Product product) {
        Transaction transaction = currentSession.beginTransaction();
        getCurrentSession().delete(product);
        transaction.commit();
        return true;
    }

    @Override
    public Product findByNummer(int id) {
        Product product = (Product) getCurrentSession().get(Product.class, id);
        return product;
    }

    @Override
    public List<Product> findByOvChipkaart(OVChipkaart ovChipkaart) {
        List<Product> producten = (List<Product>) getCurrentSession().createQuery("from Product where OVChipkaart = :ovChipkaart").setParameter("ovChipkaart", ovChipkaart).list();
        return producten;
    }

    @Override
    public List<Product> findAll() {
        List<Product> producten = (List<Product>) getCurrentSession().createQuery("from Product ").list();
        return producten;
    }
}
