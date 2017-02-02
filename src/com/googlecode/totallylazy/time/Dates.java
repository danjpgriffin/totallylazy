package com.googlecode.totallylazy.time;

import com.googlecode.totallylazy.Function1;

import java.text.DateFormat;
import java.util.Date;

public class Dates {
   public static final String RFC822 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public static DateFormat RFC822() {
        throw new RuntimeException("DAN");
        //return formatWithDefaultZone(RFC822, GMT);
    }

    public static Date parse(String value) {
        throw new RuntimeException("DAN");
        //return date(value);
    }
//
    public static Function1<String, Date> parse(final DateFormat format) {
        throw new RuntimeException("DAN");
    }

    public static Date date(int year, int month, int day) {
        throw new RuntimeException("DAN");
        //return date(year, month, day, 0);
    }

    public static Date date(int year, int month, int day, int hour, int minute) {
        throw new RuntimeException("DAN");
    }
//
    public static Date date(int year, int month, int day, int hour, int minute, int second) {
        throw new RuntimeException("DAN");
    }

    public static Date date(Date date) {
        return new Date(date.getTime());
    }
}