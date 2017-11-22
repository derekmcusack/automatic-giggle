package com.derekcusack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.derekcusack.model.Product;
import com.derekcusack.service.ProductService;

@RestController
public class AppController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public Page<Product> listProducts(Pageable pageable){
		Page<Product> products = productService.list(pageable);
		return products;	
	} 	
	
	@RequestMapping(value="/productsbyprice",method=RequestMethod.GET)
	public Page<Product> listByPriceRange(Pageable pageable, 
				@RequestParam(value="minprice", required=true) Integer minprice,
				@RequestParam(value="maxprice", required=true) Integer maxprice){
		Page<Product> products = productService.listByPriceRange(pageable, minprice, maxprice);
		return products;
	}
	
	@RequestMapping(value="/newproduct",method=RequestMethod.POST)
	public void newProduct(@RequestParam(value="name", required=true) String name,
				@RequestParam(value="price", required=true) Integer price){
		productService.addNewProduct(name, price);
	}	

}
