package br.alura.forumhub.domain.repository;

import br.alura.forumhub.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
    boolean existsByEmail(String email);
}
