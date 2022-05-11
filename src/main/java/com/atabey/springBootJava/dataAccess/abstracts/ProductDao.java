package com.atabey.springBootJava.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atabey.springBootJava.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
			
				 Product getByProductName(String productName);
				 
				 
				 Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
				 
				 
				 List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
				 
				 
				 List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
				 
				 
				 List<Product> getByProductNameContains(String productName);
				 
				 
				 List<Product> getByProductNameStartsWith(String productName);
				 
				 @Query("From Product where productName=:productName and categoryId=:categoryId")
				 List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);
				 
				 
				 

}