package com.example.paddock.controller.auth.registration.request;

import com.example.paddock.controller.Request;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class RegistrationRequest extends Request {

    private final Long recordId;
    private final String login;
    private final String password;
    private final String matchPassword;
    private final String nickname;
    private final String email;
    private final LocalDate birthday;
    private final String city;
    private final LocalDateTime expirationSubsDate;

}