package com.cpjc_cs112_miracosta.edu.capstonecs112.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class Model {

    public static final File BINARY_FILE = new File("Knives.dat");

    /*public static boolean binaryFileHasData() {
        return (BINARY_FILE.exists() && BINARY_FILE.length() > 1L);
    } */



    public static ObservableList<Blacksmith> populateListFromBinaryFile() {
        ObservableList<Blacksmith> allBlacksmithsList = FXCollections.observableArrayList();

        //TODO: Check to see if the binary file has data
        try {
            //TODO: If so, instantiate an ObjectInputStream reference to the binary file for reading
            ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE));
            // Read from binary file into an array
            //TODO: Create a temp array of Entry Software Job objects to read from the binary file
            //TODO: Initialize the temp array from the binary file reader.
            Blacksmith[] array = (Blacksmith[]) fileReader.readObject();
            //TODO: Add the temp array to the collection of all entry software jobs (list)
            for (Blacksmith nl : array)
                allBlacksmithsList.add(nl);
            //TODO: Close the binary file reader.
            fileReader.close();
        } catch (IOException | ClassNotFoundException e) {
            //TODO: If an exception occurs, print the message "Error opening binary file for reading."
            System.out.println("Error opening binary file for reading.");
        }
        return allBlacksmithsList;
    }

    public static boolean binaryFileHasData()
    {
        // makes file object and checks if exists
        File binaryFile = new File(String.valueOf(BINARY_FILE));
        // empty files are 4 bytes, if greater then there is data
        return (binaryFile.exists() & binaryFile.length() >= 5L);
    }


    public static boolean writeDataToBinaryFile(ObservableList<Blacksmith> allBlacksmiths) {
        //TODO: Create a temp array of Entry Software Job objects to read from binary file (length should match list size)
        Blacksmith[] array = new Blacksmith[allBlacksmiths.size()];
        //TODO: Loop through the temp array and initialize each element to the corresponding one in the list
        for (int i = 0; i < array.length; i++) {
            array[i] = allBlacksmiths.get(i);
        }
        //TODO: Write the temp array object to the binary file writer
        try {
            //TODO: Instantiate an ObjectOutputStream reference to the binary file for writing
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE));
            fileWriter.writeObject(array);
            fileWriter.close();
        } catch (IOException e) {
            //TODO: If an exception occurs, print its message and return false.
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        //TODO: Close the binary file writer and return true.
        return true;
    }
}
