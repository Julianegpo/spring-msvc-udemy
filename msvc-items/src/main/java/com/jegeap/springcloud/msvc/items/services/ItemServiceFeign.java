package com.jegeap.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jegeap.springcloud.msvc.items.client.ProductFeignClient;
import com.jegeap.springcloud.msvc.items.models.Item;

@Service
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public List<Item> findAll() {
        return productFeignClient.getProducts().stream()
                .map(product -> new Item(product, new Random().nextInt(10 + 1)))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.of(
                new Item(productFeignClient.details(id), new Random().nextInt(10 + 1)));
    }

}
