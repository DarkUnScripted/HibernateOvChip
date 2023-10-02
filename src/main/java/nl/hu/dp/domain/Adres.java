package nl.hu.dp.domain;


import jakarta.persistence.*;

@Entity
@Table( name = "adres" )
public class Adres {
    @Id
    @Column(name="adres_id")
    int id;
    String postcode;
    String huisnummer;
    String straat;
    String woonplaats;
    @OneToOne
    @JoinColumn(name="reiziger_id")
    Reiziger reiziger;

    public Adres(){ }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setReiziger(Reiziger reiziger){
        this.reiziger = reiziger;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getStraat() {
        return straat;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    @Override
    public String toString() {
        return "Adress #" + this.id + "\n   Postcode: " + this.postcode + "\n   Huisnummer: " + this.huisnummer;
    }
}
