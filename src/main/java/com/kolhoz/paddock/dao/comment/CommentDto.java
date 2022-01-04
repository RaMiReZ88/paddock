package com.kolhoz.paddock.dao.comment;

import com.kolhoz.paddock.dao.news.News;
import com.kolhoz.paddock.dao.user.User;
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

    private Long recordId;
    private String text;
    private LocalDateTime dateTimeAdded;
    private User author;
    private News news;
}
