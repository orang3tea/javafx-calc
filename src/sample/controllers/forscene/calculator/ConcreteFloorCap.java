package sample.controllers.forscene.calculator;

import java.net.URL;
import java.text.MessageFormat;
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


public class ConcreteFloorCap extends Calculations {
    public static final String topMessagePattern = "необходимо цемента : {0} уп-к ";
    public static final String bottomMessagePattern = "необходимо песка : {0} кг";

    static private TextField[] fieldsForTypeCheck;

    @FXML
    private Label topResult;

    @FXML
    private Label bottomResult;

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
    private TextField packMass;

    @FXML
    void goBack(MouseEvent event) {
        setNewScene(ResultButton, Paths.TO_FLOOR_WINDOW);
    }

    @FXML
    void calculate(ActionEvent event) {
        int length;
        int width;
        String materialsVolume;
        String bagMass;


        if(checkFields(fieldsForTypeCheck)) {
            length = asOneNumber(lengthMeters, lengthCentimeters);
            width = asOneNumber(widthMeters, widthCentimeters);
            materialsVolume = countMaterialsVolume(countFloorArea(length, width), coatingThickness.getText());
            bagMass = packMass.getText();
            String[] result = countMaterialPack(materialsVolume, bagMass);

            topResult.setText(MessageFormat.format(topMessagePattern, result[0]));
            bottomResult.setText(MessageFormat.format(bottomMessagePattern, result[1]));
        }
        else resultLabel.setText(ERROR_MESSAGE);

    }

    @FXML
    void initialize() {
        fieldsForTypeCheck = new TextField[] {lengthCentimeters, lengthMeters, widthCentimeters, widthMeters, packMass};
        assert ResultButton != null : "fx:id=\"ResultButton\" was not injected: check your FXML file 'concreteFloorCap.fxml'.";
        assert goBack != null : "fx:id=\"goBack\" was not injected: check your FXML file 'concreteFloorCap.fxml'.";


        typeCheck(fieldsForTypeCheck);



    }
}