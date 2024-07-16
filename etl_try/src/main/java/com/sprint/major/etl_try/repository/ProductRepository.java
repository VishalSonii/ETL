package com.sprint.major.etl_try.repository;

import com.sprint.major.etl_try.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
