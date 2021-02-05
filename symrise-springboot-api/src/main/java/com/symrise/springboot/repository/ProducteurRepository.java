package com.symrise.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symrise.springboot.model.Producteur;

public interface ProducteurRepository extends JpaRepository<Producteur, Long>{
	List<Producteur> findByNom(String nom);
}
