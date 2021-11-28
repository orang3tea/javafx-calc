package sample.controllers.forscene.calculator;

import java.net.URL;
import javafx.scene.control.ChoiceBox;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.controllers.ControllerAction;
import sample.controllers.Paths;

public class Plaster extends Calculations {
    @FXML
    private static final String[] variantsFofChoiceBox = {"цем-я штукатурка","гипс-я штукатурка",
            "шпатлевка старт", "шпатлевка финиш"};

    static private TextField[] allTextFields;

    @FXML
    private ChoiceBox<String> materials;

    @FXML
    private Label resultLabelBottom;

    @FXML
    private Label resultLabelTop;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ResultButton;

    @FXML
    private TextField coatingThickness;

    @FXML
    private ImageView goBack;

    @FXML
    private TextField heightCentimeters;

    @FXML
    private TextField heightMeters;

    @FXML
    private TextField lengthCentimeters;

    @FXML
    private TextField lengthMeters;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField widthCentimeters;

    @FXML
    private TextField widthMeters;

    @FXML
    void goBack(MouseEvent event) {
    setNewScene(ResultButton, Paths.TO_WALL_WINDOW);
    }

    @FXML
    void initialize() {
        assert ResultButton != null : "fx:id=\"ResultButton\" was not injected: check your FXML file 'plaster.fxml'.";
        assert goBack != null : "fx:id=\"goBack\" was not injected: check your FXML file 'plaster.fxml'.";

        allTextFields = new TextField[] {lengthMeters, lengthCentimeters, widthMeters, widthCentimeters,
                heightMeters, heightCentimeters, coatingThickness};
        typeCheck(allTextFields);

        materials.getItems().addAll(variantsFofChoiceBox);
        materials.setValue(variantsFofChoiceBox[0]);

    }

    @FXML
    void calculate(ActionEvent event) {
        int length;
        int width;
        int height;
        String depth;
        String materialsVolume;

        if(checkFields(allTextFields)) {
            length = asOneNumber(lengthMeters, lengthCentimeters);
            width = asOneNumber(widthMeters, widthCentimeters);
            height = asOneNumber(heightMeters, heightCentimeters);
            depth = coatingThickness.getText();
            materialsVolume = countMaterialsVolume(wallsArea(length, width, height), depth);

            resultLabelTop.setText("объем готовой смеси, м.куб    " + materialsVolume);
            resultLabelBottom.setText("вес готовой смеси, кг    " + countMaterialWeight(materialsVolume, materials.getValue()));

        }
        else
            resultLabelTop.setText(ERROR_MESSAGE);


    }


}