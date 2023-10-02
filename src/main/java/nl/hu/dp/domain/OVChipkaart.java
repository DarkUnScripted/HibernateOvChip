package nl.hu.dp.domain;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name="ov_chipkaart")
public class OVChipkaart {
    @Id
    @Column(name="kaart_nummer")
    private int kaart_nummer;
    private Date geldig_tot;
    private String klasse;
    private double saldo;
    @ManyToOne
    @JoinColumn(name="reiziger_id")
    private Reiziger reiziger;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="ov_chipkaart_product",
                joinColumns = @JoinColumn(name="product_nummer"),
                inverseJoinColumns = @JoinColumn(name="kaart_nummer")
    )
    private List<Product> producten = new ArrayList<>();


    public void setKaart_nummer(int kaart_nummer) {
        this.kaart_nummer = kaart_nummer;
    }

    public int getKaart_nummer() {
        return kaart_nummer;
    }

    public void setGeldig_tot(Date geldig_tot) {
        this.geldig_tot = geldig_tot;
    }

    public Date getGeldig_tot() {
        return geldig_tot;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }

    public List<Product> getProducten() {
        return producten;
    }

    @Override
    public String toString() {
        return "OVChipkaart #" + this.kaart_nummer + "\n   geldig tot: " + this.geldig_tot + "\n   Saldo: " + this.saldo;
    }
}
