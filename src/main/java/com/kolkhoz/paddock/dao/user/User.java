package com.kolkhoz.paddock.dao.user;

import com.kolkhoz.paddock.dao.comment.Comment;
import com.kolkhoz.paddock.dao.news.News;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USR_SEQ")
    @SequenceGenerator(name = "usr_seq", sequenceName = "USR_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "BIRTHDAY")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate birthday;

    @Column(name = "CITY")
    private String city;

    @Column(name = "RATING")
    private Long rating;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private Role userRole;

    @OneToMany(mappedBy = "author")
    private Set<News> news;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

}
