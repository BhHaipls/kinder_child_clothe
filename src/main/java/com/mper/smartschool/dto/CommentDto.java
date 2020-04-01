package com.mper.smartschool.dto;

import com.mper.smartschool.dto.transfer.OnCreate;
import com.mper.smartschool.dto.transfer.OnUpdate;
import com.mper.smartschool.entity.Item;
import com.mper.smartschool.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

    @Data
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @NoArgsConstructor
    public class CommentDto extends BaseDto{
        @NotNull(groups = {OnCreate.class, OnUpdate.class},
                message = "{commentDto.description.notnull}")
        String description;
        Integer rating;
        Set user;
        Set<Item> items = new HashSet<>();

    }

