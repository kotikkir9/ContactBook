package logic;

import java.util.ArrayList;

public class SearchPerson implements SearchPersonInterface{

    public ArrayList<Person> search(String searchText, ArrayList<Person> list) {

        ArrayList<Person> tempList = new ArrayList<>();

        for (Person person : list) {
            if ((person.getFirstName().toLowerCase().contains(searchText.toLowerCase())) ||
                    (person.getLastName().toLowerCase().contains(searchText.toLowerCase())) ||
                    (person.getPhoneNumber().contains(searchText.toLowerCase())) ||
                    (person.getEmail().toLowerCase().contains(searchText.toLowerCase())))

                tempList.add(person);
        }
        return tempList;
    }

}
