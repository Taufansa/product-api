package com.product.service.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "store")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeid;
    private String storename;
    private String storeowner;
    private String storeaddress;
}
