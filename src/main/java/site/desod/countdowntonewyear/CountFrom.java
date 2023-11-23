package site.desod.countdowntonewyear;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class CountFrom {

    private Date fromDate;

    private Date targetDate;

    private int toYear;

    private long diff;

    public CountFrom set(Date from) {
        fromDate = from;
        return this;
    }

    public CountFrom toYear(int year) {
        toYear = year;
        setTargetDate(toYear);
        return this;
    }

    private void setTargetDate(int year) {
        targetDate = new GregorianCalendar(year, Calendar.JANUARY, 1).getTime();
    }

    public void setDiff() {
        if (0 == toYear) {
            setTargetDate((new GregorianCalendar().get(Calendar.YEAR)) + 1);
        }
        if (null == fromDate) {
            fromDate = new Date();
        }
        diff = targetDate.getTime() - fromDate.getTime();
    }

    public long countYear() {
        setDiff();
        return countDays() / 365;
    }

    public long countMonths() {
        setDiff();
        return countDays() / 30;
    }

    public long countDays() {
        setDiff();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public long countHours() {
        setDiff();
        return TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public long countMinutes() {
        setDiff();
        return TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
    }

    public long countSeconds() {
        setDiff();
        return TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
