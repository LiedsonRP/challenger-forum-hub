package br.alura.forumhub.domain.model;

import br.alura.forumhub.domain.dto.profile.NewProfileDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "profiles")
/**
 * Entidade que representa um perfil de usuário
 */
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ForumTopic> topicsCreated;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TopicAnswer> answersWrited;

    public Profile(NewProfileDTO newProfileData) {
        this.id = null;
        this.name = newProfileData.name();
    }
}
