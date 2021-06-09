package com.kolhoz.paddock.dao.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String nickname;
    private String name;
    private LocalDate birthday;
    private String city;
    private Long rating;
    private Role role;

}
