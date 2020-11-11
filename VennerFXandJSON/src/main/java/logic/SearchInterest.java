package logic;

import java.util.ArrayList;

public class SearchInterest implements SearchInterestInterface{

    public ArrayList<Person> searchInterest(String interestChoice) {

        ArrayList<Person> tempList = new ArrayList<>();

        for(Person person : new ContactList().getContactList()) {
            for(String interest : person.getInterestArray()) {
                if(interest.toLowerCase().contains(interestChoice.toLowerCase())) {
                    tempList.add(person);
                }
            }
        }
        return tempList;
    }
}
