package com.kolhoz.paddock.dao.comment.repository;


import com.kolhoz.paddock.dao.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
