package dev.java.ecommerce.basketservice.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Product {

    private Long id;
    private String tittle;
    private BigDecimal price;
    private Integer quantity;

}
