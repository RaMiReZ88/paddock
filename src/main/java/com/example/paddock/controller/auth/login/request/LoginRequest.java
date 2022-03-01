package com.example.paddock.controller.auth.login.request;

import com.example.paddock.controller.Request;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@RequiredArgsConstructor
public class LoginRequest extends Request {

    private final String login;
    private final String password;

}
