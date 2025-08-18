package br.alura.forumhub.controller;

import br.alura.forumhub.domain.dto.auth.authenticationData;
import br.alura.forumhub.domain.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import br.alura.forumhub.domain.model.User;
import br.alura.forumhub.domain.dto.auth.TokenJWTDTO;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJWTDTO> authenticate(@RequestBody @Valid authenticationData authData) {

        System.out.println(authData.email() + " " + authData.password());
        var authenticationToken = new UsernamePasswordAuthenticationToken(authData.email(), authData.password());
        System.out.println(authenticationToken);

        var authentication = manager.authenticate(authenticationToken);
        System.out.println(authentication);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        System.out.println(tokenJWT);

        return ResponseEntity.ok(new TokenJWTDTO(tokenJWT));
    }

}
