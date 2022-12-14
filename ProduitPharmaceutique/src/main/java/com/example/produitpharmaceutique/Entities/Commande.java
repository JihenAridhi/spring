package com.example.produitpharmaceutique.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Entity @Data @IdClass(CommandePK.class)
public class Commande
{
    @ManyToOne @Id @JsonIgnore
    private Produit produit;

    @ManyToOne @Id @JsonIgnore
    private Fournisseur fournisseur;

    private int Qte;
    private Date date;
}
