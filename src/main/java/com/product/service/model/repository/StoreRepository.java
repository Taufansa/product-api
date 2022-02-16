package com.product.service.model.repository;

import com.product.service.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findByStorename(String name);
    Store findByStoreid(Integer id);
    Integer deleteByStoreid(Integer id);
}
