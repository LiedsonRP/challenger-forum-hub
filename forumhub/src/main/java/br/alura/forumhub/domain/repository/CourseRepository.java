package br.alura.forumhub.domain.repository;

import br.alura.forumhub.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
