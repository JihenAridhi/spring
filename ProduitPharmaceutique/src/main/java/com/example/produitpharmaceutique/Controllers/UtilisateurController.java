package com.example.produitpharmaceutique.Controllers;

import com.example.produitpharmaceutique.Entities.Fournisseur;
import com.example.produitpharmaceutique.Entities.Produit;
import com.example.produitpharmaceutique.Entities.Utilisateur;
import com.example.produitpharmaceutique.Services.FournisseurService;
import com.example.produitpharmaceutique.Services.ProduitService;
import com.example.produitpharmaceutique.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController
{
    @Autowired
    UtilisateurService us;
    @Autowired
    ProduitService ps;
    @Autowired
    FournisseurService fs;

    @GetMapping("findAll")
    public List<Utilisateur> findAll() { return us.findAll(); }

    @GetMapping("findById/{id}")
    public Utilisateur findById(@PathVariable Long id) { return us.findById(id); }

    @GetMapping("findByEmailAndMotDePasse/{email}/{mdp}")
    public Utilisateur findByEmailAndMotDePasse(@PathVariable String email, @PathVariable String mdp) { return us.findByEmailAndMotDePasse(email,mdp); }

    @PostMapping("add")
    public Utilisateur add(@RequestBody Utilisateur utilisateur) { return us.add(utilisateur); }

    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable Long id) {us.deleteById(id); return "success";}

    @PostMapping("{utl}/ajoutProduit")
    public void ajoutProduit(@PathVariable Long utl, @RequestBody Produit produit){ us.ajoutProduit(utl,produit); }

    @DeleteMapping("{utl}/suppProduit/{prd}")
    public void suppProduit(@PathVariable Long utl, @PathVariable Long prd) {us.suppProduit(utl,ps.findById(prd));}

    @GetMapping("{utl}/afficherListeProduits")
    public List<Produit> afficherListeProduits(@PathVariable Long utl) { return us.getListeProduits(utl); }

    @GetMapping("{utl}/chercherProduit/{motCle}")
    public List<Produit> chercherProduit(@PathVariable Long utl, @PathVariable String motCle) { return us.chercherProduit(utl,motCle); }

    @PostMapping("{utl}/ajoutFournisseur")
    public void ajoutFour(@PathVariable Long utl, @RequestBody Fournisseur fournisseur){ us.ajoutFournisseur(utl,fournisseur); }

    @DeleteMapping("{utl}/suppFournisseur/{fr}")
    public void suppFournisseur(@PathVariable Long utl, @PathVariable Long fr) {us.suppFournisseur(utl,fs.findById(fr));}

    @GetMapping("{utl}/afficherListeFournisseurs")
    public List<Fournisseur> afficherListeFournisseurs(@PathVariable Long utl) { return us.getListeFournisseurs(utl); }

    @GetMapping("{utl}/chercherFournisseur/{motCle}")
    public List<Fournisseur> chercherFournisseur(@PathVariable Long utl, @PathVariable String motCle) { return us.chercherFournisseur(utl,motCle); }

}
