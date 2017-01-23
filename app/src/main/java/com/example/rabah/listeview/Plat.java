package com.example.rabah.listeview;


import java.io.Serializable;

public class Plat implements Serializable {
    private String prix;
    private String nom;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    private String des;





    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }


    public Plat(String prix, String nom,String image,String des) {
        this.prix = prix;
        this.nom = nom;
        this.des = des;
        this.image = image;

    }
}