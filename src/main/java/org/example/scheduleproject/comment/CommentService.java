package org.example.scheduleproject.comment;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.scheduleproject.ScheduleEntity;
import org.example.scheduleproject.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CommentResponseDto comment(Long id, CommentRequestDto dto) {
        ScheduleEntity schedule = scheduleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Schedule not found"));
        CommentEntity entity = commentRepository.save(new CommentEntity(dto.getCommentName(), dto.getCommentPassword(), dto.getComment(), schedule));
        return new CommentResponseDto(entity);
    }
}
