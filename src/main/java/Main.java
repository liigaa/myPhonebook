import Person.Person;
import Person.ShowMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ShowMenu showMenu = new ShowMenu();
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Main main = new Main();
        main.showRoom();

    }

    void showRoom() {
        String userInput;

        do {
            System.out.println("\nWelcome to the Phonebook! Please choose activity: ");
            System.out.println("1.Add person");
            System.out.println("2.View all persons");
            System.out.println("3.Remove contact");
            System.out.println("4.Find contact by name");
            System.out.println("5.Find contact by phone number");
            System.out.println("6.Update contact");
            System.out.println("\nEnter QUIT to end program...");
            System.out.println("Choose a number");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    addPerson();
                    break;
                case "2":
                    viewAllPersons();
                    break;
                case "3":
                    removeByContact();
                    break;
                case "4":
                    findByName();
                    break;
                case "5":
                    findByPhoneNum();
                    break;
                case "6":
                    updateContact();
                    break;
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("Quit"));
        return;

    }

    void addPerson() {
        System.out.println("Add person");
        Person person = new Person();
        System.out.println("Enter Name ");
        person.name = scanner.nextLine();
        System.out.println("Enter phone number ");
        person.phoneNumber = scanner.nextLine();
        System.out.println("Enter email ");
        person.email = scanner.nextLine();
        String message = showMenu.addPerson(person);
        System.out.println(message);
    }

    void viewAllPersons() {
        ArrayList<Person> allPersons = showMenu.getAllPersons();
        System.out.println("All Contacts");
        for (Person person : allPersons) {
            System.out.println(person.name + "\t" + person.phoneNumber + "\t" + person.email);
        }

    }

    void removeByContact() {
        System.out.println("Choose a contact to delete ");
        System.out.println("Enter Name");
        String perName = scanner.nextLine();
        Person person = showMenu.findByName(perName);
        int perIndex = showMenu.getAllPersons().indexOf(person);
        System.out.println(showMenu.removeContact(perIndex));

    }

    void findByName() {
        System.out.println("Choose a Contact to find ");
        System.out.println("Enter name");
        String perName = scanner.nextLine();
        Person person = showMenu.findByName(perName);
        System.out.println(person.name + "\t" + person.phoneNumber + "\t" + person.email);

    }

    void findByPhoneNum() {
        System.out.println("Choose a Contact to find ");
        System.out.println("Enter Phone number");
        String perPhone = scanner.nextLine();
        Person person = showMenu.findByPhoneNum(perPhone);
        System.out.println(person.name + "\t" + person.phoneNumber + "\t" + person.email);
    }

    //    void updateContactByName(){
//        System.out.println("Update Contact \nEnter name");
//        String perName = scanner.nextLine();
//        Person person = showMenu.findByName(perName);
//        int perIndex = showMenu.getAllPersons().indexOf(person);
//        System.out.println("Enter the property you would like to change");
//        String property = scanner.nextLine();
//        System.out.println("Enter the new value of " + property);
//        String value = scanner.nextLine();
//        value.equalsIgnoreCase("name");
//
//        switch (property) {
//            case "name":
//                person.name=value;
//                break;
//            case "phone number":
//                person.phoneNumber=value;
//                break;
//            case "email":
//                person.email=value;
//            default:
//                System.out.println("Please provide a valid property");
//                break;
//        }
//        showMenu.updateCont(perIndex, person);
//        System.out.println(person.name + " updated successfully");
//    }
    void updateContact() {
        String userInput = scanner.nextLine();
        do {
            System.out.println("\nWelcome to update menu!");
            System.out.println("1.Update name");
            System.out.println("2.Update phone number");
            System.out.println("3.Update email");
            System.out.println("Enter END to quit menu");
            System.out.println("Chose activity");
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    updateName();
                    break;
                case "2":
                    updateNumber();
                    break;
                case "3":
                    updateEmail();
                    break;
            }
        }while (!userInput.equalsIgnoreCase("end"));
        return;
    }
    void updateName(){
        System.out.println("Enter name");
        String perName =  scanner.nextLine();
        Person person = showMenu.findByName(perName);
        int perIndex = showMenu.getAllPersons().indexOf(person);
        System.out.println("Enter new name");
        person.name = scanner.nextLine();
        showMenu.updateCont(perIndex,person);
        System.out.println(person.name + " updated successfully");
    }
    void updateNumber(){
        System.out.println("Enter phone number");
        String phonNum=scanner.nextLine();
        Person person = showMenu.findByPhoneNum(phonNum);
        int perIndex = showMenu.getAllPersons().indexOf(person);
        System.out.println("Enter new phone number");
        person.phoneNumber = scanner.nextLine();
        showMenu.updateCont(perIndex,person);
        System.out.println(person.phoneNumber + " updated successfully");
    }
    void updateEmail(){
        System.out.println("Enter email");
        String email=scanner.nextLine();
        Person person = showMenu.findByEmail(email);
        int perIndex = showMenu.getAllPersons().indexOf(person);
        System.out.println("Enter new email");
        person.email = scanner.nextLine();
        showMenu.updateCont(perIndex,person);
        System.out.println(person.email + " updated successfully");
    }
}
