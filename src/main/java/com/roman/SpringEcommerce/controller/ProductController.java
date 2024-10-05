package com.roman.SpringEcommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.roman.SpringEcommerce.model.Product;
import com.roman.SpringEcommerce.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		Product product = productService.getProductbyId(id);
		if(product != null) {
			return new ResponseEntity<> (product,HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/product/{productId}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
			Product product = productService.getProductbyId(productId);
			if(product != null) {
				return new ResponseEntity<> (product.getImageData(),HttpStatus.OK);
			} else {
				return new ResponseEntity<> (HttpStatus.NOT_FOUND);
			}
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
		Product savedProduct=null;
		try {
			savedProduct = productService.addOrUpdateProduct(product, imageFile);
			return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@RequestPart Product product, @RequestPart MultipartFile image) {
		Product updatedProduct=null;
		try {
			updatedProduct = productService.addOrUpdateProduct(product, image);
			return new ResponseEntity<>("Updated", HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<String> deleteByProductId(@PathVariable int productId) {
			Product product = productService.getProductbyId(productId);
			if(product != null) {
				productService.deleteByProductbyId(productId);
				return new ResponseEntity<> ("Deleted",HttpStatus.GONE);
			} else {	
				return new ResponseEntity<> (HttpStatus.NOT_FOUND);
			}
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> searchByKeyword(String keyword) {
		 List<Product> products = productService.searchByKeyword(keyword);
		 System.out.println("Seraching with "+keyword); 
		 return new ResponseEntity<> (products, HttpStatus.OK);
	}
}
