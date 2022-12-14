package com.example.produitpharmaceutique.Services;

import com.example.produitpharmaceutique.Entities.Categorie;
import com.example.produitpharmaceutique.Repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategorieService
{
    @Autowired
    CategorieRepository cr;

    @Transactional
    public List<Categorie> findAll(){return cr.findAll();}

    @Transactional
    public Categorie findById(Long id) {return cr.getOne(id);}

    @Transactional
    public Categorie findByLib(String lib) {return cr.findByLib(lib);}

    @Transactional
    public Categorie add(Categorie categorie) {return cr.save(categorie);}
}
