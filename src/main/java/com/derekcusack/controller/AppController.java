package com.derekcusack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.derekcusack.model.Product;
import com.derekcusack.service.ProductService;

@RestController
@RequestMapping("/products")
public class AppController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Page<Product> listProducts(
			@RequestParam(value="page", required=true) Integer page,
			@RequestParam(value="size", required=true) Integer size){
		Page<Product> products = productService.list(page,size);
		return products;	
	} 	
	
	@GetMapping("bypricerange")
	public Page<Product> listByPriceRange( 
				@RequestParam(value="page", required=true) Integer page,
				@RequestParam(value="size", required=true) Integer size,
				@RequestParam(value="minprice", required=true) Integer minprice,
				@RequestParam(value="maxprice", required=true) Integer maxprice){
		Page<Product> products = productService.listByPriceRange(minprice,maxprice,page,size);
		return products;
	}
	
	@PostMapping("newproduct")
	public void newProduct(@RequestBody Product product){
		productService.addNewProduct(product);
	}	

}
