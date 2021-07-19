package com.kolhoz.paddock.dao.user.repository;

import com.kolhoz.paddock.dao.user.User;
import com.kolhoz.paddock.exception.request.*;
import com.kolhoz.paddock.exception.GeneralException;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthValidator {

    private final static String EMAIL_REGEX_PATTERN = "^.+@.+\\..+$";

    public static User validate(final User user) throws Exception {
        return User.builder()
                .username(validateUsername(user.getUsername()))
                .password(validatePassword(user.getPassword()))
                .nickname(validateNickname(user.getNickname()))
//                .email(validateEmail(user.getEmail))
//                .number(validateNumber(user.getNumber))
                .build();
    }

    public static String validateUsername(final String username) throws InvalidUsernameException {
        if (StringUtils.hasText(username) && (username.length() >= 3 && username.length() <= 255)) {
            return username;
        }
        else {
            throw new InvalidUsernameException("Invalid username: " + username);
        }
    }

    public static String validatePassword(final String password) throws InvalidPasswordException {
        if (StringUtils.hasText(password)) {
            return password;
        }
        else {
            throw new InvalidPasswordException("Invalid password: " + password);
        }
    }

    public static String validateNickname(final String nickname) throws InvalidNicknameException {
        if (StringUtils.hasText(nickname) && (nickname.length() >= 3 && nickname.length() <= 255)) {
            return nickname;
        }
        else {
            throw new InvalidNicknameException("Invalid nickname: " + nickname);
        }
    }

    public static String validateEmail(final String email) throws InvalidEmailException {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);

        if (StringUtils.hasText(email) && matcher.matches()) {
            return email;
        }
        else {
            throw new InvalidEmailException("Invalid email: " + email);
        }
    }

    public static String validateNumber(final String number) throws InvalidNumberException {
        return null;
    }
}
