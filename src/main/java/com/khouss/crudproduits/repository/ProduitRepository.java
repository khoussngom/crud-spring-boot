package com.khouss.crudproduits.repository;

import com.khouss.crudproduits.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
