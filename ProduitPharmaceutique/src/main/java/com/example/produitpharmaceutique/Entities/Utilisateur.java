package com.example.produitpharmaceutique.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Data
public class Utilisateur
{
    @Id @GeneratedValue private Long id;

    @ManyToMany @JsonIgnore @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name="utl_prd", joinColumns = @JoinColumn, inverseJoinColumns = @JoinColumn)
    private List<Produit> produits;

    @OneToMany(mappedBy = "utilisateur") @JsonIgnore
    private List<Fournisseur> fournisseurs;

    private String nom;
    private String prenom;
    private String addresse;
    @Column(unique = true)
    private String email;
    private String motDePasse;
    private Long codePostal;
    private Date naissance;
}
