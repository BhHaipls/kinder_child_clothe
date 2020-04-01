package com.mper.smartschool.dto;

import com.mper.smartschool.entity.Item;
import com.mper.smartschool.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

    @Data
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @NoArgsConstructor
    public class CurtDto extends BaseDto{
        Item item;
        User user;
    }
