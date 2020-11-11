package logic;

import java.util.ArrayList;

public interface ContactListInterface {

    public void addPerson(Person person);

    public void deletePerson(Person person);

    public ArrayList<Person> getContactList();

    public void setContactList(ArrayList<Person> contactList);
}
