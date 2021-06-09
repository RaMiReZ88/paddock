package com.kolhoz.paddock.dao.movie;

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

    private Long id;
    private String name;
    private String description;
    private Integer duration;
    private String appraisal;
    private LocalDate release;
    private byte [] image;

}
