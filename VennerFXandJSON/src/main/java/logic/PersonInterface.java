package logic;

import java.time.LocalDate;
import java.util.ArrayList;

public interface PersonInterface {

    public String getFirstName();
    public boolean setFirstName(String firstName);

    public String getLastName();
    public boolean setLastName(String lastName);

    public String getEmail();
    public boolean setEmail(String email);

    public String getPhoneNumber();
    public boolean setPhoneNumber(String phoneNumber);

    public String getBirthday();
    public void setBirthDay(LocalDate birthday);

    public ArrayList<String> getInterestArray();
    public void setInterestArray(ArrayList<String> interestArray);

}
