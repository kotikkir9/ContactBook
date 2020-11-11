package logic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Person implements PersonInterface{

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birthday;
    private ArrayList<String> interestArray;


    public Person() {
        firstName = null;
        lastName = null;
        email = null;
        phoneNumber = null;
        birthday = null;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthDay(LocalDate birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String birthdayString = birthday.format(formatter);
        this.birthday = birthdayString;

    }

    public ArrayList<String> getInterestArray() {
        return interestArray;
    }

    public void setInterestArray(ArrayList<String> interestArray) {
        this.interestArray = interestArray;
    }
}
