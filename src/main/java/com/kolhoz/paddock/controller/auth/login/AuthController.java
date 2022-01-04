package com.kolhoz.paddock.controller.auth.login;

import com.kolhoz.paddock.controller.auth.login.request.LoginRequest;
import com.kolhoz.paddock.dao.clan.Clan;
import com.kolhoz.paddock.dao.user.dto.UserDto;
import com.kolhoz.paddock.dao.user.repository.UserService;
import com.kolhoz.paddock.controller.auth.login.response.LoginResponse;
import com.kolhoz.paddock.dao.user.repository.AuthValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws UsernameNotFoundException {
        try {
            log.info("Login request : {}, {}", loginRequest.getUsername(), loginRequest.getPassword());

            final UserDto userDto = userService.loadUserByUsername(AuthValidator.validateUsername(loginRequest.getUsername()));

            if (userDto.getPassword().equals(AuthValidator.validatePassword(loginRequest.getPassword()))) {
                return ResponseEntity.ok(LoginResponse.builder()
                        .authenticatedUser(userDto)
                        .error(null)
                        .build());
            }
            else {
                log.error("Invalid password: {}", loginRequest.getPassword());
                return ResponseEntity.ok(LoginResponse.builder()
                        .authenticatedUser(null)
                        .error("Invalid password: " + loginRequest.getPassword())
                        .build());
            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest()
                    .body(LoginResponse.builder()
                            .authenticatedUser(null)
                            .error(e.getMessage())
                            .build());
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam String username) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}