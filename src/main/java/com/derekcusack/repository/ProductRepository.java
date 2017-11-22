package com.derekcusack.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.derekcusack.model.Product;


public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
    @Query(value = "select * from Product where price >= :minprice and price <= :maxprice "
    				+ "ORDER BY ?#{#pageable}",
    		countQuery = "SELECT count(*) FROM Product WHERE price >= :minprice "
    				+ "and price <= :maxprice",
    	    nativeQuery = true)
	public Page<Product> findAllByPriceBetween(Pageable pageable, @Param("minprice") Integer minprice, @Param("maxprice") Integer maxprice);
}
