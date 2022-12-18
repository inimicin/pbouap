/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap;

import db.dataModeler;
import db.dbHelper;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author A S U S
 */
public class Uap extends Application {
    Parent root;
    Scene scene;
    public static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        dataModeler modeler = new dataModeler();
        modeler.startConnection();
        
        dbHelper helper = new dbHelper();
        helper.createTable();
        
        root = FXMLLoader.load(getClass().getResource("/views/DaftarProduk.fxml"));
        scene = new Scene(root);
        this.stage = stage;
        this.stage.setScene(scene);
        this.stage.show();
        
//        changeScene("TambahProduk");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
