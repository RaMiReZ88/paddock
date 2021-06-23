package com.kolhoz.paddock.dao.user;

import com.kolhoz.paddock.dao.clan.Clan;
import com.kolhoz.paddock.dao.comment.Comment;
import com.kolhoz.paddock.dao.news.News;
import com.kolhoz.paddock.dao.payment.PaymentHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private LocalDate birthday;
    private String city;
    private byte[] avatar;
    private Role userRole;
    private LocalDateTime registrationDateTime;
    private Long gameRating;
    private Long mediaRating;
    private Boolean banned;
    private LocalDateTime expirationSubsDate;
    private Clan clan;
    private Clan clanAdmin;
    private Set<PaymentHistory> paymentHistory;
    private List<Comment> comments;
    private Set<News> news;

}
