package com.example.Jpa.demo.Jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct( @RequestBody Product product) {
		
		return service.saveproduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody  List<Product> products){
		
		return service.saveproducts(products);
	}
	
	@GetMapping("/Product")
	public List<Product>findAllProducts(){
		
		return service.getProduct();
	}
	
	@GetMapping("/Product/{name}")
	public Product findProductByname(@PathVariable String name) {
		
		return service.getProductByName(name);
	}
	@GetMapping("/ProductId/{id}")
	public Product findProductById( @PathVariable int id) throws ResourceException {
		
		return service.getProductById(id);
	}
	
	@PutMapping("/update")
	public Product updateProduct(Product product) {
		
		return service.updateProduct(product);
	}
	@DeleteMapping("/delete")
	public String deleteProduct(@PathVariable int id) {
     
		return service.deleteProduct(id);
	
	}
	
}