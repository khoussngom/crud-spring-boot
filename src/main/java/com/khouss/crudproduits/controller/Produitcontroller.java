package com.khouss.crudproduits.controller;

import com.khouss.crudproduits.models.Produit;
import com.khouss.crudproduits.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class Produitcontroller {

    public Produitcontroller(ProduitService produitService) {
        this.produitService = produitService;
    }

    private final ProduitService produitService;

    @PostMapping("/create")
    public Produit create(@RequestBody Produit produit) {
        return produitService.creer(produit);
    }

    @GetMapping("/read")
    public List<Produit> read() {
        return produitService.lire();
    }

    @PutMapping("/update/{id}")
    public Produit update(@PathVariable  Long id,@RequestBody Produit produit) {
        return produitService.modifier(id,produit);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable Long id) {
        return produitService.supprimer(id);
    }
}
