package com.pluralsight;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy")));

        // GMT time
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println(gmtTime.format(DateTimeFormatter.ofPattern("HH:mm")));

    }
}
