package sample.controllers.forscene.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.controllers.ControllerAction;
import sample.controllers.Paths;

public class Laminate extends ControllerAction {

    @FXML
    private static final String[] variantsFofChoiceBox = {"кв. метрах", "упаковках"};

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ResultButton;

    @FXML
    private ImageView goBack;

    @FXML
    private ChoiceBox<String> resultOutBox;

    @FXML
    void goBack(MouseEvent event) {
        setNewScene(ResultButton, Paths.TO_FLOOR_WINDOW);
    }

    @FXML
    void initialize() {
        resultOutBox.getItems().addAll(variantsFofChoiceBox);
        resultOutBox.setValue(variantsFofChoiceBox[0]);

    }

}