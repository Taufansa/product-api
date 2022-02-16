package com.product.service.model.repository;

import com.product.service.model.entity.Category;
import com.product.service.model.entity.Product;
import com.product.service.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByStore(Store store);
    List<Product> findAllByCategory(Category category);
    List<Product> findAllByCategoryAndAndStore(Category category, Store store);
    Product findByProductid(Integer id);
    Integer deleteByProductid(Integer id);
}
