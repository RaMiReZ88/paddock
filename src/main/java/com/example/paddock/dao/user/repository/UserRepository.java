package com.example.paddock.dao.user.repository;

import com.example.paddock.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByRecordId(Long id);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByNickname(String nickname);

    Optional<User> findUserByLogin(String login);
}
