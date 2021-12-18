package com.example.paddock.dao.user.repository;

import com.example.paddock.dao.user.User;
import com.example.paddock.dao.user.dto.UserDto;
import com.example.paddock.exception.entity.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// TODO:
//  1. Работа с рейтингом
//  2. Работа с кланом

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto loadUserByUsername(final String login) throws UsernameNotFoundException {
        return userRepository.findUserByLogin(login)
                .map(this::convertToDto)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found by login: %s", login)));
    }

    public UserDto findByNickname(final String nickname) throws UserNotFoundException {
        return userRepository.findUserByNickname(nickname)
                .map(this::convertToDto)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found by username: %s", nickname)));
    }

    public UserDto findByRecordId(final Long id) throws UserNotFoundException {
        return userRepository.findUserByRecordId(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found by id: %d", id)));
    }

    public void save(final User newUser) {
        newUser.setPassword(encodePassword(newUser.getPassword()));
        userRepository.save(newUser);
    }

//    public void update(final User updatableUser) throws UserNotFoundException {
//        User currentUser = securityContextWorker.getCurrentlyLoggedUser().getUser();
//        currentUser.setUsername(updatableUser.getUsername());
//        currentUser.setNickname(updatableUser.getNickname());
//        currentUser.setPassword(encodeUserPassword(updatableUser.getPassword()));
//        currentUser.setGameRating(updatableUser.getGameRating());
//        currentUser.setCity(updatableUser.getCity());
//
//        save(currentUser);
//    }

    private String encodePassword(final String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public void deleteByRecordId(final Long recordId) {
        userRepository.deleteById(recordId);
    }

    public UserDto convertToDto(final User user) {
        return UserDto.builder()
                .recordId(user.getRecordId())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .email(user.getEmail())
                .city(user.getCity())
                .birthday(user.getBirthday())
                .avatar(user.getAvatar())
                .userRole(user.getUserRole())
                .registrationDateTime(user.getRegistrationDateTime())
                .expirationSubsDate(user.getExpirationSubsDate())
                .gameRating(user.getGameRating())
                .mediaRating(user.getMediaRating())
                .banned(user.getBanned())
                .comments(user.getComments())
                .paymentHistory(user.getPaymentHistory())
                .news(user.getNews())
                .clan(user.getClan())
                .build();
    }

    public User convertToEntity(final UserDto userDto) {
        return User.builder()
                .recordId(userDto.getRecordId())
                .nickname(userDto.getNickname())
                .password(userDto.getPassword())
                .city(userDto.getCity())
                .birthday(userDto.getBirthday())
                .avatar(userDto.getAvatar())
                .userRole(userDto.getUserRole())
                .registrationDateTime(userDto.getRegistrationDateTime())
                .expirationSubsDate(userDto.getExpirationSubsDate())
                .gameRating(userDto.getGameRating())
                .mediaRating(userDto.getMediaRating())
                .banned(userDto.getBanned())
                .comments(userDto.getComments())
                .paymentHistory(userDto.getPaymentHistory())
                .news(userDto.getNews())
                .clan(userDto.getClan())
                .build();
    }
}
