package com.kolhoz.paddock.dao.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Role {

    ADMIN("ADMIN"),
    USER("USER"),
    MODERATOR("MODERATOR"),
    NEWSMAKER("NEWSMAKER"),
    SUPPORT("SUPPORT");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Role getRoleFromCode(String value) {
        return Arrays.stream(Role.values())
                .filter(role -> role.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Role{" +
                "value='" + value + '\'' +
                '}';
    }
}
