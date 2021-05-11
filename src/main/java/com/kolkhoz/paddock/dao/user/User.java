package com.kolkhoz.paddock.dao.user;

import com.kolkhoz.paddock.dao.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "BIRTHDAY")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate birthday;

    @Column(name = "CITY")
    private String city;

    @Column(name = "RATING")
    private Long rating;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

}
