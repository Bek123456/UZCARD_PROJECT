package org.example.uzcarrd.config;

import lombok.Getter;
import lombok.Setter;
import org.example.uzcarrd.enums.ProfileRole;
import org.example.uzcarrd.enums.ProfileStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private ProfileStatus status;
    private ProfileRole role;

    public CustomUserDetails(Integer id, String phone, String password, ProfileStatus status, ProfileRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new LinkedList<>();
        list.add(new SimpleGrantedAuthority(role.name()));
        return list;

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status.equals(ProfileStatus.ACTIVE);
    }

    public Integer getId() {
        return id;

    }
}
