package com.example.paddock.controller.common;

import com.example.paddock.utils.date.LocalDateTimeFormatter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class Request {

    private final String uuid = UUID.randomUUID().toString();
    private final String dateTime = LocalDateTimeFormatter.parseToDateTimeFormat();

}
