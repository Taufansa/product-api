package com.product.service.services;

import com.product.service.model.dao.CategoryDao;
import com.product.service.model.entity.Category;
import com.product.service.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Cacheable
    public List<Category> getAll() throws Exception {
        try {
            return categoryRepository.findAll();
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Category getById(Integer id) throws Exception {
        try {
            Category category = categoryRepository.findByCategoryid(id);
            if (Objects.nonNull(category)){
                return category;
            } else {
                return new Category();
            }
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Category getByName(String name) throws Exception {
        try {
            return categoryRepository.findByCategoryname(name);
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Category createCategory(CategoryDao categoryDao) throws Exception {
        try {
            Category cat = getByName(categoryDao.getCategoryname());
            if (Objects.isNull(cat)) {
                Category category = new Category(
                        null,
                        categoryDao.getCategoryname()
                );
                return categoryRepository.saveAndFlush(category);
            } else {
                return new Category();
            }
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Category updateCategory(CategoryDao categoryDao) throws Exception {
        try {
            Category category = getById(categoryDao.getCategoryid());
            if (Objects.nonNull(category)){
                category.setCategoryname(categoryDao.getCategoryname());
                return categoryRepository.saveAndFlush(category);
            } else {
                return new Category();
            }
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Integer deleteCategory(Integer id) throws Exception {
        try {
            return categoryRepository.deleteByCategoryid(id);
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

}
