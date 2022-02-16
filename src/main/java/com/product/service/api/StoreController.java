package com.product.service.api;

import com.product.service.model.dao.StoreDao;
import com.product.service.model.entity.Store;
import com.product.service.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-svc/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/getallstores")
    public List<Store> getAll() throws Exception {
        return storeService.fetchAll();
    }

    @GetMapping("/getstorebyid")
    public Store getStoreById(@RequestParam("id") Integer id) throws Exception {
        return storeService.findById(id);
    }

    @PostMapping("/createstore")
    public Store createStore(@RequestBody StoreDao storeDao) throws Exception {
        return storeService.createNew(storeDao);
    }

    @PatchMapping("/updatestore")
    public Store updateStore(@RequestBody StoreDao storeDao) throws Exception {
        return storeService.updateStore(storeDao);
    }

    @DeleteMapping("/deletestore")
    public Integer deleteStore(@RequestParam("id") Integer id) throws Exception {
        return storeService.deleteStore(id);
    }



}
