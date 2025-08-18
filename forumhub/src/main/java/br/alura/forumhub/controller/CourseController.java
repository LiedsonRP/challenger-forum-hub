package br.alura.forumhub.controller;

import br.alura.forumhub.domain.dto.course.NewCourseData;

import br.alura.forumhub.domain.dto.course.NewCourseDetails;
import br.alura.forumhub.domain.model.Course;
import br.alura.forumhub.domain.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/new")
    public ResponseEntity<NewCourseDetails> insertNewCourse(@RequestBody @Valid NewCourseData data, UriComponentsBuilder uriBuilder) {

        var course = new Course(data);
        courseRepository.save(course);

        var uri = uriBuilder.path("/coures/new").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(uri).body(new NewCourseDetails(course));
    }
}
