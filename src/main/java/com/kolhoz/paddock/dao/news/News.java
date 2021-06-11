package com.kolhoz.paddock.dao.news;


import com.kolhoz.paddock.dao.comment.Comment;
import com.kolhoz.paddock.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "NEWS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWS_SEQ_GENERATOR")
    @SequenceGenerator(name = "NEWS_SEQ_GENERATOR", sequenceName = "NEWS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CREATION_DATE_TIME")
    private LocalDateTime creationDateTime;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "THEME")
    private String theme;

    @Column(name = "IMAGE")
    private byte[] image;

    @Column(name = "LIKES")
    private Long likes;

    @Column(name = "DISLIKES")
    private Long dislikes;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "news")
    private List<Comment> comments;
}


