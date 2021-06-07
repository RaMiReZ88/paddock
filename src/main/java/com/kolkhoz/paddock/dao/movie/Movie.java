package com.kolkhoz.paddock.dao.movie;

import liquibase.pro.packaged.A;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MOVIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "APPRAISAL")
    private String appraisal;

    @Column(name = "RELEASE")
    @DateTimeFormat(pattern = "dd-mmmm-yyyy")
    private LocalDate release;

    @Column(name = "IMAGE")
    private byte [] image;

}
