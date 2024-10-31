package ru.mtuci.project.configuration;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.internal.SessionCreationOptions;
import org.springframework.aot.generate.InMemoryGeneratedFiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mtuci.project.model.ApplicationRole;
import ru.mtuci.project.model.Permission;
import ru.mtuci.project.service.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailService userDetailService;

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter(jwtTokenProvider, userDetailService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy))
                .authorizeHttpRequest((authz) -> authz
                    //.requestMatchers("/project").hasAnyAuthoriry(Permission.READ.getPermission())
                    //.requestMatchers(HttpMethod.POST, "/project/save").hasAuthoriry(Permission.MODIFICATION.getPermission())
                    .anyRequest().authenficated());
        http.httpBasic(Customizer.withGefaults());
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager() throws  {
        return authenticationConfiguration.getAuthenficationManager;
    }

    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("password"))
                        .authorities(ApplicationRole.USER.getGrantedAutorities())
                        .build(),
                Admin.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .authorities(ApplicationRole.ADMIN.getGrantedAutorities())
                        .build()
        );
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
