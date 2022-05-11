package com.atabey.springBootJava.business.abstracts;

import java.util.List;

import com.atabey.springBootJava.core.utilities.result.DataResult;
import com.atabey.springBootJava.core.utilities.result.Result;
import com.atabey.springBootJava.entities.concretes.Product;

public interface ProductService {
			
			DataResult<List<Product>> getAll();
			DataResult<List<Product>> getAll(int pageNo, int pageSize);
			DataResult<List<Product>> getAllSorted();
			Result add (Product product);

			
			DataResult<Product> getByProductName(String productName);
		
			 
			DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
			 
			 
			DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
			 
			 
			DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories);
			 
			 
			DataResult<List<Product>> getByProductNameContains(String productName);
			 
			 
			DataResult<List<Product>> getByProductNameStartsWith(String productName);
			 
		
			DataResult<List<Product>> getByNameAndCategory_CategoryId(String productName, int categoryId);

}
