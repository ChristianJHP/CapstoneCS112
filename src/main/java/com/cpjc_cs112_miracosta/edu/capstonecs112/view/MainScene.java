package com.cpjc_cs112_miracosta.edu.capstonecs112.view;

import com.cpjc_cs112_miracosta.edu.capstonecs112.controller.Controller;
import com.cpjc_cs112_miracosta.edu.capstonecs112.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MainScene extends Scene {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private ImageView blacksmithIV = new ImageView();
    private ComboBox<String> blacksmithNameCB = new ComboBox<>();

    private TextField priceAmountTF = new TextField();
    private Label priceErrLabel = new Label("Price is required.");

    private TextField knifeModelTF = new TextField();
    private Label knifeModelErrLabel = new Label("Model is required.");

    private TextField notesTF = new TextField();

    private ListView<Blacksmith> blacksmithsLV = new ListView<>();

    private Button removeButton = new Button("- Remove Knife");
    private Button addButton = new Button("+ Add Knife");

    private Controller controller = Controller.getInstance();
    private ObservableList<Blacksmith> blacksmithsList;
    private Blacksmith selectedSmith;

    public MainScene() {
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        // DONE: Uncomment after configuring res folder
        blacksmithIV.setImage(new Image("CutCheese.png"));
        blacksmithIV.setFitWidth(WIDTH);
        blacksmithIV.setFitHeight(400);
        pane.add(blacksmithIV, 0, 0, 3, 1);

        pane.add(new Label("Blacksmith:"), 0, 1);
        pane.add(blacksmithNameCB, 1, 1);

        // add items to combo box
        // 2 Combobox:
        // 1) SelectedIndex
        // 2) SelectedItem
        blacksmithNameCB.getItems().addAll("Ueda", "Ohkazan", "Soshin", "Issei Shin");
        blacksmithsLV.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) ->selectSmith(newVal));
        // Select individual by default
        blacksmithNameCB.getSelectionModel().select("Ueda");

        /*pane.add(nameTF, 0, 2);
        pane.add(nameErrLabel, 0, 2);
        nameErrLabel.setTextFill(Color.RED);
        nameErrLabel.setVisible(false); */

        pane.add(new Label("Knife Model:"), 0, 2);
        pane.add(knifeModelTF, 1, 2);

        pane.add(new Label("Price $:"), 0, 4);
        pane.add(priceAmountTF, 1, 4);

        pane.add(new Label("Notes"), 0, 6);
        pane.add(notesTF, 1, 6);

        // Wire up add button to addSmith method

        pane.add(addButton, 1, 7);
        blacksmithsLV.setPrefWidth(WIDTH);
        pane.add(blacksmithsLV, 0, 8, 3, 1);
        pane.add(removeButton, 0, 9);

        // TODO: Uncomment when Controller.java is complete
        blacksmithsList = controller.getAllBlacksmiths();
        blacksmithsLV.setItems(blacksmithsList);

        if (selectedSmith == null)
            removeButton.setDisable(true);
        removeButton.setDisable(true);
        addButton.setOnAction(e -> addSmith());
        removeButton.setOnAction(e -> removeSmith());

        this.setRoot(pane);
    }

    private void removeSmith() {
        //TODO:	If the selected job is null, return
        if (selectedSmith == null)
            return;
        //TODO: Otherwise, remove the selected job from the list
        blacksmithsList.remove(selectedSmith);
        //TODO:	Update the display when done.
        blacksmithsLV.refresh();
        blacksmithsLV.getSelectionModel().select(-1);
        updateDisplay();

    }

    private void selectSmith(Blacksmith newVal) {
        selectedSmith = newVal;
        removeButton.setDisable(selectedSmith == null);
    }


  private void addSmith() {

        String knifeModel, notes;
        double price = 0.0;

        knifeModel = knifeModelTF.getText();
        knifeModelErrLabel.setVisible(knifeModel.isEmpty());

        try {
            price = Double.parseDouble(priceAmountTF.getText());
            priceErrLabel.setVisible(price < 0.0);
        } catch (NumberFormatException e) {
            priceErrLabel.setVisible(true);
        }

        notes = notesTF.getText();
        String choice = blacksmithNameCB.getValue();
      System.out.println(blacksmithNameCB.getValue());

        switch(choice){
            case "Udea":
                blacksmithsList.add(0, new Ueda(knifeModel, price, notes));
                break;
            case "Issei Shin":
                blacksmithsList.add(0, new IsseiShin(knifeModel, price, notes));
                break;
            case "Ohkazan":
                blacksmithsList.add(0, new Ohkazan(knifeModel, price, notes));
                break;
            case "Soshin":
                blacksmithsList.add(0, new Soshin(knifeModel, price, notes));
                break;
        }
        updateDisplay();
      blacksmithsList.add(0, new Ueda("UD-BU165", 174, "last available"));
      blacksmithsList.add(0, new IsseiShin("IS-OR160", 154, "n/a"));
      blacksmithsList.add(0, new Soshin("SS-OR210", 189, "demo"));
      blacksmithsList.add(0, new Ohkazan("OK-BU165", 189, "demo"));

        clearInputs();
    }


    private void updateDisplay()
    {
        FXCollections.sort(blacksmithsList);
        blacksmithsLV.refresh();
    }

    private void clearInputs()
    {
        blacksmithNameCB.getSelectionModel().select("Ueda");
        priceAmountTF.setText("");
        knifeModelTF.setText("");
        notesTF.setText("");

    }

}