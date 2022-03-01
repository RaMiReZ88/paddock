package com.example.paddock.dao.news;

import com.example.paddock.dao.IdGenerator;
import com.example.paddock.dao.comment.Comment;
import com.example.paddock.dao.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "NEWS")
@SequenceGenerator(name = "NEWS_RECORD_ID_GENERATOR", sequenceName = "NEWS_SEQ", allocationSize = 1)

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class News extends IdGenerator {

    private String title;

    private LocalDateTime creationDateTime;

    private String description;

    private String theme;

    private byte[] image;

    private Long likes;

    private Long dislikes;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "news")
    private List<Comment> comments;
}


