package com.jegeap.springcloud.msvc.products.repository;

import org.springframework.data.repository.CrudRepository;

import com.jegeap.springcloud.msvc.products.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
