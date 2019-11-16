package com.commerce.microservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.commerce.microservice.Dao.ProductDao;
import com.commerce.microservice.Exception.producintrouvalException;
import com.commerce.microservice.model.Product;

@RestController
public class Controller {
	
	@Autowired
	public ProductDao productDao;
	@RequestMapping(value="/Product")
	public List<Product> findAll()
	{
		return productDao.findAll();
		
		
	}
	
@GetMapping("/Product/{id}")
	public Product getidProduct(@PathVariable int id)
	{
	  Product product= productDao.findById(id);
	  if (product==null)
	  {
		  throw new producintrouvalException("id nest pas trouve en bdd");
	  }
	  
	  return product;
	}


	
	@PostMapping(value="/Product")
	public  ResponseEntity<Void>  saveProduct(@RequestBody Product product )
	{
		Product product1 = productDao.save(product);
		
		if(product == null)
		{
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(product1.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	

	@DeleteMapping (value = "/Produits/{id}")
	   public void supprimerProduit(@PathVariable int id) {

	       productDao.deleteById(id);
	   }
	
	@PutMapping (value = "/Produits")
	  public void updateProduit(@RequestBody Product product) {

	      productDao.save(product);
	  }
}
