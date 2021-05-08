package com.kolkhoz.paddock.dao.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String nickname;
    private String name;
    private Long age;
    private String city;
    private Role role;
}
