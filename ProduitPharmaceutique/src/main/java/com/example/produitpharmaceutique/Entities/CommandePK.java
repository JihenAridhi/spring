package com.example.produitpharmaceutique.Entities;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;


public class CommandePK implements Serializable
{
    private Produit produit;
    private Fournisseur fournisseur;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommandePK that = (CommandePK) o;
        return produit != null && Objects.equals(produit, that.produit)
                && fournisseur != null && Objects.equals(fournisseur, that.fournisseur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produit, fournisseur);
    }
}
