package com.example.produitpharmaceutique.Services;

import com.example.produitpharmaceutique.Entities.Facture;
import com.example.produitpharmaceutique.Repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FactureService 
{
    @Autowired
    FactureRepository fr;

    @Transactional
    public List<Facture> findAll() { return fr.findAll(); }

    @Transactional
    public Facture add(Facture facture)
    { return fr.save(facture); }
}
