package com.example.produitpharmaceutique.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Data
public class Facture
{
    @Id @GeneratedValue private Long id;
    @ManyToMany @JsonIgnore @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name="prd_fact", joinColumns=@JoinColumn, inverseJoinColumns=@JoinColumn)
    private List<Produit> produits;
    @ManyToOne @JsonIgnore
    private Fournisseur fournisseur;

    private Date date;
    private double ht;
    private double tva;
    private double ttc;
}
