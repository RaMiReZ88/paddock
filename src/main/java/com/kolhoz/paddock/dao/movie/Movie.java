package com.kolhoz.paddock.dao.movie;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIE_SEQ_GENERATOR")
    @SequenceGenerator(name = "MOVIE_SEQ_GENERATOR", sequenceName = "MOVIE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "RATING")
    private String rating;

    @Column(name = "RELEASE_DATE")
    @DateTimeFormat(pattern = "dd-mmmm-yyyy")
    private LocalDate releaseDate;

    @Column(name = "IMAGE")
    private byte [] image;

}
