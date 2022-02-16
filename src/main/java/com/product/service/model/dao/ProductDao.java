package com.product.service.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDao {
    private Integer productid;
    private String productname;
    private String productdesc;
    private Integer qty;
    private Integer price;
    private Integer storeid;
    private Integer categoryid;
}
