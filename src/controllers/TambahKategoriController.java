/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import entity.Kategori;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.kategoriModel;

/**
 * FXML Controller class
 *
 * @author adiha
 */
public class TambahKategoriController implements Initializable {

    @FXML
    private TextField txt_nama;
    @FXML
    private Button btn_tambah;
    @FXML
    private Button btn_back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveKategori(ActionEvent event) {
        Kategori kategori = new Kategori(txt_nama.getText());
        
        kategoriModel model = new kategoriModel();
        model.addData(kategori, DaftarProdukController.currentID);
        btn_back.fire();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        SceneController changer = new SceneController();
        changer.changeScene("DetailProduk");
    }
    
}
