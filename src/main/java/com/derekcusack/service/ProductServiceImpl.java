package com.derekcusack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<Product> list(Integer page, Integer size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return productRepository.findAll(pageRequest);
	}	
	
	@Override
	public Page<Product> listByPriceRange(Integer  minprice, Integer maxprice, Integer page, Integer size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return productRepository.findAllByPriceBetween(minprice, maxprice, pageRequest);
	}

	@Override
	public void addNewProduct(Product product) {
		productRepository.save(product);
	}
	
	
	
}
