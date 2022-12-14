package com.example.produitpharmaceutique.Services;

import com.example.produitpharmaceutique.Entities.Laboratoire;
import com.example.produitpharmaceutique.Repositories.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LaboratoireService 
{
    @Autowired
    LaboratoireRepository lr;

    @Transactional
    public List<Laboratoire> findAll(){return lr.findAll();}

    @Transactional
    public Laboratoire findById(Long id) {return lr.getOne(id);}

    @Transactional
    public Laboratoire findByLib(String lib) {return lr.findByLib(lib);}

    @Transactional
    public Laboratoire add(Laboratoire laboratoire) {return lr.save(laboratoire);}
}
