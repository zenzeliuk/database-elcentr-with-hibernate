package com.elcentr.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accessories_enclosures")
@Entity
public class AccessoriesEnclosure extends BaseEntity{

    @OneToOne(targetEntity = Enclosure.class)
    private Enclosure enclosure;

    private String plinth;

}
