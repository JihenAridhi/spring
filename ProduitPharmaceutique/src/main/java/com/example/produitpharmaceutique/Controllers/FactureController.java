package com.example.produitpharmaceutique.Controllers;

import com.example.produitpharmaceutique.Entities.Facture;
import com.example.produitpharmaceutique.Services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("factures")
@CrossOrigin(origins = "http://localhost:4200")
public class FactureController 
{
    @Autowired
    FactureService fs;

    @GetMapping("findAll")
    public List<Facture> findAll() {return fs.findAll();}

    @PostMapping("add")
    public Facture add(@RequestBody Facture facture) {return fs.add(facture);}
}
