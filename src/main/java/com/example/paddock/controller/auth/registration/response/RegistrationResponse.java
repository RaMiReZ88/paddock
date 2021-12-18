package com.example.paddock.controller.auth.registration.response;

import com.example.paddock.controller.common.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class RegistrationResponse extends Response {

    private final String status;
}
