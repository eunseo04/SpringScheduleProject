package org.example.scheduleproject.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.scheduleproject.ScheduleEntity;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponseDto {
    private Long postId;
    private Long commentId;
    private String comment;
    private String commentName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentResponseDto(CommentEntity entity) {
        this.postId = entity.getSchedule().getId();
        this.commentId = entity.getCommentId();
        this.commentName = entity.getCommentName();
        this.comment = entity.getComment();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

}
