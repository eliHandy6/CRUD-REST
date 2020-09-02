package com.javatechie.zack.day_2_project.controller;

import com.javatechie.zack.day_2_project.entity.Product;
import com.javatechie.zack.day_2_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
   private ProductService service;
    /*
     post request
     */

    @PostMapping("/addProduct")
    public Product addProduct( @RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    /*Get Mapping*/

    @GetMapping("/findProducts")
    public List<Product> findAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/findProductById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/findProduct/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }


    /*
    update put
     */
    @PutMapping("/updateProduct")
    public Product updateProduct( @RequestBody Product product){
        return service.updateProduct(product);
    }


    @DeleteMapping ("/deleteProduct/{id}")
    public String deleteProduct( @PathVariable int id){
        return service.deleteProductById(id);
    }



}
