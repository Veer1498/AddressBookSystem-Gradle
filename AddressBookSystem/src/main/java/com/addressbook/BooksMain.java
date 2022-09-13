package com.addressbook;


/**
 * Address Book Program
 * @author Veer.Singa
 *
 */
public class BooksMain {
    //Main Function
    public static void main(String[] args) {
        AddressBookMain main = new AddressBookMain();
        main.multipleAddressBooks();

//        //UC 13 - Storing Data into a File
//        System.out.println("Writing Whole Data into  a File");
//        AddressBook addressBook = new AddressBook();
//        addressBook.Read_Write_ToFile();

        //UC14 - Storing Data into an CSV File

        System.out.println("Writing Data into an CSV File");
        AddressBookCSV csvBook = new AddressBookCSV();
        csvBook.createFile();
        csvBook.write_CSVFile();

    }

}
