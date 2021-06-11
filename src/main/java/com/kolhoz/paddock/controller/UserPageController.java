package com.kolhoz.paddock.controller;

import com.kolhoz.paddock.dao.user.UserDto;
import com.kolhoz.paddock.dao.user.repository.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserPageController {

    private final UserService userService;

    public UserPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public ResponseEntity<UserDto> getCurrentlyLoggedUser() {
        return new ResponseEntity<>(
                userService.getCurrentlyLoggedUser(),
                HttpStatus.OK
        );
    }
}