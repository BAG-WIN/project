package ru.mtuci.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public enum ApplicationRole {
    USER(Set.of(Permission.READ)),
    ADMIN(Set.of(Permission.READ, Permission.MODIFICATION));

    private  final Set<Permission> permissionSet;

    public Set<GrantedAutority> getGrantedAutorities() {
        Set<GrantedAutority> grantedAutorities = getPermission().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.)
    }
}
