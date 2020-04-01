package com.mper.smartschool.controller;

import com.mper.smartschool.dto.CommentDto;
import com.mper.smartschool.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    CommentDto create(CommentDto commentDto){
        return commentService.create(commentDto);
    }

    @GetMapping
    Collection<CommentDto> findAll(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDto findById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        commentService.deleteById(id);
    }

}
