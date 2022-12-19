/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import static controllers.DaftarProdukController.currentID;
import entity.Barang;
import entity.History;
import entity.Kategori;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import models.barangModel;
import models.historyModel;
import models.kategoriModel;

/**
 * FXML Controller class
 *
 * @author adiha
 */
public class DetailProdukController implements Initializable {

    @FXML
    private Text txt_nama;
    @FXML
    private Text txt_harga;
    @FXML
    private Text txt_jumlah;
    @FXML
    private Text txt_diskon;
    @FXML
    private Text txt_barcode;
    @FXML
    private Text txt_expired;
    @FXML
    private Button btn_tambah;
    @FXML
    private Button btn_hapus;
    @FXML
    private Button btn_batal;
    
    private String idProduk;
    @FXML
    private TableColumn<Kategori, Integer> col_id;
    @FXML
    private TableColumn<Kategori, String> col_nama;
    @FXML
    private TableView<Kategori> tbl_kategori;
    
    int currentCategoryID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        barangModel model = new barangModel();
        idProduk = DaftarProdukController.currentID;
        Barang barang = model.getBarang(idProduk);
        
        txt_nama.setText(barang.getNama_produk());
        txt_harga.setText(Double.toString(barang.getHarga()));
        txt_jumlah.setText(Integer.toString(barang.getJumlah()));
        txt_diskon.setText(Double.toString(barang.getDiskon()));
        txt_barcode.setText(barang.getBarcode());
        txt_expired.setText(barang.getExpired());
        
        refreshData();
        
        tbl_kategori.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if(tbl_kategori.getSelectionModel().getSelectedItem() != null) {
                Kategori kategori = tbl_kategori.getSelectionModel().getSelectedItem();
                this.currentCategoryID = kategori.getId();
            }
        });
    }

    @FXML
    private void batal(ActionEvent event) throws IOException {
        SceneController mainControl = new SceneController();
        
        mainControl.changeScene("DaftarProduk");
    }

    @FXML
    private void tambahKategori(ActionEvent event) throws IOException {
        SceneController changer = new SceneController();
        
        changer.changeScene("TambahKategori");
    }
    
    private void refreshData(){
        kategoriModel datamodel = new kategoriModel();
        
        try{
            ObservableList<Kategori> data = datamodel.getAllData();
            col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_nama.setCellValueFactory(new PropertyValueFactory<>("nama_kategori"));
            
            tbl_kategori.setItems(null);
            tbl_kategori.setItems(data);
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }

    @FXML
    private void hapusData(ActionEvent event) {
        kategoriModel datamodel = new kategoriModel();
        datamodel.deleteData(this.currentCategoryID);
        
        System.out.println(currentCategoryID);

        refreshData();
    }
}
