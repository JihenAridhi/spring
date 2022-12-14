package com.example.produitpharmaceutique.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity @Data
public class Fournisseur
{
    @Id @GeneratedValue private Long id;

    @OneToMany(mappedBy = "fournisseur") @JsonIgnore @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Facture> factures;
    @ManyToOne @JsonIgnore
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "fournisseur") @JsonIgnore @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Commande> commandes;

    private String nom;
    private String addresse;
    private String email;
    private Long tel;
}
