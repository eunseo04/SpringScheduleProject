package org.example.scheduleproject.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{id}")
    public CommentResponseDto addComment(@PathVariable Long id, @RequestBody CommentRequestDto dto) {
        return commentService.comment(id, dto);
    }
}
