package com.mper.smartschool.dto;

import com.mper.smartschool.entity.Delivery;
import com.mper.smartschool.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class OfferDto extends BaseDto{
    String name;
    Date date;
    User user;
    Delivery delivery;
}
