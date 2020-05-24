/*
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class CountingSundays {

    public static void main(String[] args) {
        System.out.println(findNumberOfSundays(1901, 2000));    // 171
    }

    /*
    Most of the code in this method is repeated in getToStartingDayOfWeek(), but didn't need to do the counting Sundays part in that method.
    More code, but more efficient.
     */
    private static int findNumberOfSundays(int startYear, int endYear) {
        int totalSundays = 0;
        // start by getting to the first year to count Sundays for so dayOfWeek is correct
        int dayOfWeek = getToStartingDayOfWeek(startYear);

        // start counting Sundays in this loop
        for (int year = startYear; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                int daysInMonth = getDaysInMonth(month, year);
                for (int day = 1; day <= daysInMonth; day++) {
                    if (day == 1 && dayOfWeek == 0) {
                        totalSundays++;
                    }
                    // if it's Saturday, go back to 0 for Sunday
                    if (dayOfWeek == 6){
                        dayOfWeek = 0;
                    } else {
                        dayOfWeek++;
                    }
                }
            }
        }
        return totalSundays;
    }

    private static int getToStartingDayOfWeek(int startYear) {
        int dayOfWeek = 1; // 0 is Sunday, but 1/1/1900 was a Monday
        for (int year = 1900; year < startYear; year++) {
            for (int month = 1; month <= 12; month++) {
                int daysInMonth = getDaysInMonth(month, year);
                for (int day = 1; day <= daysInMonth; day++) {
                    // if it's Saturday, go back to 0 for Sunday
                    if (dayOfWeek == 6){
                        dayOfWeek = 0;
                    } else {
                        dayOfWeek++;
                    }
                }
            }
        }
        return dayOfWeek;
    }

    private static int getDaysInMonth(int month, int year) {
        int days = 0;
        if (month == 2) {
            // if February falls on a leap year:
            days = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else {
            days = 31;
        }
        return days;
    }
}
