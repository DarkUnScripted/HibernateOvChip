package nl.hu.dp;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;
import nl.hu.dp.data.*;
import nl.hu.dp.domain.Adres;
import nl.hu.dp.domain.Reiziger;
import nl.hu.dp.domain.Product;
import nl.hu.dp.domain.OVChipkaart;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

/**
 * Testklasse - deze klasse test alle andere klassen in deze package.
 *
 * System.out.println() is alleen in deze klasse toegestaan (behalve voor exceptions).
 *
 * @author tijmen.muller@hu.nl
 */
public class Main {
    // Creëer een factory voor Hibernate sessions.
    private static final SessionFactory factory;

    static {
        try {
            // Create a Hibernate session factory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retouneer een Hibernate session.
     *
     * @return Hibernate session
     * @throws HibernateException
     */
    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
        testFetchAll();
        testDAOHibernate();
    }
    /**
     * P6. Haal alle (geannoteerde) entiteiten uit de database.
     */
    private static void testFetchAll() {
        Session session = getSession();
        try {
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                Query query = session.createQuery("from " + entityType.getName());

                System.out.println("[Test] Alle objecten van type " + entityType.getName() + " uit database:");
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    private static void testDAOHibernate(){
        Session session = getSession();
        ReizigerDAO reizigerDAOHibernate = new ReizigerDAOHibernate(session);
        AdresDAO adresDAOHibernate = new AdresDAOHibernate(session);
        OVChipkaartDAO ovChipkaartDAOHibernate = new OVChipkaartDAOHibernate(session);
        ProductDAO productDAOHibernate = new ProductDAOHibernate(session);

        Reiziger reiziger = reizigerDAOHibernate.findById(1);
        System.out.println(reiziger);
        reiziger.setAchternaam("Haks");
        System.out.println(reizigerDAOHibernate.update(reiziger));
        System.out.println(reizigerDAOHibernate.findAll());
        System.out.println(reizigerDAOHibernate.findByGbdatum(new Date(2002, 9, 17)));

        Adres adres = adresDAOHibernate.findById(1);
        System.out.println(adres);
        adres.setHuisnummer("23");
        System.out.println(adresDAOHibernate.update(adres));
        System.out.println(adresDAOHibernate.findAll());
        System.out.println(adresDAOHibernate.findByReiziger(reiziger));

        OVChipkaart ovChipkaart = ovChipkaartDAOHibernate.findByKaartnummer(68514);
        System.out.println(ovChipkaart);
        ovChipkaart.setSaldo(0.20);
        System.out.println(ovChipkaartDAOHibernate.update(ovChipkaart));
        System.out.println(ovChipkaartDAOHibernate.findAll());
        System.out.println(ovChipkaartDAOHibernate.findByReiziger(reiziger));

        Product product = productDAOHibernate.findByNummer(6);
        System.out.println(product);
        product.setPrijs(1.20);
        System.out.println(productDAOHibernate.update(product));
        System.out.println(productDAOHibernate.findAll());
        System.out.println(productDAOHibernate.findByOvChipkaart(ovChipkaart));
    }
}
