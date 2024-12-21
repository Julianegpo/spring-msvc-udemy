package com.jegeap.springcloud.msvc.items.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jegeap.springcloud.msvc.items.models.ProductDTO;

@FeignClient(url = "localhost:8081")
public interface ProductFeignClient {

    @GetMapping("/api/products/")
    public List<ProductDTO> getProducts();

    @GetMapping("/api/products/{id}")
    public ProductDTO details(@PathVariable Long id);

}
