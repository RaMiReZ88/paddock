package com.example.paddock.dao.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {

    private Long recordId;
    private String title;
    private String genre;
    private String description;
    private Integer duration;
    private String rating;
    private String appraisal;
    private LocalDate releaseDate;
    private byte[] image;

}
