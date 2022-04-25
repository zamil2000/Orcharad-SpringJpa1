package com.example.Jpa.demo.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Jpa.demo.Jpa.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
