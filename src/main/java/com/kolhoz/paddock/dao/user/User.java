package com.kolhoz.paddock.dao.user;

import com.kolhoz.paddock.dao.clan.Clan;
import com.kolhoz.paddock.dao.comment.Comment;
import com.kolhoz.paddock.dao.news.News;
import com.kolhoz.paddock.dao.payment.PaymentHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USR_SEQ_GENERATOR")
    @SequenceGenerator(name = "USR_SEQ_GENERATOR", sequenceName = "USR_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "BIRTHDAY")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate birthday;

    @Column(name = "CITY")
    private String city;

    @Column(name = "AVATAR")
    private byte[] avatar;

    @Column(name = "USR_ROLE")
    @Enumerated(EnumType.STRING)
    private Role userRole;

    @Column(name = "REGISTRATION_DATETIME")
    private LocalDateTime registrationDateTime;

    @Column(name = "GAME_RATING")
    private Long gameRating;

    @Column(name = "MEDIA_RATING")
    private Long mediaRating;

    @Column(name = "BANNED")
    private Boolean banned;

    @Column(name = "SUBSCRIPTION")
    private Boolean isSubscribe;

    @Column(name = "EXPIRATION_SUBS_DATE")
    private LocalDateTime expirationSubsDate;

    @ManyToOne
    @JoinColumn(name = "CLAN_ID")
    private Clan clan;

    @OneToMany(mappedBy = "user")
    private Set<PaymentHistory> paymentHistory;

    @OneToMany(mappedBy = "user")
    private Set<News> news;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

}