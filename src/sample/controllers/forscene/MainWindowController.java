package sample.controllers.forscene;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.controllers.ControllerAction;
import sample.controllers.Paths;

public class MainWindowController extends ControllerAction {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aboutProgrammButton;

    @FXML
    private Button floorButton;

    @FXML
    private Button wallButton;

    public void toSceneWall() {
        setNewScene(wallButton, Paths.TO_WALL_WINDOW);
    }

    public void aboutProgram() {
        openNewWindow(Paths.TO_ABOUT_PROGRAM, false, SMALL_WIDTH, SMALL_HEIGHT);
    }

    public void toSceneFloor() {
        setNewScene(floorButton, Paths.TO_FLOOR_WINDOW);
    }

}
