package com.example.produitpharmaceutique.Repositories;

import com.example.produitpharmaceutique.Entities.Commande;
import com.example.produitpharmaceutique.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Produit>
{
}