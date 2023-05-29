package com.example.springdataredis;

import com.example.springdataredis.entity.Product;
import com.example.springdataredis.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringDataRedisApplication {
	@Autowired
	private ProductDAO productDAO;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return productDAO.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productDAO.findAll();
	}

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return productDAO.findProductById(id);
	}
	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id)   {
		return productDAO.deleteProduct(id);
	}
	public static void main(String[] args) {

		SpringApplication.run(SpringDataRedisApplication.class, args);
	}

}
