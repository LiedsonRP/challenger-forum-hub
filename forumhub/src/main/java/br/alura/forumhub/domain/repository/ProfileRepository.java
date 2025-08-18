package br.alura.forumhub.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.alura.forumhub.domain.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByName(String name);
}
