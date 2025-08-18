package br.alura.forumhub.controller;

import br.alura.forumhub.domain.dto.user.UserDetailData;
import br.alura.forumhub.domain.service.UserProfileManager;
import br.alura.forumhub.domain.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import br.alura.forumhub.domain.dto.user.NewUserData;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileManager manager;

    @GetMapping("/{id}")
    public ResponseEntity getUserInfo(@PathVariable Long id) {
         var user = userRepository.getReferenceById(id);
         var userData = new UserDetailData(user);

         return ResponseEntity.ok(userData);
    }


    @PostMapping("/new")
    @Transactional
    public ResponseEntity insertNewUser(@RequestBody @Valid NewUserData newUserData, UriComponentsBuilder uriBuilder) {

        var user = manager.saveNewUser(newUserData);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailData(user));
    }
}
