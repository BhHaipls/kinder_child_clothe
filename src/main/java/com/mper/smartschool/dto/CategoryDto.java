package com.mper.smartschool.dto;

import com.mper.smartschool.entity.modelsEnum.SexStatus;
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
public class CategoryDto extends BaseDto {
    String name;
    SexStatus sex;
}
