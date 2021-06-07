package com.kolkhoz.paddock.dao.comment;

import com.kolkhoz.paddock.dao.news.News;
import com.kolkhoz.paddock.dao.user.User;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DATE_ADDED")
    private LocalDateTime dateTimeAdded;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;
}
