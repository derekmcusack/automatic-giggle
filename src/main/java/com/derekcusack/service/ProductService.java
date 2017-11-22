package com.derekcusack.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.derekcusack.model.Product;

public interface ProductService {

	public Page<Product> list(Pageable pageable);
	public Page<Product> listByPriceRange(Pageable pageable, Integer minprice, Integer maxprice);
	public void addNewProduct(String name, Integer price);

}
