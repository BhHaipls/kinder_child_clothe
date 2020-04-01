package com.mper.smartschool.dto.mapper;

import com.mper.smartschool.dto.CommentDto;
import com.mper.smartschool.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")


public interface CommentMapper {
    CommentDto toDto(Comment comment);

    Comment toEntyty(CommentDto dto);
}
