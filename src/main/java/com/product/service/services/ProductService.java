package com.product.service.services;

import com.product.service.model.dao.ProductDao;
import com.product.service.model.entity.Category;
import com.product.service.model.entity.Product;
import com.product.service.model.entity.Store;
import com.product.service.model.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private StoreService storeService;

    @Autowired
    private CategoryService categoryService;

    @Cacheable
    public List<Product> fetchAll() throws Exception{
        try{
            return productsRepository.findAll();
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Cacheable
    public List<Product> fetchAllByStore(Integer id) throws Exception{
        try {
            Store store = storeService.findById(id);
            return productsRepository.findAllByStore(store);
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Cacheable
    public List<Product> fetchAllByCategory(Integer id) throws Exception{
        try {
            Category category = categoryService.getById(id);
            return productsRepository.findAllByCategory(category);
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Cacheable
    public List<Product> fetchAllByCategoryAndStore(Integer categoryid, Integer storeid) throws Exception{
        try {
            Category category = categoryService.getById(categoryid);
            Store store = storeService.findById(storeid);
            return productsRepository.findAllByCategoryAndAndStore(category, store);
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Product fetchById(Integer id) throws Exception {
        try{
            Product product = productsRepository.findByProductid(id);
            if (Objects.nonNull(product)) {
                return product;
            } else {
                return new Product();
            }
        } catch (Exception e){
            System.out.println("exception : "+e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Product createNew (ProductDao productDao) throws Exception{
        try {
            Store store = storeService.findById(productDao.getStoreid());
            Category category = categoryService.getById(productDao.getCategoryid());
            Product product = new Product(
                    null,
                    productDao.getProductname(),
                    productDao.getProductdesc(),
                    productDao.getQty(),
                    productDao.getPrice(),
                    store,
                    category
            );
            return productsRepository.saveAndFlush(product);
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Product updateProduct (ProductDao productDao) throws Exception{
        try {
            Product product = fetchById(productDao.getProductid());
            Category category = categoryService.getById(productDao.getCategoryid());
            product.setProductdesc(productDao.getProductdesc());
            product.setProductname(productDao.getProductname());
            product.setQty(productDao.getQty());
            product.setPrice(productDao.getPrice());
            product.setCategory(category);
            return productsRepository.saveAndFlush(product);
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Integer deleteProduct(Integer id) throws Exception {
        try {
            return productsRepository.deleteByProductid(id);
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
