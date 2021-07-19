package com.kolhoz.paddock.controller.auth.registration;

import com.kolhoz.paddock.controller.auth.registration.request.RegistrationRequest;
import com.kolhoz.paddock.controller.auth.registration.response.RegistrationResponse;
import com.kolhoz.paddock.dao.user.Role;
import com.kolhoz.paddock.dao.user.User;
import com.kolhoz.paddock.dao.user.dto.UserDto;
import com.kolhoz.paddock.dao.user.repository.AuthValidator;
import com.kolhoz.paddock.dao.user.repository.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registration")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class RegistrationController {

    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest registrationRequest) {
        log.info("Registration request: " + registrationRequest);

        try {
            User registrationUserData = AuthValidator.validate(userService.convertToEntity(
                    UserDto.builder()
                            .id(registrationRequest.getId())
                            .username(registrationRequest.getUsername())
                            .password(registrationRequest.getPassword())
                            .nickname(registrationRequest.getNickname())
                            .birthday(registrationRequest.getBirthday())
                            .email(registrationRequest.getEmail())
                            .city(registrationRequest.getCity())
                            .registrationDateTime(registrationRequest.getRegistrationDateTime())
                            .expirationSubsDate(registrationRequest.getExpirationSubsDate())
                            .userRole(Role.USER)
                            .build()));

            if (userService.findUserById(registrationUserData.getId()) == null || userService.findUserByNickname(registrationUserData.getNickname()) == null) {
                userService.save(registrationUserData);

                return ResponseEntity.ok(RegistrationResponse.builder()
                        .error(null)
                        .build());
            }
            else {
                return ResponseEntity.badRequest()
                        .body(RegistrationResponse.builder()
                                .error("User with id: " + registrationUserData.getId() + " already exists")
                                .build());
            }

        }
        catch (Exception e) {
            log.error("Registration failed: " + registrationRequest);
            return ResponseEntity.badRequest()
                    .body(RegistrationResponse.builder()
                            .error(e.getMessage())
                            .build());
        }
    }

}
