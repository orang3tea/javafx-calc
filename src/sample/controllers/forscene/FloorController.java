package sample.controllers.forscene;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.controllers.ControllerAction;
import sample.controllers.Paths;

public class FloorController extends ControllerAction {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button floorButton;

    @FXML
    private ImageView goBack;

    @FXML
    void goBack(MouseEvent event) {
        setNewScene(floorButton, Paths.TO_MAIN_WINDOW);
    }
    public void toCalculator() {
        setNewScene(floorButton, Paths.TO_LAMINATE_CALC);
    }



}
