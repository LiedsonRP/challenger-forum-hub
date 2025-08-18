package br.alura.forumhub.controller;

import br.alura.forumhub.domain.dto.Topic.UpdateTopicInfoDTO;
import br.alura.forumhub.domain.dto.topic.DetailedTopicDTO;
import br.alura.forumhub.domain.dto.topic.NewTopicDataDTO;

import br.alura.forumhub.domain.dto.topic.TopicListDetailDTO;
import br.alura.forumhub.domain.model.ForumTopic;
import br.alura.forumhub.domain.repository.ForumTopicRepository;
import br.alura.forumhub.domain.repository.ProfileRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")

public class ForumTopicController {

    @Autowired
    private ForumTopicRepository forumTopicRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public ResponseEntity<Page<TopicListDetailDTO>> listTopics(@PageableDefault(size = 10, sort = "createdAt") Pageable pagination) {
        var page = forumTopicRepository.findAll(pagination).map(TopicListDetailDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedTopicDTO> getTopicInfo(@PathVariable Long id) {
        var topic = forumTopicRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailedTopicDTO(topic));
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<DetailedTopicDTO> createNewTopic(@RequestBody @Valid NewTopicDataDTO data, UriComponentsBuilder uriBuilder) {

        var author = profileRepository.getReferenceById(data.authorId());
        var newTopic = new ForumTopic(data, author);

        forumTopicRepository.save(newTopic);

        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(newTopic.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailedTopicDTO(newTopic));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<DetailedTopicDTO> updatePostInfo(@RequestBody @Valid UpdateTopicInfoDTO data) {
        var topic = forumTopicRepository.getReferenceById(data.topic_id());
        topic.updateForumTopicInfo(data);

        return ResponseEntity.ok(new DetailedTopicDTO(topic));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {

        var topic = forumTopicRepository.getReferenceById(id);
        forumTopicRepository.delete(topic);

        return ResponseEntity.noContent().build();
    }
}
