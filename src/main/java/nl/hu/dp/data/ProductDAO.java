package nl.hu.dp.data;

import nl.hu.dp.domain.OVChipkaart;
import nl.hu.dp.domain.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductDAO {

    public boolean save(Product product);

    public boolean update(Product product);

    public boolean delete(Product product);

    public Product findByNummer(int id);

    public List<Product> findByOvChipkaart(OVChipkaart ovChipkaart);

    public List<Product> findAll();
}
