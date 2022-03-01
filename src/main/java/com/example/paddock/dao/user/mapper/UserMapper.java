package com.example.paddock.dao.user.mapper;

import com.example.paddock.dao.user.User;
import com.example.paddock.dao.user.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapToDto(User user);

    User mapToEntity(UserDto userDto);
}
