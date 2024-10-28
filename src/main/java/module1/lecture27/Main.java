package module1.lecture27;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        LocalDate birthday = LocalDate.of(2019, 2, 28);
        LocalDate nextBirthday = birthday.plusYears(1);
        LocalDate firstBirthday = birthday.plusYears(-30);

        new Date();

        System.out.println(birthday);
        System.out.println(nextBirthday);
        System.out.println(firstBirthday);
    }
}
