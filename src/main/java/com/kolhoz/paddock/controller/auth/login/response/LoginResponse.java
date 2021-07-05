package com.kolhoz.paddock.controller.auth.login.response;

import com.kolhoz.paddock.controller.GeneralResponse;
import com.kolhoz.paddock.dao.user.dto.UserDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
public class LoginResponse extends GeneralResponse {
    private UserDto authenticatedUser;
}