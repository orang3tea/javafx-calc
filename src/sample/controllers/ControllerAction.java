package sample.controllers;


import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerAction {
     public static final int NORMAL_WIDTH = 1024;
     public static final int NORMAL_HEIGHT = 707;
     public static final int SMALL_WIDTH = 600;
     public static final int SMALL_HEIGHT = 400;



     static void setNewScene(Button button, int width, int height, String path)  {
         try {
             Parent root = FXMLLoader.load(Objects.requireNonNull(ControllerAction.class.getResource(path)));
             Stage window = (Stage) button.getScene().getWindow();
             window.setScene(new Scene(root, width, height));
         }
         catch (IOException e) {
             e.printStackTrace();
         }
    }

    protected static void setNewScene(Button button, String path)  {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(ControllerAction.class.getResource(path)));
            Stage window =(Stage) button.getScene().getWindow();
            window.setScene(new Scene(root, NORMAL_WIDTH, NORMAL_HEIGHT));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected static void openNewWindow(String pathToScene, boolean resizable, int width, int height){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ControllerAction.class.getResource(pathToScene));
        try{
            loader.load();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, width, height));
        stage.setResizable(resizable);
        stage.showAndWait();
    }

}