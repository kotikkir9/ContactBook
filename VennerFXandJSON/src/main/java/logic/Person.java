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

    public boolean setFirstName(String firstName) {
        if(firstName.matches("[A-ZÆØÅ][a-zæøå]+")) {
            this.firstName = firstName;
            return true;
        } else {
            return false;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if(lastName.matches("[A-ZÆØÅ][a-zæøå]+")) {
            this.lastName = lastName;
            return true;
        } else {
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email.matches("[a-z0-9._+-]+@[a-z0-9.-]+\\.[a-z]{2,3}") || email.equals("")) {
            this.email = email;
            return true;
        } else {
            return false;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches("(\\+45)?[0-9]{8}") || phoneNumber.equals("")) {
            this.phoneNumber = phoneNumber;
            return true;
        } else {
            return false;
        }
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
