package com.product.service.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDao {
    private Integer storeid;
    private String storename;
    private String storeowner;
    private String storeaddress;
}
