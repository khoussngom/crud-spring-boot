package com.khouss.crudproduits.service;

import com.khouss.crudproduits.models.Produit;
import com.khouss.crudproduits.repository.ProduitRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class ProduitServiceImpl implements ProduitService {

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    private final ProduitRepository produitRepository;

    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id)
                .map(p->{
                    p.setPrix(produit.getPrix());
                    p.setNom(produit.getNom());
                    p.setDescription(produit.getDescription());

                    return produitRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Produit non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "produit supprimé !";
    }
}
