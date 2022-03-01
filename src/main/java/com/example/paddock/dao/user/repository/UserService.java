package com.example.paddock.dao.user.repository;

import com.example.paddock.dao.user.mapper.UserMapper;
import com.example.paddock.exception.request.BadRequestException;
import com.example.paddock.utils.security.context.SecurityContextWorker;
import com.example.paddock.dao.user.User;
import com.example.paddock.dao.user.dto.UserDto;
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
    private final UserMapper userMapper;

    private final SecurityContextWorker securityContextWorker;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .map(userMapper::mapToDto)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown user: " + username));
    }

    public UserDto findByNickname(final String nickname) throws BadRequestException {
        return userRepository.findUserByNickname(nickname)
                .map(userMapper::mapToDto)
                .orElseThrow(() -> new BadRequestException("User not found by username: " + nickname));
    }

    public UserDto findByRecordId(final Long recordId) throws BadRequestException {
        return userRepository.findUserByRecordId(recordId)
                .map(userMapper::mapToDto)
                .orElseThrow(() -> new BadRequestException("User not found by record id: " + recordId));
    }

    public void save(final UserDto newUser) {
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userRepository.save(userMapper.mapToEntity(newUser));
    }

    public void deleteByRecordId(final Long recordId) {
        userRepository.deleteById(recordId);
    }
}
