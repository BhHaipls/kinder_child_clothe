package com.mper.smartschool.entity;

import com.mper.smartschool.entity.modelsEnum.SexStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@Entity

public class Category extends BaseEntity {
    @Column(length = 256)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private SexStatus sex;

    @Builder
    public Category(Long id, String name, SexStatus sex) {
        super(id);
        this.name = name;
        this.sex = sex;
    }
}
