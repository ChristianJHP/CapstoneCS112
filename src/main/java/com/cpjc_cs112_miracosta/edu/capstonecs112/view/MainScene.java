package com.cpjc_cs112_miracosta.edu.capstonecs112.view;

import com.cpjc_cs112_miracosta.edu.capstonecs112.controller.Controller;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import com.cpjc_cs112_miracosta.edu.capstonecs112.model.Blacksmith;

public class MainScene extends Scene {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private ImageView blacksmithIV = new ImageView();
    private ComboBox<String> blacksmithNameCB = new ComboBox<>();
    private TextField nameTF = new TextField();
    private Label nameLabel = new Label("Blacksmith's Name:");
    private Label nameErrLabel = new Label("Name is required.");

    private TextField priceAmountTF = new TextField();

    private TextField notesTF = new TextField();

    private ListView<Blacksmith> blacksmithsLV = new ListView<>();

    private Button removeButton = new Button("- Remove Knife");
    private Button addButton = new Button("+ Add Knife");

    private Controller controller = Controller.getInstance();
    private ObservableList<Blacksmith> blacksmithsList;
    private Blacksmith selectedLaureate;

    public MainScene() {
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        // DONE: Uncomment after configuring res folder
        blacksmithIV.setImage(new Image("CutCheese.png"));
        blacksmithIV.setFitWidth(WIDTH);
        pane.add(blacksmithIV, 0, 0, 3, 1);

        pane.add(new Label("Blacksmith:"), 0, 1);
        pane.add(blacksmithNameCB, 1, 1);

        // add items to combo box
        // 2 Combobox:
        // 1) SelectedIndex
        // 2) SelectedItem
        blacksmithNameCB.getItems().addAll("Ueda", "Ohkazan", "Soshin", "Issei Shin", "Kanmera");
        // Select individual by default
        blacksmithNameCB.getSelectionModel().select("Ueda");

        pane.add(nameLabel, 0, 2);
        pane.add(nameTF, 1, 2);
        pane.add(nameErrLabel, 2, 2);
        nameErrLabel.setTextFill(Color.RED);
        nameErrLabel.setVisible(false);

        pane.add(new Label("Price $:"), 0, 4);
        pane.add(priceAmountTF, 1, 4);

        pane.add(new Label("Notes"), 0, 6);
        pane.add(notesTF, 1, 6);

        // Wire up add button to addSmith method
        addButton.setOnAction(e -> addSmith());

        pane.add(addButton, 1, 7);
        blacksmithsLV.setPrefWidth(WIDTH);
        pane.add(blacksmithsLV, 0, 8, 3, 1);
        pane.add(removeButton, 0, 9);

        // TODO: Uncomment when Controller.java is complete
        blacksmithsList = controller.getAllBlacksmiths();
        blacksmithsLV.setItems(blacksmithsList);

        removeButton.setDisable(true);

        this.setRoot(pane);
    }

    private void removeSmith() {
        // blacksmithsList.remove(selectedBlacksmith);
        blacksmithsLV.refresh();
        blacksmithsLV.getSelectionModel().select(-1);

    }

    private void addSmith() {
        // Read from all the textfields
        // String name = nameTF.getText(), price = (), notes = notesTF.getText();
        // if (name.isEmpty())
            nameErrLabel.setVisible(true);
        //double prizeAmount = Double.parseDouble(prizeAmountTF.getText());
        // blacksmithsList.add(0, new Blacksmith(name, price, notes));
        // tell listview to update, since we have new laureate object
        blacksmithsLV.refresh();
    }

    private void updateDisplay()
    {
        blacksmithsLV.refresh();
    }

}