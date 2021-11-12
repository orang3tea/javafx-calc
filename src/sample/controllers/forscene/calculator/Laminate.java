package sample.controllers.forscene.calculator;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.controllers.ControllerAction;
import sample.controllers.Paths;

public class Laminate extends ControllerAction {
    @FXML
    private TextField widthCentimeters;

    @FXML
    private TextField widthMeters;
    @FXML
    private TextField lengthCentimeters;

    @FXML
    private TextField lengthMeters;
    @FXML
    private TextField areaPack;

    @FXML
    private Label label;


    @FXML
    private static final String[] variantsFofChoiceBox = {"кв. метрах", "упаковках"};

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button resultButton;

    @FXML
    private ImageView goBack;

    @FXML
    private ChoiceBox<String> resultOutBox;


    @FXML
    void goBack(MouseEvent event) {
        setNewScene(resultButton, Paths.TO_FLOOR_WINDOW);
    }

    @FXML
    void initialize() {
        resultOutBox.getItems().addAll(variantsFofChoiceBox);
        resultOutBox.setValue(variantsFofChoiceBox[0]);
        resultOutBox.setOnAction(this::changeBox);

        typeCheck(lengthMeters);
        typeCheck(lengthCentimeters);
        typeCheck(widthCentimeters);
        typeCheck(widthMeters);
        typeCheck(areaPack);


    }

    private void changeBox(javafx.event.ActionEvent actionEvent) {
        getChoice(resultOutBox);
    }

    private void getChoice(ChoiceBox<String> choiceBox) {
        String choice = resultOutBox.getValue();
        if (choice.equals("упаковках")) {
            label.setDisable(false);
            areaPack.setDisable(false);
            areaPack.setEditable(true);
        } else {
            label.setDisable(true);
            areaPack.setDisable(true);
            areaPack.setEditable(false);
        }
    }


}