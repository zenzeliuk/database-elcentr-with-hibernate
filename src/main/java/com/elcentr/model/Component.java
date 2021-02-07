package com.elcentr.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "components")
@Entity
public class Component extends BaseEntity{

    @ManyToOne(targetEntity = Enclosure.class)
    private Enclosure enclosure;

    @ManyToOne(targetEntity = AccessoriesEnclosure.class)
    private AccessoriesEnclosure accessoriesEnclosure;

    @Column(name = "amount_component", nullable = false)
    private Integer amountComponent;

}
