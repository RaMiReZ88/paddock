package com.kolkhoz.paddock.dao.news;


import com.kolkhoz.paddock.dao.comment.Comment;
import com.kolkhoz.paddock.dao.user.User;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    private byte [] image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @OneToMany(mappedBy = "news")
    private List<Comment> comments;
}


