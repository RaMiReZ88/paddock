package com.example.paddock.controller.auth.registration;

import com.example.paddock.controller.auth.registration.request.RegistrationRequest;
import com.example.paddock.controller.auth.registration.response.RegistrationResponse;
import com.example.paddock.dao.user.dto.UserDto;
import com.example.paddock.utils.validator.RegistrationValidator;
import com.example.paddock.dao.user.repository.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registration")

@Slf4j
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest registrationRequest) {
        try {
            log.info("Registration request: " + registrationRequest);

            final UserDto registrationUserData = RegistrationValidator.validate(registrationRequest);

            if (userService.findByNickname(registrationUserData.getNickname()) == null) {

                userService.save(registrationUserData);

                return ResponseEntity.ok(RegistrationResponse.builder()
                        .status("success")
                        .status(null)
                        .build());
            }
            else {
                return ResponseEntity.badRequest()
                        .body(RegistrationResponse.builder()
                                .status("User with record id: " + registrationUserData.getRecordId() + " already exists")
                                .build());
            }
        }
        catch (Exception error) {
            log.error("Registration failed: " + registrationRequest);

            return ResponseEntity.badRequest()
                    .body(RegistrationResponse.builder()
                            .status(error.getMessage())
                            .build());
        }
    }
}
