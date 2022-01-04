package com.kolhoz.paddock.controller;

import com.kolhoz.paddock.utils.date.LocalDateTimeFormatter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class GeneralResponse {

    private final String uuid = UUID.randomUUID().toString();
    private final String dateTime = LocalDateTimeFormatter.parseToDateTimeFormat();
    private String error;

}
