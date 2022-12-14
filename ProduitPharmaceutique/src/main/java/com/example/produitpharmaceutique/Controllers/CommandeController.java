package com.example.produitpharmaceutique.Controllers;

import com.example.produitpharmaceutique.Entities.Commande;
import com.example.produitpharmaceutique.Services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commandes")
@CrossOrigin(origins = "http://localhost:4200")
public class CommandeController
{
    @Autowired
    CommandeService cs;

    @GetMapping("findAll")
    public List<Commande> findAll() {return cs.findAll();}

    @PostMapping("add")
    public Commande add(@RequestBody Commande commande) {return cs.add(commande);}
}
