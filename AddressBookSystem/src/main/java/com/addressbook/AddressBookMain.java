package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;
/**
 * AddressBook Program
 * @author Veer.Singa
 *
 */

//Main Class Containing Main Function
public class AddressBookMain {

    //UC6 Multiple AddressBooks
    HashMap<String,AddressBook> bookMap = new HashMap<String, AddressBook>();
    Scanner sc = new Scanner(System.in);
    AddressBook adressbook = new AddressBook();
    public void multipleAddressBooks(){
        while(true){
            System.out.println("Please Enter 1. Access Address Book 2.Print  0.Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Please Enter AdressBook Name");
                    String name = sc.next();
                    if (bookMap.containsKey(name)){
                        System.out.println("Already Present");
                    }
                    else{
                        System.out.println("Welcome to AddressBook"+name);
                        bookMap.put(name,adressbook);
                        menu();
                    }
                    break;
                case 2:
                    System.out.println("Please Enter AdressBook Name");
                    String search = sc.next();
                    bookMap.get(search);
                    break;
                case 0:
                    System.out.println("Exiting !!!");
                    System.exit(0);
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
