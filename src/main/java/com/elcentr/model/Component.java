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
@Table(name = "components")
@Entity
public class Component extends BaseEntity {

    @ManyToOne(targetEntity = Enclosure.class)
    private Enclosure enclosure;

    @Column(nullable = false)
    private Integer amount;

}
