package com.kolkhoz.paddock.dao.user;

import com.kolkhoz.paddock.dao.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USR")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "age")
    private Long age;

    @Column(name = "city")
    private String city;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

}
