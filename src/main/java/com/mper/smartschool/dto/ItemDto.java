package com.mper.smartschool.dto;

import com.mper.smartschool.entity.Category;
import com.mper.smartschool.entity.Offer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

    @Data
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @NoArgsConstructor
    public class ItemDto extends BaseDto{
        String name;
        String description;
        String size;
        Category category;
        Set<Offer> offers = new HashSet<>();
    }

