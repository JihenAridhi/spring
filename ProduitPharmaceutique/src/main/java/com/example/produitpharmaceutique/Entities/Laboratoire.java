package com.example.produitpharmaceutique.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity @Data
public class Laboratoire
{
    @Id @GeneratedValue private Long id;

    @OneToMany(mappedBy = "laboratoire")
    @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    private List<Produit> produits;

    private String lib;
}
