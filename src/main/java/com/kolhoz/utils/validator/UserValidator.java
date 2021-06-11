package com.kolhoz.utils.validator;

import com.kolhoz.paddock.dao.user.User;
import com.kolhoz.paddock.exception.request.InvalidNicknameException;
import com.kolhoz.paddock.exception.GeneralException;
import com.kolhoz.paddock.exception.request.InvalidUsernameException;
import org.springframework.util.StringUtils;

public class UserValidator {

    public static User validateUserObjectRequest(final User user) throws GeneralException {
        return User.builder()
                .username(validateName(user.getUsername()))
                .nickname(validateNickname(user.getNickname()))
                .birthday(user.getBirthday())
                .city(user.getCity())
                .gameRating(user.getGameRating())
                .build();
    }

    private static String validateName(final String username) throws InvalidUsernameException {
        if (StringUtils.hasText(username) && (username.length() >= 3 && username.length() <= 255)) {
            return username;
        }
        else {
            throw new InvalidUsernameException("Username " + username + " is not valid");
        }
    }

    private static String validateNickname(final String nickname) throws InvalidNicknameException {
        if (StringUtils.hasText(nickname) && (nickname.length() >= 3 && nickname.length() <= 255)) {
            return nickname;
        }
        else {
            throw new InvalidNicknameException("Nickname " + nickname + " is not valid");
        }
    }

    private static Integer validateAge() {
       return null;
    }

    private static String validateCity() {
        return null;
    }
}
