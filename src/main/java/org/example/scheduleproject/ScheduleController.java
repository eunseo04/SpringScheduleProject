package org.example.scheduleproject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
class ScheduleController {

    private final ScheduleService scheduleService;

    //요청받기
    @GetMapping
    public List<ScheduleResponseDto> viewAll(@RequestParam(required = false) String name){
        return scheduleService.viewAllPosts(name);
    }

    @GetMapping("/{id}")
    public ScheduleResponseDto findView(@PathVariable Long id){
        return scheduleService.findPost(id);
    }

    @PutMapping("/{id}")
    public ScheduleResponseDto modify(@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {
        return scheduleService.update(id, dto);
    }

    @PostMapping
    public ScheduleResponseDto addSchedule(@RequestBody ScheduleRequestDto dto){
        return scheduleService.posting(dto);
    }

    @PostMapping("/{id}")
    public ScheduleResponseDto addComment(@PathVariable Long id, @RequestBody ScheduleRequestDto dto){
        return scheduleService.comment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto dto){
        scheduleService.deletePost(id, dto);
    }
}
