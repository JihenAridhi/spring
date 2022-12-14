package com.example.produitpharmaceutique.Repositories;

import com.example.produitpharmaceutique.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>
{
    public Utilisateur findByEmailAndMotDePasse(String email, String mdp);
}