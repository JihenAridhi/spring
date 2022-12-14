package com.example.produitpharmaceutique.Repositories;

import com.example.produitpharmaceutique.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>
{
    @Query(value = "select * from produit,utl_prd where id=produits_id and utilisateurs_id=:idU", nativeQuery = true)
    public List<Produit> findAllByUtilisateur(@Param(value = "idU") Long utl);


}