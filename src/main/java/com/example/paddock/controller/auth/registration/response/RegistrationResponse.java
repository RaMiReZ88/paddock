package com.example.paddock.controller.auth.registration.response;

import com.example.paddock.controller.Response;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class RegistrationResponse extends Response {

    private final String status;
}
