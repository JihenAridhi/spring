package com.example.produitpharmaceutique.Services;

import com.example.produitpharmaceutique.Entities.Produit;
import com.example.produitpharmaceutique.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProduitService
{
    @Autowired
    ProduitRepository pr;
    @Transactional
    public List<Produit> findAll() { return pr.findAll(); }
    @Transactional
    public Produit findById(Long id) { return pr.getOne(id); }
    @Transactional
    public Produit add(Produit produit)
    { return pr.save(produit); }
    @Transactional
    public void deleteById(Long id) { Produit produit=pr.getOne(id); pr.delete(produit); }
    @Transactional
    public Produit update(Long id, Produit produit)
    {
        if(!findById(id).getLib().equals(produit.getLib()) && produit.getLib()!=null)
            findById(id).setLib(produit.getLib());
        if(!findById(id).getDateAjout().equals(produit.getDateAjout()) && produit.getDateAjout()!=null)
            findById(id).setDateAjout(produit.getDateAjout());
        if(!findById(id).getDescription().equals(produit.getDescription()) && produit.getDescription()!=null)
            findById(id).setDescription(produit.getDescription());
        //if(!findById(id).getCategorie().equals(produit.getCategorie()) && produit.getCategorie()!=null)
        //    findById(id).setCategorie(produit.getCategorie());
        //if(!findById(id).getLaboratoire().equals(produit.getLaboratoire()) && produit.getLaboratoire()!=null)
        //    findById(id).setLaboratoire(produit.getLaboratoire());
        if(!findById(id).getPrix().equals(produit.getPrix()) && produit.getPrix()!=null)
            findById(id).setPrix(produit.getPrix());
        if(!findById(id).getPrixLiv().equals(produit.getPrixLiv()) && produit.getPrixLiv()!=null)
            findById(id).setPrixLiv(produit.getPrixLiv());
        return findById(id);
    }
}
