package com.kolhoz.paddock.dao.comment;

import com.kolhoz.paddock.dao.IdGenerator;
import com.kolhoz.paddock.dao.news.News;
import com.kolhoz.paddock.dao.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT")
@SequenceGenerator(name = "COMMENT_RECORD_ID_GENERATOR", sequenceName = "COMMENT_SEQ", allocationSize = 1)

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends IdGenerator {

    private String text;

    private LocalDateTime dateTimeAdded;

    @ManyToOne
    @JoinColumn(name = "USR_iD")
    private User user;

    @ManyToOne
    @JoinColumn(name = "NEWS_ID")
    private News news;
}
