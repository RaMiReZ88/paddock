package com.kolhoz.paddock.dao.movie;

import com.kolhoz.paddock.dao.IdGenerator;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MOVIE")
@SequenceGenerator(name = "MOVIE_RECORD_ID_GENERATOR", sequenceName = "MOVIE_SEQ", allocationSize = 1)

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends IdGenerator {

    private String title;

    private String genre;

    private String description;

    private Integer duration;

    private String rating;

    private String appraisal;

    @DateTimeFormat(pattern = "dd-mmmm-yyyy")
    private LocalDate releaseDate;

    private byte [] image;

}
