package tn.pi.studentmanagement.tools.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tools {

    public static String PATTERN_SCORE = "yyyy-MM-dd";

    private Tools() {

    }

    public static LocalDate parseDateStringScore(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_SCORE);
        return LocalDate.parse(dateString, formatter);
    }
}
