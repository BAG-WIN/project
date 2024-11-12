package ru.mtuci.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mtuci.project.model.ApplicationUser;
import ru.mtuci.project.model.UserDetailsImpl;
import ru.mtuci.project.repository.UserRepository;
import ru.mtuci.project.model.ApplicationRole;
import ru.mtuci.project.model.ApplicationUser;
import ru.mtuci.project.model.Role;
import ru.mtuci.project.model.UserDetailsImpl;
import ru.mtuci.project.repository.RoleRepository;
import ru.mtuci.project.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserDetailsImpl.fromApplicationUser(user);
    }

    public boolean saveUser(ApplicationUser user) {
        Optional<ApplicationUser> userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB.isPresent()) return false;

        user.setApplicationRole(ApplicationRole.USER);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword_hash(encoder.encode(user.getPassword_hash()));

        user.setEmail(user.getEmail());
        user.setLogin(user.getLogin());

        userRepository.save(user);
        return true;
    }
}