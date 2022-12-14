package com.example.produitpharmaceutique.Repositories;

import com.example.produitpharmaceutique.Entities.Fournisseur;
import com.example.produitpharmaceutique.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    public List<Fournisseur> findAllByUtilisateur(Utilisateur utl);
}