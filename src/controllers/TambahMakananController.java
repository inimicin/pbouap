/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import entity.Makanan;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.barangModel;
import models.makananModel;

/**
 * FXML Controller class
 *
 * @author adiha
 */
public class TambahMakananController implements Initializable {

    @FXML
    private TextField txt_nama;
    @FXML
    private TextField txt_harga;
    @FXML
    private TextField txt_jumlah;
    @FXML
    private TextField txt_diskon;
    @FXML
    private TextField txt_dayatahan;
    @FXML
    private Button btn_tambah;
    @FXML
    private TextField txt_id;
    @FXML
    private Button btn_batal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tambahProduk(ActionEvent event) {
        Makanan makanan = new Makanan(Integer.parseInt(txt_dayatahan.getText().trim()),
                                        txt_id.getText().trim(),
                                        txt_nama.getText().trim(),
                                        Double.parseDouble(txt_harga.getText().trim()),
                                        Integer.parseInt(txt_jumlah.getText().trim()),
                                        Double.parseDouble(txt_diskon.getText().trim())
                                    );
        
        makananModel model = new makananModel();
        model.addBarang(makanan, txt_id.getText().trim());
        btn_batal.fire();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        SceneController changer = new SceneController();
        changer.changeScene("DaftarProduk");
    }
    
}
