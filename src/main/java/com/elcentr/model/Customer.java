package com.elcentr.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Entity
public class Customer extends BaseEntity{

    @Column(nullable = false)
    private String name;

    private String notes;

}
