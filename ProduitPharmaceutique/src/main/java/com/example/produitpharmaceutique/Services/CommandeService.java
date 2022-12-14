package com.example.produitpharmaceutique.Services;

import com.example.produitpharmaceutique.Entities.Commande;
import com.example.produitpharmaceutique.Repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeService 
{
    @Autowired
    CommandeRepository cr;

    @Transactional
    public List<Commande> findAll() { return cr.findAll(); }

    @Transactional
    public Commande add(Commande commande)
    { return cr.save(commande); }



}
