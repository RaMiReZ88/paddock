package com.example.paddock.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class IdGenerator {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEFAULT_GENERATOR")
    private Long recordId;

}
