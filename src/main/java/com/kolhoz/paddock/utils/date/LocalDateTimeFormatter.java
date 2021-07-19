package com.kolhoz.paddock.utils.date;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

    public static String parseToDateFormat() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    public static String parseToDateTimeFormat() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }
}
