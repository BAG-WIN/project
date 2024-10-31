package ru.mtuci.project.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.postgresql.plugin.AuthenticationRequestType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mtuci.project.configuration.JwtTokenProvider;
import ru.mtuci.project.model.ApplicationUser;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth/login")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserReposity userRepository;
    private final AuthenticationManger authenticationManger;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        try() {
            String email = request.getEmail();

            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, request.getPassword)
            );

            ApplicationUser user = userRepository.findByEmail(email)
                    .orElseThrows(() -> new UsernameNotFoundException("User not found"));

            String token = jwtTokenProvider.createToken(email, user.getRole.getGrantedAuthen);

            return ResponseEntity.ok(new AuthenticationResponse(email, token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalide email or");
        }

    }
}
