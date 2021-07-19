package com.kolhoz.paddock.controller.auth.login.request;

import com.kolhoz.paddock.controller.GeneralRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class LoginRequest extends GeneralRequest {
    private String username;
    private String password;
}
