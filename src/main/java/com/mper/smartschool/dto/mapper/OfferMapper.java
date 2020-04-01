package com.mper.smartschool.dto.mapper;

import com.mper.smartschool.dto.OfferDto;
import com.mper.smartschool.entity.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface OfferMapper {
    OfferDto toDto(Offer comment);

    Offer toEntyty(OfferDto dto);


}
