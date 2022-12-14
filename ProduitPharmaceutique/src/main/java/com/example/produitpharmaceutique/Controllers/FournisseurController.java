package com.example.produitpharmaceutique.Controllers;

import com.example.produitpharmaceutique.Entities.Fournisseur;
import com.example.produitpharmaceutique.Services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fournisseurs")
@CrossOrigin(origins = "http://localhost:4200")
public class FournisseurController 
{
    @Autowired
    FournisseurService fs;

    @GetMapping("findAll")
    public List<Fournisseur> findAll() { return fs.findAll(); }

    @GetMapping("findById/{id}")
    public Fournisseur findById(@PathVariable Long id) { return fs.findById(id); }

    @PostMapping("add")
    public Fournisseur add(@RequestBody Fournisseur fournisseur) { return fs.add(fournisseur); }

    @DeleteMapping("deleteById/{id}")
    public void  deleteBId(@PathVariable Long id) {fs.deleteById(id);}

    @PutMapping("update/{id}")
    public Fournisseur modify(@PathVariable Long id, @RequestBody Fournisseur fournisseur) { return fs.update(id,fournisseur); }
}
