package com.cpjc_cs112_miracosta.edu.capstonecs112.Controller;

import com.cpjc_cs112_miracosta.edu.capstonecs112.Model.Blacksmith;
import com.cpjc_cs112_miracosta.edu.capstonecs112.Model.Model;
import javafx.collections.ObservableList;

public class Controller {

    private static Controller theInstance;
    private ObservableList<Blacksmith> mAllBlacksmiths;

    public static Controller getInstance() {
        return null;
    }

    public ObservableList<Blacksmith> getAllBlacksmiths() {
        return mAllBlacksmiths;
    }

    public void saveData() {
        Model.writeDataToBinaryFile(mAllBlacksmiths);
    }
}


