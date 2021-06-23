package com.kolhoz.paddock.controller;

import com.kolhoz.paddock.dao.user.User;
import com.kolhoz.paddock.dao.user.UserDto;
import com.kolhoz.paddock.dao.user.repository.UserService;
import com.kolhoz.utils.security.AuthenticatedUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final static Logger log = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth/login")
    public ResponseEntity<UserDto> login(@RequestParam String username, @RequestParam String password, @AuthenticationPrincipal User user) {
        AuthenticatedUserDetails authenticatedUserDetails = userService.loadUserByUsername(username);

        if (authenticatedUserDetails.getUser().getPassword().equalsIgnoreCase(password)) {
            return new ResponseEntity<>(userService.convertToDto(authenticatedUserDetails.getUser()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/auth/logout")
    public ResponseEntity<String> logout(@RequestParam String username) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/auth/registration")
    public ResponseEntity<UserDto> registration() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
