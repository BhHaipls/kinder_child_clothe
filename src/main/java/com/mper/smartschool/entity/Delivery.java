package com.mper.smartschool.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class Delivery extends BaseEntity {
    @Column(length = 256)
    private String name;
    @Column(length = 1024)
    private String description;
}
