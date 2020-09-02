package com.javatechie.zack.day_2_project.service;

import com.javatechie.zack.day_2_project.entity.Product;
import com.javatechie.zack.day_2_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    /*
    Post Methods using save and saveall
     */

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    /*
    Get methods
     */

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    /*
    delete method
     */

    public String deleteProductById(int id){
        productRepository.deleteById(id);
        return "The product with id"+id +"was removed";
    }

    /*
    update put Method
     */

    public Product updateProduct(Product product){
        Product existingProduct=productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuatity(product.getQuatity());
        return productRepository.save(existingProduct);

    }
}
