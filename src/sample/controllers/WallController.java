package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WallController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button floorButton;

    @FXML
    private ImageView goBack;

    @FXML
    void goBack(MouseEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxml/mainWindow.fxml"));
        Stage window =(Stage) goBack.getScene().getWindow();
        window.setScene(new Scene(root, 1024, 707));

    }



}