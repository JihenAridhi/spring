package com.example.produitpharmaceutique.Repositories;

import com.example.produitpharmaceutique.Entities.Categorie;
import com.example.produitpharmaceutique.Entities.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {
    public Laboratoire findByLib(String lib);
}