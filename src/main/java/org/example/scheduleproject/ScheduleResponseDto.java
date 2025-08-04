package org.example.scheduleproject;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String name;
    private String title;
    private String post;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScheduleResponseDto(ScheduleEntity schedule){
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.post = schedule.getPost();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

    public ScheduleResponseDto(ScheduleRequestDto dto, ScheduleEntity schedule){
        this.id = schedule.getId();
        this.name = dto.getName();
        this.title = dto.getTitle();
        this.post = schedule.getPost();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

//    public ScheduleResponseDto(ScheduleRequestDto dto, ScheduleEntity schedule){
//        this.id = schedule.getId();
//        this.name = dto.getName();
//        this.comment = dto.getComment();
//        this.createdAt = schedule.getCreatedAt();
//        this.updatedAt = schedule.getUpdatedAt();
//    }
}
