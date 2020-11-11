package logic;

import java.time.LocalDate;
import java.util.ArrayList;

public interface PersonInterface {

    public String getFirstName();
    public void setFirstName(String firstName);

    public String getLastName();
    public void setLastName(String lastName);

    public String getEmail();
    public void setEmail(String email);

    public String getPhoneNumber();
    public void setPhoneNumber(String phoneNumber);

    public String getBirthday();
    public void setBirthDay(LocalDate birthday);

    public ArrayList<String> getInterestArray();
    public void setInterestArray(ArrayList<String> interestArray);

}
