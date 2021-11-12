package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AddDetails {
    Scanner scanDetails = new Scanner(System.in);
    AddressBookMain Details = new AddressBookMain();

    // Edit method use to edit the data.
    public void editContact(ArrayList<PersonDetail> contactDetails) {
        String data = scanDetails.nextLine();
        for (int i = 0; i < contactDetails.size(); i++) {
            if (contactDetails.get(i).getFirstName().equals(data)) {
                System.out.println("1. Enter The update First Name :");
                System.out.println("2. Enter The update LastName. ");
                System.out.println("3. Enter The update Address. ");
                System.out.println("4. Enter The update City. ");
                System.out.println("5. Enter The update State. ");
                System.out.println("6. Enter The update ZipCode. ");
                System.out.println("7. Enter The update PhoneNumber. ");
                System.out.println("9. Enter The update Email. ");
                int replace = scanDetails.nextInt();
                scanDetails.nextLine();

                switch (replace) {

                    case 1:
                        System.out.println("Enter the First Name");
                        String firstNameData = scanDetails.nextLine();
                        contactDetails.get(i).setFirstName(firstNameData);
                        break;

                    case 2:
                        System.out.println("Enter the Last Name");
                        String lastNameData = scanDetails.nextLine();
                        contactDetails.get(i).setLastName(lastNameData);
                        break;

                    case 3:
                        System.out.println("Enter the Address");
                        String addressData = scanDetails.nextLine();
                        contactDetails.get(i).setAddress(addressData);
                        break;

                    case 4:
                        System.out.println("Enter the City");
                        String cityData = scanDetails.nextLine();
                        contactDetails.get(i).setCity(cityData);
                        break;

                    case 5:
                        System.out.println("Enter the State");
                        String stateData = scanDetails.nextLine();
                        contactDetails.get(i).setState(stateData);
                        break;

                    case 6:
                        System.out.println("Enter the Zip Code");
                        String zipCodeData = scanDetails.nextLine();
                        contactDetails.get(i).setZipCode(zipCodeData);
                        break;

                    case 7:
                        System.out.println("Enter the Phone Number");
                        String phoneNumberData = scanDetails.nextLine();
                        contactDetails.get(i).setPhoneNumber(phoneNumberData);
                        break;

                    case 8:
                        System.out.println("Enter the Email");
                        String emailData = scanDetails.nextLine();
                        contactDetails.get(i).setEmail(emailData);
                        break;

                    default:
                        System.out.println("you have not update any details");
                        break;
                }
            }
        }
    }

    // Delete method use to delete the data.
    public void deleteContact(ArrayList<PersonDetail> contactDetails) {
        System.out.println("Enter The Name");
        String data = scanDetails.nextLine();
        for (int i = 0; i < contactDetails.size(); i++) {
            if (contactDetails.get(i).getFirstName().equals(data)) {
                contactDetails.remove(i);
            } else
                System.out.println("not match any details");
        }
    }

    // Ignore Duplicate method when added details.
    public boolean duplicateDetailsRemove(ArrayList<PersonDetail> addNewDetails, String firstName) {
        boolean result = addNewDetails.stream().filter(personDetail -> personDetail.getFirstName().equals(firstName)).findFirst().isPresent();
        return result;
    }

    // search Person in a City or State across the multiple AddressBook.
    public void searchDetails(Hashtable<Integer, ArrayList<PersonDetail>> hashtable) {
        System.out.println("Enter the City or State Name");
        String cityOrStateName = scanDetails.nextLine();
        int totalNumberOfCount = 0;
        for (int i = 1; i <= hashtable.size(); i++) {
            List<PersonDetail> numberOfCity = hashtable.get(i).stream().filter(search -> search.getCity().equalsIgnoreCase(cityOrStateName)
                    || search.getState().equals(cityOrStateName)).collect(Collectors.toList());
            System.out.println("Details of CityOrState " + numberOfCity + "\n"
                    + "Number of Times " + numberOfCity.size()
                    + "Count by CityOrState " + numberOfCity.stream().count());
            totalNumberOfCount = (int) (totalNumberOfCount + numberOfCity.stream().count());
        }
        System.out.println("Total number of counted by added city or state " + totalNumberOfCount);
    }

    public void sortFirstName(Hashtable<Integer, ArrayList<PersonDetail>> sortedDetails) {
        for (int i = 1; i <= sortedDetails.size(); i++) {
            System.out.println(sortedDetails.get(i).stream().sorted(Comparator.comparing(PersonDetail::getFirstName)).collect(Collectors.toList()));
        }
    }

    public void sortCity(Hashtable<Integer, ArrayList<PersonDetail>> sortedDetails) {
        for (int i = 1; i <= sortedDetails.size(); i++) {
            System.out.println(sortedDetails.get(i).stream().sorted(Comparator.comparing(PersonDetail::getCity)).collect(Collectors.toList()));
        }
    }

    public void sortZipCode(Hashtable<Integer, ArrayList<PersonDetail>> sortedDetails) {
        for (int i = 1; i <= sortedDetails.size(); i++) {
            System.out.println(sortedDetails.get(i).stream().sorted(Comparator.comparing(PersonDetail::getZipCode)).collect(Collectors.toList()));
        }
    }

    public void fileInputOutputStream(Hashtable<Integer, ArrayList<PersonDetail>> hashtableDetails) throws IOException {
        FileOutputStream filePath = new FileOutputStream("C:\\Users\\Altamash\\IdeaProjects\\AddressBookCollection\\file.txt");
        ObjectOutputStream fileObject = new ObjectOutputStream(filePath);
        fileObject.writeObject(hashtableDetails);

    }

    public static void writeToFile(Hashtable<Integer, ArrayList<PersonDetail>> writeDetails) {
        try {
            FileWriter fileWriter = new FileWriter("addressBook.csv");
            String stream = String.valueOf(writeDetails);
            fileWriter.write(stream);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile() {
        try {
            FileReader fileReader = new FileReader("addressBook.csv");
            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
