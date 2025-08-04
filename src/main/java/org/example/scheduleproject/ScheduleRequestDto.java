package org.example.scheduleproject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {
    private Long id;
    private String name;
    private String password;
    private String title;
    private String post;
}
