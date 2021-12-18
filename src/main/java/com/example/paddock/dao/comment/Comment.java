package com.example.paddock.dao.comment;

import com.example.paddock.dao.news.News;
import com.example.paddock.dao.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ_GENERATOR")
    @SequenceGenerator(name = "COMMENT_SEQ_GENERATOR", sequenceName = "COMMENT_SEQ", allocationSize = 1)
    @Column(name = "RECORD_ID")
    private Long recordId;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DATE_ADDED")
    private LocalDateTime dateTimeAdded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_iD")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NEWS_ID")
    private News news;

}
