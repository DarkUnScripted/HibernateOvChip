package nl.hu.dp.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "reiziger" )
public class Reiziger {
    @Id
    @Column(name="reiziger_id")
    int id;
    String voorletters;
    String tussenvoegsel;
    String achternaam;
    Date geboortedatum;
    @OneToOne(mappedBy = "reiziger")
    Adres adres;
    @OneToMany(mappedBy = "reiziger")
    List<OVChipkaart> ovChipkaarten = new ArrayList<>();


    public Reiziger(){ }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getNaam(){
        return this.voorletters + ". " + this.tussenvoegsel + " " + this.achternaam;
    }

    public void setAdres(Adres adress) {
        this.adres = adres;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setOvChipkaarten(ArrayList<OVChipkaart> ovChipkaarten) {
        this.ovChipkaarten = ovChipkaarten;
    }

    public List<OVChipkaart> getOvChipkaarten() {
        return ovChipkaarten;
    }

    @Override
    public String toString() {
        if (adres != null) {
            return "Reiziger #" + this.id + "\nNaam: " + this.voorletters + ". " + this.achternaam + " (" + this.geboortedatum + ") \n" + this.adres.toString();
        }else{
            return "Reiziger #" + this.id + "\nNaam: " + this.voorletters + ". " + this.achternaam + " (" + this.geboortedatum + ") \n" + " No Adress found!";
        }
    }
}
