package sample.controllers.forscene.calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.controllers.Paths;

public class Laminate extends Calculations {
    static private TextField[] laminateFieldsInMeters;
    static private TextField[] laminateFieldsInBoxes;

    @FXML
    private TextField areaPackCentimeters;

    @FXML
    private TextField areaPackMeters;

    @FXML
    private TextField resultMessage;

    @FXML
    private TextField widthCentimeters;

    @FXML
    private TextField widthMeters;
    @FXML
    private TextField lengthCentimeters;

    @FXML
    private TextField lengthMeters;


    @FXML
    private Label label;

    @FXML
    private Label sizeBoxC;

    @FXML
    private Label sizeBoxM;


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
        laminateFieldsInMeters = new TextField[]{widthMeters, widthCentimeters, lengthMeters, lengthCentimeters};
        laminateFieldsInBoxes = new TextField[]{widthMeters, widthCentimeters, lengthMeters, lengthCentimeters};

        resultOutBox.getItems().addAll(variantsFofChoiceBox);
        resultOutBox.setValue(variantsFofChoiceBox[0]);
        resultOutBox.setOnAction(this::changeBox);

        typeCheck(lengthMeters);
        typeCheck(lengthCentimeters);
        typeCheck(widthCentimeters);
        typeCheck(widthMeters);
        typeCheck(areaPackMeters);
        typeCheck(areaPackCentimeters);


    }

    private void changeBox(javafx.event.ActionEvent actionEvent) {
        getChoice(resultOutBox);
    }

    private void getChoice(ChoiceBox<String> choiceBox) {
        String choice = resultOutBox.getValue();
        if (choice.equals("упаковках")) {
            label.setDisable(false);
            areaPackMeters.setDisable(false);
            areaPackMeters.setEditable(true);
            areaPackCentimeters.setDisable(false);
            areaPackCentimeters.setEditable(true);
            sizeBoxC.setDisable(false);
            sizeBoxM.setDisable(false);
        } else {
            label.setDisable(true);
            areaPackMeters.setDisable(true);
            areaPackMeters.setEditable(false);
            areaPackCentimeters.setDisable(true);
            areaPackCentimeters.setEditable(false);
            sizeBoxM.setDisable(true);
            sizeBoxC.setDisable(true);
        }
    }
    @FXML
    void calculate(ActionEvent event) {
        int length;
        int width;
        int boxArea;

        if(resultOutBox.getValue().equals("кв. метрах")) {
            if(checkFields(laminateFieldsInMeters)){
                length = asOneNumber(lengthMeters.getText(), lengthCentimeters.getText());
                width = asOneNumber(widthMeters.getText(), widthCentimeters.getText());
                resultMessage.setText(countLaminateInMeters(length,width));
            }
            else
                resultMessage.setText(ERROR_MESSAGE);
        }
        else
        {
            if(checkFields(laminateFieldsInBoxes)) {
                length = asOneNumber(lengthMeters.getText(), lengthCentimeters.getText());
                width = asOneNumber(widthMeters.getText(), widthCentimeters.getText());
                boxArea = asOneNumber(areaPackMeters.getText(), areaPackCentimeters.getText());
                resultMessage.setText(countLaminateInBoxes(length,width, boxArea));
            }
            else
                resultMessage.setText(ERROR_MESSAGE);
        }
    }


}