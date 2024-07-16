package com.sprint.major.etl_try.controller;

import com.sprint.major.etl_try.entity.Product;
import com.sprint.major.etl_try.entity.Product2;
import com.sprint.major.etl_try.repository.ProductRepository;
import com.sprint.major.etl_try.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Product2Controller {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

//    private List<Product> makeList(List<Product> product) {
//        return productRepository.saveAll(product);
//    }

//    @Scheduled(fixedRate = 15000)   // Runs after every 15 seconds
//    public String saveproduct2(@RequestBody List<Product> products ) {
////        makeList(product);
//        List<Product2> savedProducts = productService.addToProduct2(products);
//        if (!savedProducts.isEmpty()) {
//            return "Data saved successfully";
//        } else {
//            return "Failed to save data";
//        }
//    }

}
