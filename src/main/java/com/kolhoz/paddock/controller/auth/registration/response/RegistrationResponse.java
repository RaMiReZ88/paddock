package com.kolhoz.paddock.controller.auth.registration.response;

import com.kolhoz.paddock.controller.GeneralResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class RegistrationResponse extends GeneralResponse {

}
