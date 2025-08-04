package org.example.scheduleproject.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByScheduleId(Long postId); // 특정 게시글의 댓글 조회
}