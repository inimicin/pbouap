/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entity.Barang;
import entity.History;
import entity.Makanan;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import models.historyModel;
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
    private Button btn_addBarang;
    @FXML
    private TableView<Makanan> tbl_makanan;
    @FXML
    private TableView<Barang> tbl_barang;
    @FXML
    private Button btn_hapus;
    @FXML
    private Button btn_beli;
    @FXML
    private Button btn_detail;
    
    private String currentID;
    private ArrayList<Barang> listBarang;
    private int currentHistoryID;
    
    @FXML
    private TableView<History> tbl_history;
    @FXML
    private TableColumn<History, Integer> col_idHistory;
    @FXML
    private TableColumn<History, Double> col_totalHistory;
    @FXML
    private Button btn_hapusHistory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshData();
        
        tbl_barang.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if(tbl_barang.getSelectionModel().getSelectedItem() != null) {
                Barang barang = tbl_barang.getSelectionModel().getSelectedItem();
                this.currentID = barang.getId();
            }
        });
        
        tbl_history.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if(tbl_history.getSelectionModel().getSelectedItem() != null) {
                History history = tbl_history.getSelectionModel().getSelectedItem();
                this.currentHistoryID = history.getId();
            }
        });
    }
    
    public void refreshData(){
        barangModel datamodel = new barangModel();
        historyModel hismodel = new historyModel();
        try{
            ObservableList<Barang> data = datamodel.getAllBarang();
            col_namaBarang.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
            col_hargaBarang.setCellValueFactory(new PropertyValueFactory<>("harga"));
            col_jumlahBarang.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
            col_barcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
            col_expired.setCellValueFactory(new PropertyValueFactory<>("expired"));
            
            tbl_barang.setItems(null);
            tbl_barang.setItems(data);
            
            this.listBarang = new ArrayList<>(data);
            
            ObservableList<History> data2 = hismodel.getAllData();
            col_idHistory.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_totalHistory.setCellValueFactory(new PropertyValueFactory<>("total_harga"));
            
            tbl_history.setItems(null);
            tbl_history.setItems(data2);
            
            this.listBarang = new ArrayList<>(data);
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }

    @FXML
    private void addBarang(ActionEvent event) throws IOException {
        SceneController mainControl = new SceneController();
        
        mainControl.changeScene("TambahProduk");
    }

    @FXML
    private void hapusItem(ActionEvent event) {
        barangModel datamodel = new barangModel();
        datamodel.deleteBarang(this.currentID);
        
        System.out.println(currentID);

        refreshData();
    }

    @FXML
    private void beliItem(ActionEvent event) {
        double totalHarga = 0;
        for(int i = 0; i < listBarang.size(); i++){
            totalHarga += (listBarang.get(i).getHarga() - listBarang.get(i).getDiskon())*listBarang.get(i).getJumlah();
        }
        
        historyModel model = new historyModel();
        
        model.addHistory(totalHarga);
    }

    @FXML
    private void hapusHistory(ActionEvent event) {
        historyModel datamodel = new historyModel();
        
        datamodel.deleteHistory(currentHistoryID);
        refreshData();
    }
    
    
}
