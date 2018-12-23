package com.amtkxa.springbootreladomosimple.infrastructure.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;

public class DateUtils {
  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("YYY-MM-dd");

  private static final DateTimeFormatter DATE_TIME_FORMATTER_FULL = DateTimeFormat.forPattern("YYY-MM-dd HH:mm:ss.SSS");

  public static Timestamp parseFull(String dateTimeString) {
    DateTime dateTime = DATE_TIME_FORMATTER_FULL.parseDateTime(dateTimeString);
    return new Timestamp(dateTime.toDateTime().getMillis());
  }

  public static String printFull(Timestamp ts) {
    return DATE_TIME_FORMATTER_FULL.print(ts.getTime());
  }

  public static Timestamp parse(String dateTimeString) {
    DateTime dateTime = DATE_TIME_FORMATTER.parseDateTime(dateTimeString);
    return new Timestamp(dateTime.toDateTime().getMillis());
  }

  public static String print(Timestamp ts) {
    return DATE_TIME_FORMATTER.print(ts.getTime());
  }

  public static Timestamp getCurrentTimestamp() {
    return new Timestamp(System.currentTimeMillis());
  }
}
