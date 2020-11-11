package logic;

import java.util.ArrayList;

public class ContactList implements ContactListInterface {

    private static ArrayList<Person> contactList = new ArrayList<>();

    public void addPerson(Person person) {
        contactList.add(person);
    }

    public void deletePerson(Person person) {
        contactList.remove(person);
    }

    public ArrayList<Person> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Person> contactList) {
        ContactList.contactList = contactList;
    }

}
