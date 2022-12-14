package com.example.produitpharmaceutique.Repositories;

import com.example.produitpharmaceutique.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>
{
    public Categorie findByLib(String Lib);
}