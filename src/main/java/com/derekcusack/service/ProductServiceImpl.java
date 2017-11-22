package com.derekcusack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.derekcusack.model.Product;
import com.derekcusack.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public Page<Product> list(Pageable pageable) {
		return productRepository.findAll(pageable);
	}	
	
	@Override
	public Page<Product> listByPriceRange(Pageable pageable, Integer minprice, Integer maxprice) {
		return productRepository.findAllByPriceBetween(pageable, minprice, maxprice);
	}

	@Override
	public void addNewProduct(String name, Integer price) {
		Product newProduct = new Product();
		newProduct.setName(name);
		newProduct.setPrice(price);
		productRepository.save(newProduct);
	}
	
	
	
}
