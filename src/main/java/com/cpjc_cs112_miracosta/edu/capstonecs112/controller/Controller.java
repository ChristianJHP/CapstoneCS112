package com.cpjc_cs112_miracosta.edu.capstonecs112.controller;

import com.cpjc_cs112_miracosta.edu.capstonecs112.model.Blacksmith;
import com.cpjc_cs112_miracosta.edu.capstonecs112.model.Model;
import javafx.collections.ObservableList;

public class Controller {

    private static Controller theInstance;
    private ObservableList<Blacksmith> mAllBlacksmiths;

    //TODO: Create a private constructor to enforce Singleton pattern (separate from getInstance())
    private Controller() {
    }

    public static Controller getInstance() {
        //TODO: If the instance is null, assign it to a new Controller, then check to see if the binary file has data
        if (theInstance == null)
            theInstance = new Controller();
        if (Model.binaryFileHasData())
            theInstance.mAllBlacksmiths = Model.populateListFromBinaryFile();
        //TODO: If so, assign the mAllJobsList to the populateListFromBinaryFile() method
        //TODO: Otherwise, assign it to a new observableArrayList()
        return theInstance;
    }

    public ObservableList<Blacksmith> getAllBlacksmiths() {
        return mAllBlacksmiths;
    }

    public void saveData() {
        Model.writeDataToBinaryFile(mAllBlacksmiths);
    }
}


