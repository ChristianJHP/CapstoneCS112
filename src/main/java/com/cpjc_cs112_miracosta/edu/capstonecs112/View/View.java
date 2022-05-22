package com.cpjc_cs112_miracosta.edu.capstonecs112.View;

import com.cpjc_cs112_miracosta.edu.capstonecs112.Controller.Controller;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;


    public class View extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            ViewNavigator.setStage(primaryStage);
            //TODO: Uncomment when res folder has been configured:
            primaryStage.getIcons().add(new Image("Logo.png"));
            ViewNavigator.loadScene("JKS Inventory", new MainScene());
        }

        @Override
        public void stop() throws Exception {
            // TODO: Uncomment when finished with Controller.java
            Controller.getInstance().saveData();
        }

        public static void main(String[] args) {
            Application.launch(args);

        }
    }