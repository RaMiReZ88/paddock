package com.kolhoz.paddock.dao.user.dto;

import com.kolhoz.paddock.dao.clan.Clan;
import com.kolhoz.paddock.dao.comment.Comment;
import com.kolhoz.paddock.dao.news.News;
import com.kolhoz.paddock.dao.payment.Payment;
import com.kolhoz.paddock.dao.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private LocalDate birthday;
    private String city;
    private byte[] avatar;
    private Role userRole;

    private Long gameRating;
    private Long mediaRating;

    private Boolean banned;

    private LocalDateTime registrationDateTime;
    private LocalDateTime expirationSubsDate;

    private Clan clan;
    private Clan clanAdmin;

    private Set<Payment> payment;
    private List<Comment> comments;
    private Set<News> news;

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
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
        return true;
    }

}
