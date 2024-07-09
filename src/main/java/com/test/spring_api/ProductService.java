package com.test.spring_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Product product, Long id){
        Product productFind = productRepository.findById(id).orElse(null);
        if(productFind == null){
            return null;
        }
        productFind.setName(product.getName());
        productFind.setPrice(product.getPrice());
        productFind.setDescription(product.getDescription());

        return productRepository.save(productFind);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
