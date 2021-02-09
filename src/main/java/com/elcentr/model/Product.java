package com.elcentr.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product extends BaseEntity {

    @ManyToOne(targetEntity = Component.class)
    private Component component;

    @Column(name = "time_registration", nullable = false)
    private Long timeRegistration;

    @Column(name = "time_end")
    private Long timeEnd;

    @Column(nullable = false)
    private Integer code;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String name;

    private String passport;

    private String photo;

    @Column(name = "nominal_current")
    private Integer nominalCurrent;

    @Column(name = "index_protection_product")
    private Integer indexProtectionProduct;

    @Column(name = "decimal_number")
    private String decimalNumber;

    private Integer height;

    private Integer width;

    private Integer depth;

}
