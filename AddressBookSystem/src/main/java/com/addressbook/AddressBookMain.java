package com.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * AddressBook Program
 * @author Veer.Singa
 *
 */

//Main Class Containing Main Function
public class AddressBookMain {
    AddressBook adressbook = new AddressBook();

    //UC6 Multiple AddressBooks
    HashMap<String,AddressBook> bookMap = new HashMap<String, AddressBook>();
    Scanner sc = new Scanner(System.in);
    public void multipleAddressBooks(){
        while(true){
            System.out.println("Please Enter 1. Access Address Book 2.Print 3. display all contacts 4.To Print Contacts 5.To search by city  0.Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Please Enter Address Book Name");
                    String name = sc.next();
                    if (bookMap.containsKey(name)){
                        System.out.println("Already Present Adding names to old book");
                        adressbook.addContact();
                        bookMap.put(name,adressbook);
                    }
                    else{
                        System.out.println("Welcome to AddressBook"+name);
                        adressbook.addContact();
                        bookMap.put(name,adressbook);
                    }
                    break;
                case 2:
                    System.out.println("All AddressBooks");
                    Set<String > keys = bookMap.keySet();
                    for(String key : keys){
                        System.out.println(" "+key);
                    }
                    break;
                case 3:
                    Set<Map.Entry<String,AddressBook>> book = bookMap.entrySet();
                    for (Map.Entry contacts : book){
                        System.out.println(contacts.getKey());
                        AddressBook allcontacts = (AddressBook) contacts.getValue();
                        allcontacts.display();
                        break;
                    }
                case 4:
                    System.out.println("Please Enter Address Book Name");
                    String bname = sc.next();
                    if (bookMap.containsKey(bname)) {
                        System.out.println("Already Present Adding names to old book");
                        AddressBook adressbook = bookMap.get(bname);
                        adressbook.display();
                    }
                case 5:
                    Set<Map.Entry<String,AddressBook>> books = bookMap.entrySet();
                    System.out.println("Enter place to search");
                    String place = sc.next();
                    for (Map.Entry contacts : books) {
                        System.out.println(contacts.getKey());
                        AddressBook allcontacts = (AddressBook) contacts.getValue();
                        allcontacts.SearchbyCity(place);
                    }
                    break;

                case 0:
                    System.out.println("Exiting !!!");
                    return;
            }
        }
    }

    public static void menu() {
        // TODO Auto-generated method stub
        System.out.println("Welcome to Address Book Program");
        System.out.println("*******************************");
        AddressBook addressbook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\nAddressBook Options ");
            System.out.println("\n1.AddContact \n2.Edit Contact\n3.Delete Contact\n4.Number of Saved Contact\n5.Display\n6.Close AddressBook");
            int check = sc.nextInt();
            switch(check){
                case 1:
                    addressbook.addContact();
                    break;
                case 2:
                    addressbook.editContact();
                    break;
                case 3 :
                    addressbook.deleteContact();
                    break;
                case 4 :
                    addressbook.numOfContacts();
                    break;
                case 5 :
                    addressbook.display();
                    break;
                case 6 :
                    return;

            }
        }
    }
}
