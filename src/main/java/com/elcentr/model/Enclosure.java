package com.elcentr.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enclosures")
@Entity
public class Enclosure extends BaseEntity{

    private String manufacturer;

    private String code;

    private String category;

    @Column(nullable = false)
    private String name;

    @Column(name = "type_of_installation")
    private String typeOfInstallation;

    private String color;

    private String material;

    private Integer height;

    private Integer width;

    private Integer depth;

    @Column(name = "index_protection")
    private Integer indexProtection;

    private String url;

    @Column(name = "image_url")
    private String imageUrl;

}
