package com.derekcusack.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.derekcusack.model.Product;

public interface ProductService {

	public Page<Product> list(Integer page, Integer size);
	public Page<Product> listByPriceRange(Integer minprice, Integer maxprice, Integer page, Integer size);
	public void addNewProduct(Product product);

}
