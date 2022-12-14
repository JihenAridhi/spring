package com.example.produitpharmaceutique.Controllers;

import com.example.produitpharmaceutique.Entities.Laboratoire;
import com.example.produitpharmaceutique.Services.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("laboratoires")
@CrossOrigin(origins = "http://localhost:4200")
public class LaboratoireController
{
    @Autowired
    LaboratoireService ls;
    
    @GetMapping("findAll")
    public List<Laboratoire> findAll(){return ls.findAll();}

    @GetMapping("findById/{id}")
    public Laboratoire findById(@PathVariable Long id) {return ls.findById(id);}

    @GetMapping("findByLib/{lib}")
    public Laboratoire findByLib(@PathVariable String lib) {return ls.findByLib(lib);}

    @PostMapping("add")
    public Laboratoire add(@RequestBody Laboratoire laboratoire) {return ls.add(laboratoire);}
}
