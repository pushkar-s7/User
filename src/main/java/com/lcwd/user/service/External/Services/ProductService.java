package com.lcwd.user.service.External.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.Entities.Product;



@FeignClient(name="USER-PRODUCT")
public interface ProductService {
	
	  @GetMapping("products/{id}")
	   public ResponseEntity<Product> getProductById(@PathVariable Long id);
}
