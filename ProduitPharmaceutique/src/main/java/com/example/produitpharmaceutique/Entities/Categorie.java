package com.example.produitpharmaceutique.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity @Data
public class Categorie
{
    @Id @GeneratedValue private Long id;

    @OneToMany(mappedBy = "categorie") @JsonIgnore @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Produit> produits;

    private String lib;
}
