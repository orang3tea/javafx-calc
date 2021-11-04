package sample.controllers.forscene.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.controllers.ControllerAction;
import sample.controllers.Paths;

public class Wallpaper extends ControllerAction {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ResultButton;

    @FXML
    private TextField areaPack;

    @FXML
    private TextField areaPack1;

    @FXML
    private ImageView goBack;

    @FXML
    private Label label;

    @FXML
    private ChoiceBox<?> resultOutBox;

    @FXML
    void goBack(MouseEvent event) {
    setNewScene(ResultButton, Paths.TO_WALL_WINDOW);
    }

    @FXML
    void initialize() {
        assert ResultButton != null : "fx:id=\"ResultButton\" was not injected: check your FXML file 'wallpaper.fxml'.";
        assert areaPack != null : "fx:id=\"areaPack\" was not injected: check your FXML file 'wallpaper.fxml'.";
        assert areaPack1 != null : "fx:id=\"areaPack1\" was not injected: check your FXML file 'wallpaper.fxml'.";
        assert goBack != null : "fx:id=\"goBack\" was not injected: check your FXML file 'wallpaper.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'wallpaper.fxml'.";
        assert resultOutBox != null : "fx:id=\"resultOutBox\" was not injected: check your FXML file 'wallpaper.fxml'.";

    }

}