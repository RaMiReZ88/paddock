package com.example.paddock.controller;

import com.example.paddock.utils.date.LocalDateTimeFormatter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@SuperBuilder
public class Response {

    private final String uuid = UUID.randomUUID().toString();
    private final String dateTime = LocalDateTimeFormatter.parseToDateTimeFormat();
    private final String error;

}
