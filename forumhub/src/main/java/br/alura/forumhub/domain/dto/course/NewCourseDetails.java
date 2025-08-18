package br.alura.forumhub.domain.dto.course;

import br.alura.forumhub.domain.model.Category;
import br.alura.forumhub.domain.model.Course;

public record NewCourseDetails(
        Long id,
        String name,
        Category category
) {

    public NewCourseDetails(Course course) {
        this(course.getId(), course.getName(), course.getCategory());
    }
}
