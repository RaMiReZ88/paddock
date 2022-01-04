package com.kolhoz.paddock.controller.auth.login.response;

import com.kolhoz.paddock.controller.GeneralResponse;
import com.kolhoz.paddock.dao.user.dto.UserDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class LoginResponse extends GeneralResponse {

    private final UserDto authenticatedUser;

}