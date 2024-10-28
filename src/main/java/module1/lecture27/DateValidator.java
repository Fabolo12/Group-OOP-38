package module1.lecture27;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {
    /**
     * Давай реалізуємо валідатор дати. Формат дати — dd.mm.yyyy, де dd — номер дня в місяці, 
     * mm — номер місяця у році, yyyy — рік.
     * Дата перевіряється у методі checkDateFormat(String), якщо дата не відповідає формату, 
     * то метод повинен викинути виняток InvalidDateFormatException.
     *
     * У разі правильного формату перевіряємо рік, місяць і день у відповідних методах checkYearValue, 
     * checkMonthValue і checkDayValue:
     *
     *     рік має бути в діапазоні від 1900 до 2100 включно, інакше кидаємо виняток InvalidYearValueException;
     *     місяць має бути в діапазоні від 1 до 12 включно, інакше кидаємо виняток InvalidMonthValueException;
     *     день повинен бути в діапазоні від 1 до максимального значення дня цього місяця (див. мапу months) 
     *     включно, інакше кидаємо виняток InvalidDayValueException.
     *
     * Ці винятки потрібно створити в окремих класах (файлах), успадкувавши їх від RuntimeException.
     */

    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");

    public static void main(String[] args) {
        String date = "28.02.2019";
        String dateIncorrect1 = "28/02.2019";
        String dateIncorrect2 = "28.20.2019";

        checkDateFormat(date);
//        checkDateFormat(dateIncorrect1);
//        checkDateFormat(dateIncorrect2);
    }
    
    private static void checkDateFormat(final String date) {
        final Matcher matcher = DATE_PATTERN.matcher(date);
        if (!matcher.matches()) {
            throw new InvalidDateFormatException("Invalid date format: " + date);
        }

        String[] dateParts = date.split("\\.");
        checkYearValue(dateParts[2]);
        checkMonthValue(dateParts[1]);
        checkDayValue(dateParts[0]);
    }

    private static void checkYearValue(final String year) {
        int yearValue = Integer.parseInt(year);
        if (yearValue < 1900 || yearValue > 2100) {
            throw new InvalidDateFormatException("Invalid year value: " + year);
        }
    }

    private static void checkMonthValue(final String month) {
        int monthValue = Integer.parseInt(month);
        if (monthValue < 1 || monthValue > 12) {
            throw new InvalidDateFormatException("Invalid month value: " + month);
        }
    }

    private static void checkDayValue(final String day) {
        int dayValue = Integer.parseInt(day);
        final int maxDay = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        if (dayValue < 1 || dayValue > maxDay) {
            throw new InvalidDateFormatException("Invalid year value: " + day);
        }
    }

    static class InvalidDateFormatException extends RuntimeException {
        public InvalidDateFormatException(String message) {
            super(message);
        }
    }
}
