package logic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateToAge {

    public String calculateAge(String birthDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(birthDate, formatter);

        LocalDate now = LocalDate.now();
        Long age = ChronoUnit.YEARS.between(birthday, now);

        return age.toString();
    }
}
