package com.example.produitpharmaceutique.Services;


import com.example.produitpharmaceutique.Entities.Fournisseur;
import com.example.produitpharmaceutique.Repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FournisseurService 
{
    @Autowired
    FournisseurRepository fr;

    @Transactional
    public List<Fournisseur> findAll() { return fr.findAll(); }

    @Transactional
    public Fournisseur findById(Long id) { return fr.getOne(id); }

    @Transactional
    public Fournisseur add(Fournisseur fournisseur) { return fr.save(fournisseur); }

    @Transactional
    public void deleteById(Long id) { Fournisseur fournisseur=fr.getOne(id); fr.delete(fournisseur); }

    @Transactional
    public Fournisseur update(Long id, Fournisseur fournisseur)
    {
        fournisseur.setId(id);
        if(fournisseur.getEmail()==null && findById(id).getEmail()!=null)
            fournisseur.setEmail(findById(id).getEmail());
        if(fournisseur.getNom()==null && findById(id).getNom()!=null)
            fournisseur.setNom(findById(id).getNom());
        if(fournisseur.getTel()==0 && findById(id).getTel()!=0)
            fournisseur.setTel(findById(id).getTel());
        if(fournisseur.getAddresse()==null && findById(id).getAddresse()!=null)
            fournisseur.setAddresse(findById(id).getAddresse());
        if(fournisseur.getUtilisateur()==null && findById(id).getUtilisateur()!=null)
            fournisseur.setUtilisateur(findById(id).getUtilisateur());
        if(fournisseur.getCommandes()==null && findById(id).getCommandes()!=null)
            fournisseur.setCommandes(findById(id).getCommandes());
        if(fournisseur.getFactures()==null && findById(id).getFactures()!=null)
            fournisseur.setFactures(findById(id).getFactures());
        return add(fournisseur);
    }
}
