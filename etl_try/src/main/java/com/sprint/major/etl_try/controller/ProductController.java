package com.sprint.major.etl_try.controller;

import com.sprint.major.etl_try.entity.Product;
import com.sprint.major.etl_try.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/productbyid/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getProductByID(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

}
