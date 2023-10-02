package nl.hu.dp.data;

import nl.hu.dp.domain.OVChipkaart;
import nl.hu.dp.domain.Product;
import nl.hu.dp.domain.Reiziger;

import java.util.ArrayList;
import java.util.List;

public interface OVChipkaartDAO {
    public boolean save(OVChipkaart ovChipkaart);

    public boolean update(OVChipkaart ovChipkaart);

    public boolean delete(OVChipkaart ovChipkaart);

    public ArrayList<OVChipkaart> findByReiziger(Reiziger reiziger);

    public List<OVChipkaart> findAll();

    public OVChipkaart findByKaartnummer(int nummer);

    public ArrayList<OVChipkaart> findByProduct(Product product);
}
