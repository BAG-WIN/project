package ru.mtuci.project.model;

public class UserDetailsImpl implements UserDetails {

    private final String username;
    private final String password;
    private List<GrantedAuthority> authorities;
    private final boolean isActive;

    @Override
    public boolean isAccountNoneExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNoneLoced() {
        return isActive;
    }

    @Override
    public boolean isCredentilsNoneExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromApplicationUser(ApplicationUser user) {
        return new User(
                user.
        );
    }
}
