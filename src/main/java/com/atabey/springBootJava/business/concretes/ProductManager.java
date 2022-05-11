package com.atabey.springBootJava.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.atabey.springBootJava.business.abstracts.ProductService;
import com.atabey.springBootJava.core.utilities.result.DataResult;
import com.atabey.springBootJava.core.utilities.result.Result;
import com.atabey.springBootJava.core.utilities.result.SuccessDataResult;
import com.atabey.springBootJava.core.utilities.result.SuccessResult;
import com.atabey.springBootJava.dataAccess.abstracts.ProductDao;
import com.atabey.springBootJava.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{

					private ProductDao productDao;
					
					@Autowired
					public ProductManager(ProductDao productDao) {
						super();
						this.productDao = productDao;
					}
				
				
					@Override
					public DataResult<List<Product>> getAll() {
						return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data Listelendi");
					}


					@Override
					public Result add(Product product) {
						this.productDao.save(product);	
						return new SuccessResult("Ürün Eklendi...");
					}


					@Override
					public DataResult<Product> getByProductName(String productName) {
						return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data Listelendi");
					}


					@Override
					public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
						return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listelendi");
					}


					@Override
					public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
						return new SuccessDataResult<List<Product>>
						(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listelendi"); 
					}


					@Override
					public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
						return new SuccessDataResult<List<Product>>
						(this.productDao.getByCategory_CategoryIdIn(categories), "Data Listelendi");
					}


					@Override
					public DataResult<List<Product>> getByProductNameContains(String productName) {
						return new SuccessDataResult<List<Product>>
						(this.productDao.getByProductNameContains(productName), "Data Listelendi");
						
					}


					@Override
					public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
						return new SuccessDataResult<List<Product>>
						(this.productDao.getByProductNameStartsWith(productName), "Data Listelendi");
					}


					@Override
					public DataResult<List<Product>> getByNameAndCategory_CategoryId(String productName, int categoryId) {
						return new SuccessDataResult<List<Product>>
						(this.productDao.getByNameAndCategory_CategoryId(productName, categoryId), "Data Listelendi");
					}


					@Override
					public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
					
					PageRequest pageable= PageRequest.of(pageNo-1, pageSize);
						return new SuccessDataResult<List<Product>>
						(this.productDao.findAll(pageable).getContent());
					}


					@Override
					public DataResult<List<Product>> getAllSorted() {
					 Sort sorted = Sort.by(Sort.Direction.DESC, "productName");
					 return new SuccessDataResult<List<Product>>
						(this.productDao.findAll(sorted), "Başarılı şekilde listelendi...");
					}
					


}
