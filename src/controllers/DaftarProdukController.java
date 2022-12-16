/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entity.Barang;
import entity.Makanan;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.barangModel;
import uap.Uap;

/**
 * FXML Controller class
 *
 * @author A S U S
 */
public class DaftarProdukController implements Initializable {
    @FXML
    private TableColumn<?, ?> col_idProduk;
    @FXML
    private TableColumn<?, ?> col_namaMakanan;
    @FXML
    private TableColumn<?, ?> col_hargaMakanan;
    @FXML
    private TableColumn<?, ?> col_jumlahMakanan;
    @FXML
    private TableColumn<?, ?> col_dayaTahan;
    @FXML
    private Button btn_addMakanan;
    @FXML
    private TableColumn<Barang, String> col_namaBarang;
    @FXML
    private TableColumn<Barang, Double> col_hargaBarang;
    @FXML
    private TableColumn<Barang, Integer> col_jumlahBarang;
    @FXML
    private TableColumn<Barang, String> col_barcode;
    @FXML
    private TableColumn<Barang, String> col_expired;
    @FXML
    private TableColumn<Barang, ?> col_kategori;
    @FXML
    private Button btn_addBarang;
    @FXML
    private TableView<Makanan> tbl_makanan;
    @FXML
    private TableView<Barang> tbl_barang;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshData();
    }
    
    public void refreshData(){
        barangModel datamodel = new barangModel();
        try{
            ObservableList<Barang> data = datamodel.getAllBarang();
            col_namaBarang.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
            col_hargaBarang.setCellValueFactory(new PropertyValueFactory<>("harga"));
            col_jumlahBarang.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
            col_barcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
            col_expired.setCellValueFactory(new PropertyValueFactory<>("expired"));
            
            tbl_barang.setItems(null);
            tbl_barang.setItems(data);
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }

    @FXML
    private void addBarang(ActionEvent event) throws IOException {
        SceneController mainControl = new SceneController();
        
        mainControl.changeScene("TambahProduk");
    }    
}
