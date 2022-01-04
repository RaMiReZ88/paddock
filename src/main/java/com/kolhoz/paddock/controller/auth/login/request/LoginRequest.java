package com.kolhoz.paddock.controller.auth.login.request;

import com.kolhoz.paddock.controller.GeneralRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class LoginRequest extends GeneralRequest {

    private final String username;
    private final String password;

}
