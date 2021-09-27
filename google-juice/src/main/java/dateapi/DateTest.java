package dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.Date;

public class DateTest {

    private static final WeekFields weekFields = WeekFields.ISO;

    public static final ZoneId UTC = ZoneId.of("UTC");
    private static final long START_DAY_OF_WEEK = 1;
    private static final long END_DAY_OF_WEEK = 7;

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        Date date = new Date();
        System.out.println("Date: " + date);

        System.out.println("Yesterday: " + getYesterday(date));
        System.out.println("Floor: " + getFloor(date));
        System.out.println("Ceiling: " + getCeiling(date));

        TimeRange timeRange = getWeekTimeRange(date, date);
        System.out.println("Week TR" + timeRange);

        TimeRange timeRange1 = getDayTimeRange(date);
        System.out.println("Day TR" + timeRange1);
    }



    private static TimeRange getDayTimeRange(Date fromDate) {
        LocalDate yesterdayDate = getYesterday(fromDate);

        return TimeRange.builder()
                .from(Day.builder().date(yesterdayDate).build())
                .to(Day.builder().date(yesterdayDate).build())
                .build();
    }

    private static TimeRange getWeekTimeRange(Date fromDate, Date toDate) {
        LocalDateTime ceiling = getCeiling(fromDate);
        LocalDateTime floor = getFloor(toDate);

        return TimeRange.builder()
                .from(Week.builder()
                        .week(ceiling.get(weekFields.weekOfWeekBasedYear()))
                        .year(ceiling.get(weekFields.weekBasedYear()))
                        .build())
                .to(Week.builder()
                        .week(floor.get(weekFields.weekOfWeekBasedYear()))
                        .year(floor.get(weekFields.weekBasedYear()))
                        .build())
                .build();
    }

    private static LocalDate getYesterday(Date date) {
        return LocalDate
                .now()
                .minusDays(1l)
                ;
    }

    private static LocalDateTime getFloor(Date toDate) {
        return LocalDateTime
                .ofInstant(toDate.toInstant(), UTC)
                .with(weekFields.dayOfWeek(), END_DAY_OF_WEEK)
                .withHour(23)
                .withMinute(59)
                .withSecond(59);
    }

    private static LocalDateTime getCeiling(Date fromDate) {
        return LocalDateTime
                .ofInstant(fromDate.toInstant(), UTC)
                .with(weekFields.dayOfWeek(), START_DAY_OF_WEEK)
                .withHour(0)
                .withMinute(0)
                .withSecond(0);
    }
}
