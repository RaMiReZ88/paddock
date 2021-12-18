package com.example.paddock.dao.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.example.paddock.dao.clan.Clan;
import com.example.paddock.dao.comment.Comment;
import com.example.paddock.dao.news.News;
import com.example.paddock.dao.payment.PaymentHistory;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    @SequenceGenerator(name = "USER_SEQ_GENERATOR", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "RECORD_ID")
    private Long recordId;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTHDAY")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate birthday;

    @Column(name = "CITY")
    private String city;

    @Column(name = "AVATAR")
    private byte[] avatar;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private Role userRole;

    @Column(name = "REGISTRATION_DATETIME")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
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
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime expirationSubsDate;

    @ManyToOne
    @JoinColumn(name = "CLAN_ID")
    private Clan clan;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<PaymentHistory> paymentHistory;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<News> news;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Comment> comments;

}