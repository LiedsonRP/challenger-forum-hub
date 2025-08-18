package br.alura.forumhub.domain.model;

import br.alura.forumhub.domain.dto.course.NewCourseData;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "courses")
/**
 * Entidade que representa um curso do sistema
 */
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ForumTopic> topicsCreated = new ArrayList<>();

    public Course(NewCourseData data) {
        this.id = null;
        this.name = data.name();
        this.category = data.category();
    }

}
