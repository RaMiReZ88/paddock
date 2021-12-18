package com.example.paddock.controller.common;

import com.example.paddock.utils.date.LocalDateTimeFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class Response {

    private final String uuid = UUID.randomUUID().toString();
    private final String dateTime = LocalDateTimeFormatter.parseToDateTimeFormat();
    private String error;

}
