package com.sprint.major.etl_try.service;

import com.sprint.major.etl_try.entity.Product;
import com.sprint.major.etl_try.entity.Product2;
import com.sprint.major.etl_try.repository.Product2Repository;
import com.sprint.major.etl_try.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Product2Repository product2Repository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }


    //    Following method is GET
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductByID(int id){
        return productRepository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return " Record Removed !!"+id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }

    public List<Product2> addToProduct2(List<Product> products) {
        List<Product2> product2List = new ArrayList<>();

        for (Product product : products) {
            Product2 product2 = new Product2();
            product2.setName(product.getName());
            product2.setPrice(product.getPrice());
            product2.setQuantity(product.getQuantity());

            product2List.add(product2Repository.save(product2));
        }

        return product2List;
    }


    @Scheduled(fixedRate = 15000)   // Runs after every 15 seconds
    public String saveproduct2(@RequestBody List<Product> products ) {
//        makeList(product);
        List<Product2> savedProducts = addToProduct2(products);
        if (!savedProducts.isEmpty()) {
            return "Data saved successfully";
        } else {
            return "Failed to save data";
        }
    }



}
