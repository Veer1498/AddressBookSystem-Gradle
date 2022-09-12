package com.addressbook;

import java.io.*;

public class AddressBookIO {
    public static final String FILENAME = "D:\\RFP-175\\AddressBookSystem-Gradle\\AddressBookSystem\\src\\main\\resources\\addressbook.txt";
    static File file = new File(FILENAME);

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

    public static void WriteContactsToFile(String contactsData) {
        try{
            /**
             * Java FileOutputStream
             * is an output stream used for writing data to a file.
             * If you have to write primitive values into a file, use FileOutputStream class.
             * You can write byte-oriented as well as character-oriented data through FileOutputStream class.
             * But, for character-oriented data, it is preferred to use FileWriter than FileOutputStream.
             */
            FileOutputStream fileOutput = new FileOutputStream(file);
            byte[] b = contactsData.getBytes();
            fileOutput.write(b);
            fileOutput.close();
            System.out.println("Successfully Contact Added to File");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error Ocuured in Writing Data into File");
        }
    }

    public static void readData() {
        try{
            String filePath = file.getAbsolutePath();
            FileReader fr = new FileReader(filePath);
            /**
             * Java BufferedReader class
             * is used to read the text from a character-based input stream.
             * It can be used to read data line by line by readLine() method.
             * It makes the performance fast. It inherits Reader class.
             */
            BufferedReader reader = new BufferedReader(fr);
            String persondata;
            while((persondata = reader.readLine()) != null){
                System.out.println(persondata+"\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
