package sample.controllers.forscene.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.controllers.ControllerAction;
import sample.controllers.Paths;

public class ConcreteFloorCap extends ControllerAction {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ResultButton;

    @FXML
    private ImageView goBack;

    @FXML
    void goBack(MouseEvent event) {
        setNewScene(ResultButton, Paths.TO_FLOOR_WINDOW);
    }

    @FXML
    void initialize() {
        assert ResultButton != null : "fx:id=\"ResultButton\" was not injected: check your FXML file 'concreteFloorCap.fxml'.";
        assert goBack != null : "fx:id=\"goBack\" was not injected: check your FXML file 'concreteFloorCap.fxml'.";

    }
}