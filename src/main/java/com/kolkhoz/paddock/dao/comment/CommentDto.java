package com.kolkhoz.paddock.dao.comment;

import com.kolkhoz.paddock.dao.news.News;
import com.kolkhoz.paddock.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long id;
    private String text;
    private LocalDateTime dateTimeAdded;
    private User author;
    private News news;
}
