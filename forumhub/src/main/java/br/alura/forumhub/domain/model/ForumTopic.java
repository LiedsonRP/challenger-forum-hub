package br.alura.forumhub.domain.model;

import br.alura.forumhub.domain.dto.Topic.UpdateTopicInfoDTO;
import br.alura.forumhub.domain.dto.topic.NewTopicDataDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "forum_topic")
/**
 * Entidade que representa um tópico do fórum
 */
public class ForumTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TopicAnswer> answers = new ArrayList<>();

    public ForumTopic(NewTopicDataDTO data, Profile profile) {

        this.id = null;
        this.title = data.title();
        this.message = data.message();
        this.author = profile;

        this.status = Status.OPEN;
        this.createdAt = LocalDateTime.now();

        this.course = new Course();
        this.course.setId(data.courseId());
    }

    public void updateForumTopicInfo(UpdateTopicInfoDTO data) {

        if (data.title() != null) {
            this.setTitle(data.title());
        }

        if(data.message() != null) {
            this.setMessage(data.message());
        }

        if (data.status() != null) {
            this.setStatus(data.status());
        }

        if (data.course() != null) {
            this.setCourse(data.course());
        }

    }
}
