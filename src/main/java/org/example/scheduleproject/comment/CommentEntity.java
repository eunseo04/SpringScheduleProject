package org.example.scheduleproject.comment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.scheduleproject.BaseEntity;
import org.example.scheduleproject.ScheduleEntity;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private ScheduleEntity schedule;

    @Column(nullable = false, length = 100)
    private String comment;
    private String commentName;
    private String commentPassword;

    public CommentEntity(String commentName, String commentPassword, String comment, ScheduleEntity schedule) {
        this.comment = comment;
        this.commentName = commentName;
        this.commentPassword = commentPassword;
        this.schedule = schedule;
    }
}
