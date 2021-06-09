package com.kolhoz.paddock.dao.user.repository;

import com.kolhoz.paddock.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByNickname(final String nickname);
}
