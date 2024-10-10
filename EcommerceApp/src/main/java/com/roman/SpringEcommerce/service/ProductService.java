package com.roman.SpringEcommerce.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.roman.SpringEcommerce.model.Product;
import com.roman.SpringEcommerce.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getProductbyId(int id) {
		return productRepo.findById(id).get();
	}

	public Product addOrUpdateProduct(Product product, MultipartFile imageFile) throws IOException {
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageData(imageFile.getBytes());
		
		return productRepo.save(product);
	}

	public void deleteByProductbyId(int productId) {
		productRepo.deleteById(productId);
		
	}
 
	public List<Product> searchByKeyword(String keyword) {
		
		return productRepo.searchProducts(keyword);
	}
	
	
}
