package com.example.paddock.controller.auth.login.response;

import com.example.paddock.controller.common.Response;
import com.example.paddock.dao.user.dto.UserDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class LoginResponse extends Response {

    private final UserDto authenticatedUser;

}