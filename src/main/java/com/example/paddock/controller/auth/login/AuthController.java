package com.example.paddock.controller.auth.login;

import com.example.paddock.controller.auth.login.request.LoginRequest;
import com.example.paddock.dao.user.dto.UserDto;
import com.example.paddock.dao.user.repository.UserService;
import com.example.paddock.controller.auth.login.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody final LoginRequest loginRequest) throws UsernameNotFoundException {
        try {
            log.info("Login request: {}, {}", loginRequest.getLogin(), loginRequest.getPassword());

            final UserDto userDto = userService.loadUserByUsername(loginRequest.getLogin());

            if (userDto.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok(createLoginResponse(userDto, null));
            } 
            else {
                log.error("Invalid password: {}", loginRequest.getPassword());

                return ResponseEntity.badRequest()
                        .body(createLoginResponse(null, "Invalid password: " + loginRequest.getPassword()));
            }
        } 
        catch (Exception exception) {
            log.error(exception.getMessage());

            return ResponseEntity.badRequest()
                    .body(createLoginResponse(null, exception.getMessage()));
        }
    }

    private LoginResponse createLoginResponse(final UserDto user, final String textError) {
        return LoginResponse.builder()
                .authenticatedUser(user)
                .error(textError)
                .build();
    }
}