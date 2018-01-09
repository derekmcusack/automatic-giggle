package com.derekcusack.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.derekcusack.model.Product;


public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	Page<Product> findAllByPriceBetween(int min, int max, Pageable pageable);
}
