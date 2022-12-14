package com.example.produitpharmaceutique.Controllers;

import com.example.produitpharmaceutique.Entities.Produit;
import com.example.produitpharmaceutique.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produits")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController
{
    @Autowired
    ProduitService ps;

    @GetMapping("findAll")
    public List<Produit> findAll() { return ps.findAll(); }

    @GetMapping("findById/{id}")
    public Produit findById(@PathVariable Long id) { return ps.findById(id); }

    @PostMapping("add")
    public Produit add(@RequestBody Produit produit) { return ps.add(produit); }

    @DeleteMapping("deleteById/{id}")
    public void  deleteBId(@PathVariable Long id) {ps.deleteById(id);}

    @PutMapping("update/{id}")
    public Produit modify(@PathVariable Long id, @RequestBody Produit produit) { return ps.update(id,produit); }
}
