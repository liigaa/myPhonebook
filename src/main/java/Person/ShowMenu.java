package Person;

import java.util.ArrayList;

public class ShowMenu {
    public ArrayList<Person> persons = new ArrayList<Person>();

    public String addPerson(Person person) {
        this.persons.add(person);
        return person.name + " added successfully!";
    }
    public ArrayList<Person> getAllPersons() {

        return persons;
    }

    public String removeContact(int perIndex){
        try {
            persons.remove(perIndex);
        } catch (Exception ex){
            return "Unable to remove Contact";
        }
        return "Contact removed successfully";
    }

    public Person findByName(String name) {
        for (Person person: persons) {
            if (person.name.equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }
    public Person findByPhoneNum(String phoneNum) {
        for (Person person: persons) {
            if (person.phoneNumber.equalsIgnoreCase(phoneNum)) {
                return person;
            }
        }
        return null;
    }
    public Person findByEmail(String email){
        for (Person person: persons){
            if (person.email.equalsIgnoreCase(email)){
                return person;
            }
        }
        return null;
    }

    public Person updateCont(int perIndex, Person person) {
        return persons.set(perIndex,person);
    }
}
