package com.example.paddock.dao.comment;

import com.example.paddock.dao.news.News;
import com.example.paddock.dao.user.User;
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
