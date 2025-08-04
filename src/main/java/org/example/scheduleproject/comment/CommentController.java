package org.example.scheduleproject.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PutMapping("/comments/{id}")
    public CommentResponseDto addComment(@PathVariable Long id, @RequestBody CommentRequestDto dto) {
        return commentService.comment(id, dto);
    }
}
