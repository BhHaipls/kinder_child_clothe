package com.mper.smartschool.dto.mapper;

import com.mper.smartschool.dto.DeliveryDto;
import com.mper.smartschool.entity.Delivery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface DeliveryMapper {
    DeliveryDto toDto(Delivery delivery);

    Delivery toEntyty(DeliveryDto dto);
}
