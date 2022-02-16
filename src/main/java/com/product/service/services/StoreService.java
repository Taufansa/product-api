package com.product.service.services;

import com.product.service.model.dao.StoreDao;
import com.product.service.model.entity.Store;
import com.product.service.model.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Cacheable
    public List<Store> fetchAll() throws Exception{
        try {
            return storeRepository.findAll();
        } catch (Exception e){
            System.out.println("Exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Store findById(Integer id) throws Exception{
        try {
            Store store = storeRepository.findByStoreid(id);
            if (Objects.nonNull(store)){
                return store;
            } else {
                return new Store();
            }
        } catch (Exception e){
            System.out.println("Exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Store findByName(String name) throws Exception{
        try {
            return storeRepository.findByStorename(name);
        } catch (Exception e){
            System.out.println("Exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Store createNew(StoreDao storeDao) throws Exception {
        try {
            Store store = findByName(storeDao.getStorename());
            if (Objects.isNull(store)){
                Store newStore = new Store(
                        null,
                        storeDao.getStorename(),
                        storeDao.getStoreowner(),
                        storeDao.getStoreaddress()
                );
                return storeRepository.saveAndFlush(newStore);
            } else {
                return new Store();
            }
        } catch (Exception e){
            System.out.println("Exception : " + e.getMessage() );
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Store updateStore(StoreDao storeDao) throws Exception {
        try {
            Store store = findById(storeDao.getStoreid());
            if (Objects.nonNull(store)){
                store.setStorename(storeDao.getStorename());
                store.setStoreowner(storeDao.getStoreowner());
                store.setStoreaddress(storeDao.getStoreaddress());
                return storeRepository.saveAndFlush(store);
            } else {
                return new Store();
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Integer deleteStore(Integer id) throws Exception{
        try {
            return storeRepository.deleteByStoreid(id);
        } catch (Exception e){
            System.out.println("Exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
