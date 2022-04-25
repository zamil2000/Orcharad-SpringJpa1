package com.example.Jpa.demo.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jpa.demo.Jpa.*;

@Service
public class ProductService {
    
	@Autowired
	private ProductRepository repository;
	
	
	
	public Product saveproduct(Product product) { //postmethod()
		
		return repository.save(product);
	}
	
	public List<Product> saveproducts(List<Product> products){ //->postmethod()
		return repository.saveAll(products);
	}
	
	//getmethod()
	
	public List<Product> getProduct(){
		
		return repository.findAll();
	}
	//getmethod()
	
	public Product getProductById(int id) throws ResourceException {
		
	     return	 repository.findById(id).orElseThrow(() -> new ResourceException("Invalid ID"+id));
	}
	
	public Product getProductByName(String name) {
		
		return repository.findByName(name);
	}
	
	//deletemethod()
	
	public String deleteProduct(int id) {
		
		repository.deleteById(id);
		return "Product Removed by Id"+id;
	}
	
	public Product updateProduct(Product product) {
		
		Product exestingproduct=repository.findById(product.getId()).orElse(null);
		
		exestingproduct.setName(product.getName());
		exestingproduct.setPrice(product.getPrice());
		exestingproduct.setQuantity(product.getQuantity());
		
		return   repository.save( exestingproduct);
		
		
	}
}
