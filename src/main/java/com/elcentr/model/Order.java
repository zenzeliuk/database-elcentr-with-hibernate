package com.elcentr.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order extends BaseEntity{

    @ManyToOne(targetEntity = Product.class)
    private Product product;

    @OneToOne(targetEntity = Customer.class)
    private Customer customer;

    @OneToOne(targetEntity = ResidentialComplex.class)
    private ResidentialComplex residentialComplex;

}
