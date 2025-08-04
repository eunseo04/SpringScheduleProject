package org.example.scheduleproject;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto posting(ScheduleRequestDto dto) { //일정 생성
        ScheduleEntity entity = scheduleRepository.save(new ScheduleEntity(dto.getTitle(), dto.getPost(), dto.getName(), dto.getPassword()));
        //제목, 내용, 비밀번호, 작성자명, 작성/수정일 entity로 객체화 후 DB에 저장
        return new ScheduleResponseDto(entity);
        //Entity 직접 접근을 막기 위해 비밀번호를 제외한 reponse 타입으로 객체화 후 반환
    }

    @Transactional(readOnly = true) //조회만 하므로 readOnly
    public List<ScheduleResponseDto> viewAllPosts(){ //전체 조회
        List<ScheduleResponseDto> entity = new ArrayList<>();
        for(ScheduleEntity scheduleEntity : scheduleRepository.findAll()){
            entity.add(new ScheduleResponseDto(scheduleEntity));
        }
        return entity;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findPost(Long id){
        ScheduleEntity entity = scheduleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Schedule not found"));
        return new ScheduleResponseDto(entity);
    }

    @Transactional
    public void deletePost(Long id){
        scheduleRepository.deleteById(id);
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto) {
        ScheduleEntity schedule = scheduleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Schedule not found"));
        schedule.update(dto.getTitle(), dto.getPost());
        return new ScheduleResponseDto(dto, schedule);
    }
}

