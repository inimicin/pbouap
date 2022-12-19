/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import db.dataModeler;
import entity.Barang;
import entity.Makanan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author adiha
 */
public class makananModel {
    Connection conn;

    public makananModel() {
        this.conn = dataModeler.conn;
    }
    
    public ObservableList<Makanan> getAllData(){
        ObservableList<Makanan> data = FXCollections.observableArrayList();
        
        try {
            String sql = "SELECT produk.nama_produk, produk.harga, produk.jumlah, produk.diskon, makanan.daya_tahan, produk.id_produk"
                       + " FROM produk, makanan"
                       + " WHERE produk.id_produk = makanan.id_produk;";
            
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while(rs.next()){
                data.add(new Makanan(rs.getInt(5), rs.getString(6), rs.getString(1), rs.getDouble(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        
        return data;
    }
    
    public void addBarang(Makanan makanan, String newID){
        PreparedStatement state = null;
        String queryProduk, queryMakanan;
        
        try{
            queryProduk = "INSERT INTO \"produk\"\n" +
                          " (\"id_produk\", \"nama_produk\", \"harga\", \"jumlah\", \"diskon\")\n" +
                          " VALUES (?, ?, ?, ?, ?);";
            
            queryMakanan = "INSERT INTO \"makanan\"\n" +
                          " (\"daya_tahan\", \"id_produk\")\n" +
                          " VALUES (?, ?);";

            state = this.conn.prepareStatement(queryProduk);
            state.setString(1, newID);
            state.setString(2, makanan.getNama_produk());
            state.setDouble(3, makanan.getHarga());
            state.setInt(4, makanan.getJumlah());
            state.setDouble(5, makanan.getDiskon());
            state.execute();
            
            state = this.conn.prepareStatement(queryMakanan);
            state.setInt(1, makanan.getDayaTahan());
            state.setString(2, newID);
            state.execute();
            
            System.out.println("Berhasil Ditambahkan!");
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
    
    public void delete(String id){
        PreparedStatement state = null;
        String queryProduk, queryMakanan;
        
        try{
            queryProduk = "DELETE FROM makanan WHERE id_produk='".concat(id).concat("';)");

            state = this.conn.prepareStatement(queryProduk);
            state.execute();
            
            queryMakanan = "DELETE FROM produk WHERE id_produk='".concat(id).concat("';");
            state = this.conn.prepareStatement(queryMakanan);
            state.execute();
            
            System.out.println("Berhasil Dihapus!");
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
}
