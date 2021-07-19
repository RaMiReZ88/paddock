package com.kolhoz.paddock.dao.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kolhoz.paddock.dao.clan.Clan;
import com.kolhoz.paddock.dao.comment.Comment;
import com.kolhoz.paddock.dao.news.News;
import com.kolhoz.paddock.dao.payment.PaymentHistory;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

// TODO:
//  1. Добавить поле "email"
//  2. Добавить поле "phoneNumber"

@Entity
@Table(name = "USR")
@Getter
@Setter
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

    @Column(name = "PASSWORD")
    private String password;

//    @Column(name = "MATCHING_PASSWORD")
//    private String matchingPassword;

    @Column(name = "NICKNAME")
    private String nickname;

//    @Column(name = "EMAIL")
//    private String email;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLAN_ID")
    private Clan clan;  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLAN_ADMIN")
    private Clan clanAdmin;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<PaymentHistory> paymentHistory;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<News> news;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

}