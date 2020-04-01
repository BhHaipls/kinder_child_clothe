package com.mper.smartschool.dto.mapper;

import com.mper.smartschool.dto.CurtDto;
import com.mper.smartschool.entity.Curt;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CurtMapper {
    CurtDto toDto(Curt comment);

    Curt toEntyty(CurtDto dto);
}
