package com.kolhoz.paddock.dao.user.repository;

import com.kolhoz.paddock.dao.user.User;
import com.kolhoz.paddock.dao.user.UserDto;
import com.kolhoz.paddock.exception.entity.UserNotFoundException;
import com.kolhoz.utils.security.AuthenticatedUserDetails;
import com.kolhoz.utils.security.context.SecurityContextWorker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO:
//  1. Работа с рейтингом
//  2. Работа с кланом

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final SecurityContextWorker securityContextWorker;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository,
                       SecurityContextWorker securityContextWorker,
                       BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.securityContextWorker = securityContextWorker;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AuthenticatedUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .map(AuthenticatedUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Unknown user: %s", username)));
    }

    public UserDto findUserByNickname(final String nickname) throws UserNotFoundException {
        return userRepository.findUserByNickname(nickname)
                .map(this::convertToDto)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found by username: %s", nickname)));
    }

    public UserDto findUserById(final Long id) throws UserNotFoundException {
        return userRepository.findUserById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found by id: %d", id)));
    }

    public void save(final User newUser) {
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

    private String encodeUserPassword(final String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public void deleteById(final Long id) {
        userRepository.deleteById(id);
    }

    public UserDto convertToDto(final User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .password(user.getPassword())
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
                .clanAdmin(user.getClanAdmin())
                .build();
    }

    public User convertToEntity(final UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
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
                .clanAdmin(userDto.getClanAdmin())
                .build();
    }
}
