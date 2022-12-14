package com.example.produitpharmaceutique.Controllers;

import com.example.produitpharmaceutique.Entities.Categorie;
import com.example.produitpharmaceutique.Services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController
{
    @Autowired
    CategorieService cs;

    @GetMapping("findAll")
    public List<Categorie> findAll(){return cs.findAll();}

    @GetMapping("findById/{id}")
    public Categorie findById(@PathVariable Long id) {return cs.findById(id);}

    @GetMapping("findByLib/{lib}")
    public Categorie findByLib(@PathVariable String lib) {return cs.findByLib(lib);}

    @PostMapping("add")
    public Categorie add(@RequestBody Categorie categorie) {return cs.add(categorie);}


}