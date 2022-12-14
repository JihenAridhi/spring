package com.example.produitpharmaceutique.Services;

import com.example.produitpharmaceutique.Entities.Fournisseur;
import com.example.produitpharmaceutique.Entities.Produit;
import com.example.produitpharmaceutique.Repositories.FournisseurRepository;
import com.example.produitpharmaceutique.Repositories.ProduitRepository;
import com.example.produitpharmaceutique.Repositories.UtilisateurRepository;
import com.example.produitpharmaceutique.Entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurService
{
    @Autowired
    UtilisateurRepository ur;
    @Autowired
    ProduitRepository pr;
    @Autowired
    FournisseurRepository fr;

    @Transactional
    public List<Utilisateur> findAll() { return ur.findAll(); }

    @Transactional
    public Utilisateur findById(Long id) { return ur.getOne(id); }

    @Transactional
    public Utilisateur findByEmailAndMotDePasse(String email, String mdp) { return ur.findByEmailAndMotDePasse(email,mdp); }

    @Transactional
    public Utilisateur add(Utilisateur utilisateur) { return ur.save(utilisateur); }

    @Transactional
    public void deleteById(Long id) { Utilisateur utilisateur=ur.getOne(id); ur.delete(utilisateur); }

    @Transactional
    public void ajoutProduit(Long utl, Produit produit)
    {
        pr.save(produit);
        findById(utl).getProduits().add(produit);
        add(findById(utl));
    }

    @Transactional
    public void suppProduit(Long utl, Produit produit)
    {
        pr.delete(produit);
        findById(utl).getProduits().remove(produit);
    }

    @Transactional
    public List<Produit> getListeProduits(Long utl) { return pr.findAllByUtilisateur(utl);}

    @Transactional
    public List<Produit> chercherProduit(Long utl, String motCle)
    {

        List<Produit> l = new ArrayList<>();
        for(Produit p: getListeProduits(utl))
            if(p.getId().toString().contains(motCle.toLowerCase()) ||
            p.getLib().contains(motCle.toLowerCase()) )
            //p.getCategorie().getLib().contains(motCle) ||
                //p.getLaboratoire().getLib().contains(motCle.toLowerCase());
                l.add(p);
        return l;
    }

    public void ajoutFournisseur(Long utl, Fournisseur fournisseur)
    {
        fournisseur.setUtilisateur(findById(utl));
        fr.save(fournisseur);
        add(findById(utl));
    }

    @Transactional
    public void suppFournisseur(Long utl, Fournisseur fournisseur)
    {
        fr.delete(fournisseur);
        findById(utl).getFournisseurs().remove(fournisseur);
    }

    @Transactional
    public List<Fournisseur> getListeFournisseurs(Long utl) { return fr.findAllByUtilisateur(findById(utl));}

    @Transactional
    public List<Fournisseur> chercherFournisseur(Long utl, String motCle)
    {

        List<Fournisseur> l = new ArrayList<>();
        for(Fournisseur f: getListeFournisseurs(utl))
            if(f.getId().toString().contains(motCle.toLowerCase()) ||
                    f.getNom().contains(motCle.toLowerCase()) ||
                f.getTel().toString().contains(motCle) ||
                f.getAddresse().contains(motCle.toLowerCase()))
                l.add(f);
        return l;
    }

}
