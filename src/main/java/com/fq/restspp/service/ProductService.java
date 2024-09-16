package com.fq.restspp.service;

import com.fq.restspp.enitity.Product;
import com.fq.restspp.exception.ResourceNotFoundException;
import com.fq.restspp.repository.ProductRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  public Product getProductByID(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product updateProduct(Long id, Product updatedProduct) {
    Product existingProduct = getProductByID(id);
    
    existingProduct.setName(updatedProduct.getName());
    existingProduct.setPrice(updatedProduct.getPrice());
    return productRepository.save(existingProduct);
  }

  public void deleteProduct(Long id) {
    Product product = getProductByID(id);
    productRepository.delete(product);
  }
}
