package com.kolhoz.paddock.dao.user.repository;

import com.kolhoz.paddock.dao.user.User;
import com.kolhoz.paddock.dao.user.UserDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getCurrentlyLoggedUser() {
        return findUserByNickname(SecurityContextHolder.getContext()
                .getAuthentication()
                .getName()
        );
    }

    public UserDto findUserByNickname(final String nickname) {
        return userRepository.findUserByNickname(nickname).map(this::convertToDto).get();
    }

    public Optional<UserDto> findUserById(final Long id) {
        return userRepository.findById(id).map(this::convertToDto);
    }

    public void save(final User newUser) {
        userRepository.save(newUser);
    }

    public void update(final User updatableUser) {
        User currentUser = convertToEntity(getCurrentlyLoggedUser());
        currentUser.setUsername(updatableUser.getUsername());
        currentUser.setNickname(updatableUser.getNickname());
        currentUser.setBirthday(updatableUser.getBirthday());
        currentUser.setRating(updatableUser.getRating());
        currentUser.setCity(updatableUser.getCity());

        save(currentUser);
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
