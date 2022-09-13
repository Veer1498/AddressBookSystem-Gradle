package com.addressbook;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressBookCSV {
    public static final String CSV_FILENAME = "D:\\RFP-175\\AddressBookSystem-Gradle\\AddressBookSystem\\src\\main\\resources\\addressbookCSV.csv";
    static File file = new File(CSV_FILENAME);

    /**
     * The File class is an abstract representation of file and directory pathname.
     * A pathname can be either absolute or relative.
     *
     * The File class have several methods for working with directories and files
     * such as creating new directories or files, deleting and renaming directories or files,
     * listing the contents of a directory etc.
     */
    public static void createFile() {
        try{
            file.createNewFile();
            System.out.println("File Has Been Created");
        } catch (IOException e) {
            System.out.println(" Error Occurred in Creating File" );
        }
    }

    public static void write_CSVFile(){
        try{
            //instatiating the CSVWriter  Class
            CSVWriter write = new CSVWriter(new FileWriter(CSV_FILENAME));


            //Writer Data into File
            AddressBook addressBook = new AddressBook();
            //Converting list to Array and Storing in Object Array
            Object [] obj = addressBook.personsList.toArray();
            // Converting Object Array into a String Array
            String [] str = Arrays.asList(obj).toArray(new String[obj.length]);
            // Again Storing Whole Array Objects into a List
            List<String [] > list = new ArrayList<>();
            //Adding Contact Object into list
            list.add(str);
            write.writeAll(list);
            write.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
