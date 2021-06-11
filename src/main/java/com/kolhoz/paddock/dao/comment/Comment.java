package com.kolhoz.paddock.dao.comment;

import com.kolhoz.paddock.dao.news.News;
import com.kolhoz.paddock.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ_GENERATOR")
    @SequenceGenerator(name = "COMMENT_SEQ_GENERATOR", sequenceName = "COMMENT_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DATE_ADDED")
    private LocalDateTime dateTimeAdded;

    @ManyToOne
    @JoinColumn(name = "USER_iD")
    private User user;

    @ManyToOne
    @JoinColumn(name = "NEW_ID")
    private News news;
}
