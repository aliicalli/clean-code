package org.etiya.core.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static LocalDate getDateToLocalDate(Date tarih) {
        return LocalDate.from(tarih.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());
    }

    public static Date addDayToDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date removeDayToDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -day);
        return calendar.getTime();
    }

    public static int dayDiffrenceBetweenTwoDays(Date startDate, Date endDate) {
        LocalDate sdate = getDateToLocalDate(startDate);
        LocalDate edate = getDateToLocalDate(endDate);

        return (int) ChronoUnit.DAYS.between(sdate, edate);
    }
}
