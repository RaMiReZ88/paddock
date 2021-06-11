package com.kolhoz.paddock.dao.user.repository;

import com.kolhoz.paddock.dao.user.User;
import com.kolhoz.paddock.dao.user.UserDto;
import com.kolhoz.paddock.exception.UserNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO:
//  1. Работа с рейтингом
//  2. Работа с кланом

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserDto getCurrentlyLoggedUser() {
        return (UserDto) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public UserDto findUserByNickname(final String nickname) throws UserNotFoundException {
        return Optional.ofNullable(userRepository.findUserByNickname(nickname))
                .map(this::convertToDto)
                .orElseThrow(() -> new UserNotFoundException("User not found by username: " + nickname));
    }

    public UserDto findUserById(final Long id) throws UserNotFoundException {
        return Optional.ofNullable(userRepository.findUserById(id))
                .map(this::convertToDto)
                .orElseThrow(() -> new UserNotFoundException("User not found by id: " + id));
    }

    public void save(final User newUser) {
        userRepository.save(newUser);
    }

    public void update(final User updatableUser) throws UserNotFoundException {
        User currentUser = convertToEntity(getCurrentlyLoggedUser());
        currentUser.setUsername(updatableUser.getUsername());
        currentUser.setNickname(updatableUser.getNickname());
        currentUser.setPassword(encodeUserPassword(updatableUser.getPassword()));
        currentUser.setGameRating(updatableUser.getGameRating());
        currentUser.setCity(updatableUser.getCity());

        save(currentUser);
    }

    private String encodeUserPassword(final String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public void deleteById(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDto convertToDto(final User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getUsername())
                .nickname(user.getNickname())
                .city(user.getCity())
                .birthday(user.getBirthday())
                .role(user.getUserRole())
                .build();
    }

    private User convertToEntity(final UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getName())
                .nickname(userDto.getNickname())
                .city(userDto.getCity())
                .birthday(userDto.getBirthday())
                .userRole(userDto.getRole())
                .build();
    }
}
