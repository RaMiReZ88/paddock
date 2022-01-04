package com.example.paddock.utils.validator;

import com.example.paddock.controller.auth.registration.request.RegistrationRequest;
import com.example.paddock.dao.user.dto.UserDto;
import com.example.paddock.exception.request.validate.InvalidEmailException;
import com.example.paddock.exception.request.validate.InvalidNicknameException;
import com.example.paddock.exception.request.validate.InvalidPasswordException;
import com.example.paddock.exception.request.validate.InvalidValidateException;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidator {

    private final static String EMAIL_REGEX_PATTERN = "^.+@.+\\..+$";

    public static UserDto validate(final RegistrationRequest registrationRequest) throws InvalidValidateException {
        return UserDto.builder()
                .login(validateNickname(registrationRequest.getNickname()))
                .password(validatePassword(registrationRequest.getPassword(), registrationRequest.getMatchPassword()))
                .nickname(validateNickname(registrationRequest.getNickname()))
                .email(validateEmail(registrationRequest.getEmail()))
                .build();
    }

    private static String validateNickname(final String nickname) throws InvalidNicknameException {
        if (StringUtils.hasText(nickname) && (nickname.length() >= 3 && nickname.length() <= 255)) {
            return nickname;
        }
        else {
            throw new InvalidNicknameException("Invalid nickname: " + nickname);
        }
    }

    private static String validatePassword(final String password, final String matchPassword) throws InvalidPasswordException {
        if (StringUtils.hasText(password) && password.length() >= 8 && password.equals(matchPassword)) {
            return password;
        }
        else {
            throw new InvalidPasswordException("Invalid password: " + password);
        }
    }

    private static String validateEmail(final String email) throws InvalidEmailException {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);

        if (StringUtils.hasText(email) && matcher.matches()) {
            return email;
        }
        else {
            throw new InvalidEmailException("Invalid email: " + email);
        }
    }
}
