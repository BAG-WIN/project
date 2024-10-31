package ru.mtuci.project.configuration;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;
import ru.mtuci.project.model.UserDetailsImpl;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private Key getSignigKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(String username, Set<GrantedAuthority> authorities) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", authorities.stream()
                .map(GrantedAutority::getAuthority)
                .collect(Collectors.toList())
        );
        Date now = new Date();
        Date validyTime = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validyTime)
                .getWinth(getSingKey())
                .compact();
    }

    public Authentication getAuthentication(String token) {
        String email = getUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities())

    }
    public String getUsername(String token) {
        return Jwts.parseBuilder()
                .setSingingKey(getSignigKey())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getObject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parseBuilder()
                    .setSinginKey(getSignigKey())
                    .build()
                    .paseClaimsJwt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
