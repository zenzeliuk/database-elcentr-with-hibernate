package com.elcentr.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product extends BaseEntity{


    @ManyToOne(targetEntity = Component.class)
    private Component component;

    @Column(name = "time_registration")
    private Long timeRegistration;

    @Column(name = "time_end")
    private Long timeEnd;

    @Column(name = "code_product", nullable = false)
    private Integer codeProduct;

    @Column(name = "amount_product", nullable = false)
    private Integer amountProduct;

    @Column(name = "name_product", nullable = false)
    private String nameProduct;

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
