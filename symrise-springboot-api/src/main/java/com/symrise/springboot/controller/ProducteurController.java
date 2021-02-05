package com.symrise.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.symrise.springboot.repository.ProducteurRepository;
import com.symrise.springboot.model.Producteur;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProducteurController {
	
	@Autowired
	ProducteurRepository producteurRepository;

	@GetMapping("/producteurs")
	public ResponseEntity<List<Producteur>> getAllProducteurs(@RequestParam(required = false) String nom) {
		try {
			List<Producteur> producteurs = new ArrayList<Producteur>();

			if (nom == null)
				producteurRepository.findAll().forEach(producteurs::add);
			else
				producteurRepository.findByNom(nom).forEach(producteurs::add);

			if (producteurs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(producteurs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/producteurs/{id}")
	public ResponseEntity<Producteur> getProducteurById(@PathVariable("id") long id) {
		Optional<Producteur> producteurData = producteurRepository.findById(id);

		if (producteurData.isPresent()) {
			return new ResponseEntity<>(producteurData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/producteurs")
	public ResponseEntity<Producteur> createProducteur(@RequestBody Producteur producteur) {
		try {
			Producteur _producteur = producteurRepository
					.save(new Producteur(producteur.getZone(), producteur.getFokontany(), producteur.getInscription(),
							producteur.getNom(), producteur.getGenre(),producteur.getNaissance(), producteur.getCompte(),
							producteur.getErreur()));
			return new ResponseEntity<>(_producteur, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/producteurs/{id}")
	public ResponseEntity<Producteur> updateProducteur(@PathVariable("id") long id, @RequestBody Producteur producteur) {
		Optional<Producteur> producteurData = producteurRepository.findById(id);

		if (producteurData.isPresent()) {
			Producteur _producteur = producteurData.get();
			_producteur.setZone(producteur.getZone());
			_producteur.setFokontany(producteur.getFokontany());
			_producteur.setInscription(producteur.getInscription());
			_producteur.setNom(producteur.getNom());
			_producteur.setGenre(producteur.getGenre());
			_producteur.setNaissance(producteur.getNaissance());
			_producteur.setCompte(producteur.getCompte());
			_producteur.setErreur(producteur.getErreur());
			return new ResponseEntity<>(producteurRepository.save(_producteur), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/producteurs/{id}")
	public ResponseEntity<HttpStatus> deleteProducteur(@PathVariable("id") long id) {
		try {
			producteurRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/producteurs")
	public ResponseEntity<HttpStatus> deleteAllProducteurs() {
		try {
			producteurRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
