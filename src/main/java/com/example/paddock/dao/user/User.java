package com.example.paddock.dao.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.example.paddock.dao.IdGenerator;
import com.example.paddock.dao.clan.Clan;
import com.example.paddock.dao.comment.Comment;
import com.example.paddock.dao.news.News;
import com.example.paddock.dao.payment.Payment;
import lombok.*;
import lombok.experimental.SuperBuilder;
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
@Table(name = "USER")
@SequenceGenerator(name = "USER_RECORD_ID_GENERATOR", sequenceName = "USER_SEQ", allocationSize = 1)

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User extends IdGenerator {

    private String username;

    private String password;

//    @Column(name = "MATCHING_PASSWORD")
//    private String matchingPassword;

    private String nickname;

//    @Column(name = "EMAIL")
//    private String email;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate birthday;

    private String city;

    private byte[] avatar;

    @Enumerated(EnumType.STRING)
    private Role userRole;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime registrationDateTime;

    private Long gameRating;

    private Long mediaRating;

    private Boolean banned;

    private Boolean isSubscribe;

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
    private Set<Payment> payment;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<News> news;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

}