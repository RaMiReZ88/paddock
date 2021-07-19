package com.kolhoz.paddock.controller.auth.registration.request;

import com.kolhoz.paddock.controller.GeneralRequest;
import com.kolhoz.paddock.dao.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class RegistrationRequest extends GeneralRequest {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private LocalDate birthday;
    private String city;
    private LocalDateTime registrationDateTime;
    private LocalDateTime expirationSubsDate;

}