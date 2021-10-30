package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController {

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

    //dummmyyy
    public void toSceneWall() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxml/WallWindow.fxml"));
        Stage window =(Stage) wallButton.getScene().getWindow();
        window.setScene(new Scene(root, 1024, 707));
    }

    public void aboutProgram() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/fxml/AboutProgram.fxml"));
        try{
            loader.load();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.showAndWait();
    }

}
