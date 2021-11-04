package sample.controllers.forscene;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.controllers.ControllerAction;
import sample.controllers.Paths;

public class WallController extends ControllerAction {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView goBack;

    @FXML
    private Button plasterButton;

    @FXML
    private Button puttyButton;

    @FXML
    private Button wallpaperButton;

    @FXML
    void goBack(MouseEvent event)throws Exception{
        setNewScene(plasterButton, Paths.TO_MAIN_WINDOW);

    }


     public void toScenePlaster() {

    }


    public void toScenePutty() {

    }


    public void toSceneWallpaper() {
    setNewScene(wallpaperButton, Paths.TO_WALLPAPER);
    }



}