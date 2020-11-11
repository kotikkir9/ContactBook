package logic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateStringToLocalDate {

    public static LocalDate getBirthdayLocalDate(String birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdayLocal = LocalDate.parse(birthday, formatter);
        return birthdayLocal;
    }
}
