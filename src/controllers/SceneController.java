/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uap.Uap;

/**
 *
 * @author adiha
 */
public class SceneController {
    public void changeScene(String sceneName) throws IOException{
        Parent window1;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/".concat(sceneName).concat(".fxml")));
        
        window1 = loader.load();
        Stage window1Stage;
        Scene window1Scene = new Scene(window1);
        window1Stage = Uap.stage;
        window1Stage.setScene(window1Scene);
    }
}
