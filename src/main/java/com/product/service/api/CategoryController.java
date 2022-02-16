package com.product.service.api;

import com.product.service.model.dao.CategoryDao;
import com.product.service.model.entity.Category;
import com.product.service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-svc/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getallcategory")
    public List<Category> getAll() throws Exception {
        return categoryService.getAll();
    }

    @GetMapping("/getcategorybyid")
    public Category getCategoryById(@RequestParam("id") Integer id) throws Exception {
        return categoryService.getById(id);
    }

    @PostMapping("/createcategory")
    public Category createCategory(@RequestBody CategoryDao categoryDao) throws Exception {
        return categoryService.createCategory(categoryDao);
    }

    @PatchMapping("/updatecategory")
    public Category updateCategory(@RequestBody CategoryDao categoryDao) throws Exception {
        return categoryService.updateCategory(categoryDao);
    }

    @DeleteMapping("/deletecategory")
    public Integer deleteCategory(@RequestParam("id") Integer id) throws Exception {
        return categoryService.deleteCategory(id);
    }


}
