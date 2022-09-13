package com.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Address Book Program
 * @author Veer.Singa
 *
 */

//AddressBook Class for Managing Different Operations
public class AddressBook {
    List<ContactPerson> personsList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int count = 0;


    //Adding Contact into AddressBook
    public void addContact(){

        ContactPerson contact = new ContactPerson();
        count++;
        System.out.println("Enter Details to Add Contact\n");
        System.out.println("Enter a first name:");
        contact.setFirstName(sc.next());

        System.out.println("Enter a last name:");
        contact.setLastName(sc.next());

        System.out.println("Enter a Address:");
        contact.setAddress(sc.next());

        System.out.println("Enter a City name:");
        contact.setCity(sc.next());

        System.out.println("Enter a state:");
        contact.setState(sc.next());

        System.out.println("Enter a zip code:");
        contact.setZipNo(sc.nextInt());

        System.out.println("Enter a phone number:");
        contact.setPhoneNo(sc.nextLong());
        System.out.println("===================================");
        personsList.add(contact);
        System.out.println("Contact Added to AddressBook");
    }

    //Editing the contact of AddressBook
    public void editContact() {
        if(count == 0) {
            System.out.println("No contacts to Edit");
            return;
        }
        System.out.println("Please Enter the First Name of Person You Want to Edit For");
        String name = sc.next();
        boolean isAvailable = false;
        for(ContactPerson contact : personsList) {
            if(contact.getFirstName().equals(name)) {
                while(true) {
                    isAvailable = true;
                    System.out.println("Choose option to Edit");
                    System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number \n8.Exit");
                    int option = sc.nextInt();
                    switch(option){
                        case 1:
                            System.out.println("Enter FirstName");
                            contact.setFirstName(sc.next());
                            break;
                        case 2:
                            System.out.print("Enter a Last name:");
                            contact.setLastName(sc.next());
                            break;
                        case 3:
                            System.out.print("Enter a Address:");
                            contact.setAddress(sc.next());
                            break;
                        case 4:
                            System.out.print("Enter a city:");
                            contact.setCity(sc.next());
                            break;
                        case 5:
                            System.out.print("Enter a state:");
                            contact.setState(sc.next());
                            break;
                        case 6:
                            System.out.print("Enter a zip code:");
                            contact.setZipNo(sc.nextInt());
                            break;
                        case 7:
                            System.out.print("Enter a phone number:");
                            contact.setPhoneNo(sc.nextLong());
                            break;
                        case 8:
                            System.out.println("Back to AddressBook");
                            return;
                        default:
                            System.out.println("enter valid contact");
                            break;
                    }
                }
            }
            System.out.println("Contact Edited Succesfully");
        }
        if(isAvailable == false) {
            System.out.println("Contact Not Found");
        }
    }


    //Delete Contact of AddressBook
    public void deleteContact() {
        if(count == 0) {
            System.out.println("No contacts to Delete");
            return;
        }
        System.out.println("Delete Contact");
        System.out.println("confirm the name to delete contact");
        String confirmName = sc.next();
        boolean isAvailable = false;
        for(ContactPerson contact : personsList) {
            if (contact.getFirstName().equals(confirmName)) {
                isAvailable = true;
                personsList.remove(contact);
                System.out.println("Contact Deleted");
                count--;
                break;
            }
        }
        if(isAvailable == false) {
            System.out.println("Contact Not Found");
        }
    }

    //To Display All Contacts of AddressBook
    public void display() {
        for(ContactPerson contact : personsList) {
            System.out.println(contact);
        }
        if(personsList.size() == 0) {
            System.out.println("No Contacts to Display\n");
        }
    }

    //Number of Contacts Present in AddressBook
    public void numOfContacts() {
        System.out.println("The Contacts Saved in Book : "+count);
    }

    //Read and Write To a File Function
    public void Read_Write_ToFile(){
        /*
        Calling Methods from AddressBookIO Class
         */
        AddressBookIO.createFile();
        String contactsData = personsList.toString();
        AddressBookIO.WriteContactsToFile(contactsData);
        AddressBookIO.WriteContactsToFile(contactsData);
        AddressBookIO.readData();
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "personsList=" + personsList +
                '}';
    }
}
