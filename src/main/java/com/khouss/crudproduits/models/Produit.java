package com.khouss.crudproduits.models;


import jakarta.persistence.*;

import lombok.NoArgsConstructor;


@Entity
@Table(name="PRODUIT")

@NoArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @Column(length = 50)
    private String nom;
    @Column(length = 150)
    private String description;

    private Integer prix;


    public Produit(String nom, String description, Integer prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }
}
