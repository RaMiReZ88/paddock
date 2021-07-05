package com.kolhoz.paddock.controller.auth.login;

import com.kolhoz.paddock.controller.auth.login.request.LoginRequest;
import com.kolhoz.paddock.dao.user.Role;
import com.kolhoz.paddock.dao.user.dto.UserDto;
import com.kolhoz.paddock.dao.user.repository.UserService;
import com.kolhoz.paddock.controller.auth.login.response.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class AuthController {

    private final static Logger log = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws UsernameNotFoundException {
        try {
            log.info("Login request : {}, {}", loginRequest.getUsername(), loginRequest.getPassword());

            UserDto userDto = userService.loadUserByUsername(loginRequest.getUsername());

            if (userDto.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok(LoginResponse.builder()
                        .authenticatedUser(userDto)
                        .error(null)
                        .build());
            }
            else {
                return ResponseEntity.ok(LoginResponse.builder()
                        .authenticatedUser(null)
                        .error("Invalid password: " + loginRequest.getPassword())
                        .build()
                );
            }
        }
        catch (Exception e) {
            log.error("Failed login request - Invalid username: {}", loginRequest.getUsername());
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