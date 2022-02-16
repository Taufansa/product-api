package com.product.service.model.repository;

import com.product.service.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByCategoryname(String name);
    Category findByCategoryid(Integer id);
    Integer deleteByCategoryid(Integer id);

}
