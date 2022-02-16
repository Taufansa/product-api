package com.product.service.api;

import com.product.service.model.dao.ProductDao;
import com.product.service.model.entity.Product;
import com.product.service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-svc/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getallproducts")
    public List<Product> getAll() throws Exception {
        return productService.fetchAll();
    }

    @GetMapping("/getallproductsbystore")
    public List<Product> getAllByStore(@RequestParam("id") Integer id) throws Exception{
        return productService.fetchAllByStore(id);
    }

    @GetMapping("/getallproductsbycategory")
    public List<Product> getAllByCategory(@RequestParam("id") Integer id) throws Exception{
        return productService.fetchAllByCategory(id);
    }

    @GetMapping("/getallproductsbycategoryandstore")
    public List<Product> getAllByCategoryAndStore(@RequestParam("categoryid") Integer categoryid, @RequestParam("storeid") Integer storeid) throws Exception{
        return productService.fetchAllByCategoryAndStore(categoryid, storeid);
    }

    @GetMapping("/getproductbyid")
    public Product getById(@RequestParam("id") Integer id) throws Exception {
        return productService.fetchById(id);
    }

    @PostMapping("/createproduct")
    public Product createProduct(@RequestBody ProductDao productDao) throws Exception {
        return productService.createNew(productDao);
    }

    @PatchMapping("/updateproduct")
    public Product updateProduct(@RequestBody ProductDao productDao) throws Exception {
        return productService.updateProduct(productDao);
    }

    @DeleteMapping("/deleteproduct")
    public Integer deleteProduct(@RequestParam("id") Integer id) throws Exception {
        return productService.deleteProduct(id);
    }


}
