package br.alura.forumhub.domain.repository;

import br.alura.forumhub.domain.model.ForumTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumTopicRepository extends JpaRepository<ForumTopic, Long> {

}
