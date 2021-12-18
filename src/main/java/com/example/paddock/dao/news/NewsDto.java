package com.example.paddock.dao.news;

import com.example.paddock.dao.comment.Comment;
import com.example.paddock.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {

    private Long id;
    private String title;
    private LocalDateTime creationDateTime;
    private String description;
    private String theme;
    private byte[] image;
    private Long likes;
    private Long dislikes;
    private User user;
    private List<Comment> comments;

}
