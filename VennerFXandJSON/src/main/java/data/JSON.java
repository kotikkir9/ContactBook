package data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import logic.ContactList;
import logic.Person;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JSON implements JSONInterface {

    public void saveList () {

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter myWriter = mapper.writer(new DefaultPrettyPrinter());

        try {
            myWriter.writeValue(Paths.get("ContactList.json").toFile(), new ContactList().getContactList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadList () {

        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Person> contactList = new ArrayList<>();
            //THE MOST FUCKING IMPORTANT FUCKING LINE TO READ FROM THE FUCKING JSON FILE!!! DO NOT DELETE!!!
            mapper.findAndRegisterModules();


            contactList = mapper.readValue(Paths.get("ContactList.json").toFile(),
                    new TypeReference<ArrayList<Person>>() {});

            new ContactList().setContactList(contactList);
        } catch (IOException e) {
            System.out.println("JSON file not found.");
        }
    }
}
