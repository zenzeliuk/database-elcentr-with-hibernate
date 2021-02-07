package com.elcentr.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "residential_complexes")
@Entity
public class ResidentialComplex extends BaseEntity{

    @Column(nullable = false)
    private String name;

    private String address;

}
