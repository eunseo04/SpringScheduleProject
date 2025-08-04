package org.example.scheduleproject.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("posts/comments")
public class CommentController {
    private final CommentService commentService;

    @PutMapping("/{id}")
    public CommentResponseDto addComment(@PathVariable Long id, @RequestBody CommentRequestDto dto) {
        return commentService.comment(id, dto);
    }
}
