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
public class Comment extends BaseEntity{
    @Column(length = 1024)
    private String description;

    @Column(length = 8)
    private Integer rating;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "item_has_comment",
            joinColumns = {@JoinColumn(name = "item", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "comment", referencedColumnName = "id")})
    private Set<Item> items = new HashSet<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Set<User> users = new HashSet<>();

    private Category category;

}



