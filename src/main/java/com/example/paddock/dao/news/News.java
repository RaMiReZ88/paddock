package com.example.paddock.dao.news;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.example.paddock.dao.comment.Comment;
import com.example.paddock.dao.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "NEWS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWS_SEQ_GENERATOR")
    @SequenceGenerator(name = "NEWS_SEQ_GENERATOR", sequenceName = "NEWS_SEQ", allocationSize = 1)
    @Column(name = "RECORD_ID")
    private Long recordId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "news", fetch = FetchType.LAZY)
    private List<Comment> comments;

}


