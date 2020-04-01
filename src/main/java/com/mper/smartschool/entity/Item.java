package com.mper.smartschool.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item extends BaseEntity{
    @Column(length = 256)
    private String name;

    @Column(length = 1024)
    private String description;

    @Column(length = 256)
    private String size;

    @ManyToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "item_has_offer",
            joinColumns = {@JoinColumn(name = "item", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "offer", referencedColumnName = "id")})
    private Set<Offer> offers = new HashSet<>();
}
