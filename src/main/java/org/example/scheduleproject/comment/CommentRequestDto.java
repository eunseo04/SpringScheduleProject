package org.example.scheduleproject.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentRequestDto {
    private String comment;
    private String commentName;
    private String commentPassword;
}
