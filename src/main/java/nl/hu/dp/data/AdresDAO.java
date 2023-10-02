package nl.hu.dp.data;

import nl.hu.dp.domain.Adres;
import nl.hu.dp.domain.Reiziger;

import java.io.Serializable;
import java.util.List;

public interface AdresDAO extends Serializable {
    public boolean save(Adres adress);

    public boolean update(Adres adress);

    public boolean delete(Adres adress);

    public Adres findById(int id);

    public Adres findByReiziger(Reiziger reiziger);

    public List<Adres> findAll();
}
