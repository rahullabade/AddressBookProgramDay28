package com.company;

public class AddressBookMain {

    public static void main(String[] args) {
	System.out.println("Welcome to AddressBook Program");

        PersonDetails person = new PersonDetails();
        person.Name("Rahul");
        person.LastName("Labade");
        person.Address("Shivaji Nagar");
        person.City("Nagpur");
        person.State("MP");
        person.Zip(465123);
        person.PhoneNumber("789456133");
        person.Email("rahulgha05@gmail.com");
        System.out.println(person.toString());
    }
}
