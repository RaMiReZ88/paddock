package com.example.paddock.dao.movie;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MOVIE")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIE_SEQ_GENERATOR")
    @SequenceGenerator(name = "MOVIE_SEQ_GENERATOR", sequenceName = "MOVIE_SEQ", allocationSize = 1)
    @Column(name = "RECORD_ID")
    private Long recordId;

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

    @Column(name = "APPRAISAL")
    private String appraisal;

    @Column(name = "RELEASE_DATE")
    @DateTimeFormat(pattern = "dd-mmmm-yyyy")
    private LocalDate releaseDate;

    @Column(name = "IMAGE")
    private byte [] image;

}
