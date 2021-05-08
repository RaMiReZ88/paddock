package com.kolkhoz.paddock.dao.user.repository;

import com.kolkhoz.paddock.dao.user.User;
import com.kolkhoz.paddock.dao.user.UserDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDto> getCurrentlyLoggedUser() {
        return findUserByNickname(SecurityContextHolder.getContext()
                .getAuthentication()
                .getName()
        );
    }

    public Optional<UserDto> findUserByNickname(final String nickname) {
        return userRepository.findUserByNickname(nickname).map(this::convertToDto);
    }

    public Optional<UserDto> findUserById(final Long id) {
        return userRepository.findById(id).map(this::convertToDto);
    }

    public void save(final User newUser) {
        userRepository.save(newUser);
    }

    public void update(final User updatableUser) {
        User currentUser = getCurrentlyLoggedUser().map(this::convertToEntity).get();
        currentUser.setName(updatableUser.getName());
        currentUser.setNickname(updatableUser.getNickname());
        currentUser.setAge(updatableUser.getAge());
        currentUser.setCity(updatableUser.getCity());

        save(currentUser);
    }

    public void deleteById(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDto convertToDto(final User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .nickname(user.getNickname())
                .city(user.getCity())
                .age(user.getAge())
                .role(user.getRole())
                .build();
    }

    private User convertToEntity(final UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .nickname(userDto.getNickname())
                .city(userDto.getCity())
                .age(userDto.getAge())
                .role(userDto.getRole())
                .build();
    }
}
