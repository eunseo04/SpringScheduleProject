package org.example.scheduleproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Entity
@Table(name = "schedules")  // 테이블명 지정 (생략시 클래스명과 동일)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자는 protected로 막음
public class ScheduleEntity extends BaseEntity{
    @Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 200)
    private String post;

    public ScheduleEntity(String title, String post, String name, String password) {
        this.title = title;
        this.post = post;
        this.name = name;
        this.password = password;
    }

    public void update(String title, String name) {
        this.title = title;
        this.name = name;
    }
}
