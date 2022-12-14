package com.example.produitpharmaceutique.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Data
public class Produit
{
    @Id @GeneratedValue private Long id;
    @ManyToMany(mappedBy = "produits") @JsonIgnore @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Facture> factures;
    @ManyToMany(mappedBy = "produits") @JsonIgnore @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Utilisateur> utilisateurs;
    @ManyToOne @JsonIgnore private Categorie categorie;
    @ManyToOne @JsonIgnore private Laboratoire laboratoire;
    @OneToMany(mappedBy = "produit") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    private List<Commande> commandes;

    private String lib;
    private String description;
    private Double prix;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateAjout;
    private Float prixLiv;
}
