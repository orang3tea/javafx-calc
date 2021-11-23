package sample.controllers.forscene.calculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.controllers.ControllerAction;
import sample.controllers.Paths;

public class Wallpaper extends Calculations {

    static private TextField[] allTextFields;
    static private TextField[] wallpaperFieldsInMeters;


    @FXML
    private static final String[] variantsFofChoiceBox = {"кв. метрах", "трубках"};

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ResultButton;

    @FXML
    private TextField heightCentimeters;

    @FXML
    private TextField heightMeters;

    @FXML
    private TextField lengthCentimeters;

    @FXML
    private TextField lengthMeters;

    @FXML
    private TextField resultField;

    @FXML
    private TextField tubeLength;

    @FXML
    private Label tubeLengthLabel;

    @FXML
    private Label tubeSizeLabel;

    @FXML
    private TextField tubeWidth;

    @FXML
    private Label tubeWidthLabel;

    @FXML
    private TextField widthCentimeters;

    @FXML
    private TextField widthMeters;


    @FXML
    private ImageView goBack;

    @FXML
    private Label label;


    @FXML
    void goBack(MouseEvent event) {
    setNewScene(ResultButton, Paths.TO_WALL_WINDOW);
    }

    @FXML
    void initialize() {
        assert ResultButton != null : "fx:id=\"ResultButton\" was not injected: check your FXML file 'wallpaper.fxml'.";
        assert goBack != null : "fx:id=\"goBack\" was not injected: check your FXML file 'wallpaper.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'wallpaper.fxml'.";

        allTextFields = new TextField[] {lengthMeters, lengthCentimeters, widthMeters, widthCentimeters,
                    heightMeters, heightCentimeters, tubeWidth, tubeLength};
        wallpaperFieldsInMeters = new TextField[] {lengthMeters, lengthCentimeters, widthMeters, widthCentimeters,
                    heightMeters, heightCentimeters};


        choiceBox.getItems().addAll(variantsFofChoiceBox);
        choiceBox.setValue(variantsFofChoiceBox[1]);
        choiceBox.setOnAction(this::changeBox);

        typeCheck(allTextFields);


    }
    private void changeBox(javafx.event.ActionEvent actionEvent) {
        getChoice(choiceBox);
    }

    private void getChoice(ChoiceBox<String> choiceBox) {
        String choice = choiceBox.getValue();

        if (choice.equals("трубках")) {

            tubeSizeLabel.setDisable(false);
            tubeLengthLabel.setDisable(false);
            tubeWidthLabel.setDisable(false);
            tubeWidth.setDisable(false);
            tubeWidth.setEditable(true);
            tubeLength.setDisable(false);
            tubeLength.setEditable(true);


        } else {
            tubeSizeLabel.setDisable(true);
            tubeLengthLabel.setDisable(true);
            tubeWidthLabel.setDisable(true);
            tubeWidth.setDisable(true);
            tubeWidth.setEditable(false);
            tubeLength.setDisable(true);
            tubeLength.setEditable(false);
        }
    }

    @FXML
    void calculate(ActionEvent event) {
        int length;
        int width;
        int height;
        int packLength;
        int packWidth;

        if(choiceBox.getValue().equals("кв. метрах")) {
            if(checkFields(wallpaperFieldsInMeters)){
                length = asOneNumber(lengthMeters, lengthCentimeters);
                width = asOneNumber(widthMeters, widthCentimeters);
                height = asOneNumber(heightMeters, heightCentimeters);
                resultField.setText(wallsArea(length,width, height));
            }
            else
                resultField.setText(ERROR_MESSAGE);
        }
        else
        {
            if(checkFields(allTextFields)) {
                length = asOneNumber(lengthMeters, lengthCentimeters);
                width = asOneNumber(widthMeters, widthCentimeters);
                height = asOneNumber(heightMeters, heightCentimeters);
                packLength = Integer.parseInt(tubeLength.getText());
                packWidth = Integer.parseInt(tubeWidth.getText());
                resultField.setText(countTubes(wallsArea(length, width, height), countPackArea(packLength, packWidth)));
            }
            else
                resultField.setText(ERROR_MESSAGE);
        }
    }

}