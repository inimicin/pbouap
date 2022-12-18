/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import db.dataModeler;
import db.dbHelper;
import java.sql.Connection;

/**
 *
 * @author A S U S
 */
public class Produk {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    private String id;
    private String nama_produk;
    private double harga;
    private int jumlah;
    private double diskon;

    public Produk(String id, String nama_produk, double harga, int jumlah, double diskon) {
        this.id = id;
        this.nama_produk = nama_produk;
        this.harga = harga;
        this.jumlah = jumlah;
        this.diskon = diskon;
    }
    
    public double hargaDiskon(){
        return 0;
    }

    /**
     * @return the nama_produk
     */
    public String getNama_produk() {
        return nama_produk;
    }

    /**
     * @param nama_produk the nama_produk to set
     */
    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    /**
     * @return the harga
     */
    public double getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }

    /**
     * @return the jumlah
     */
    public int getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * @return the diskon
     */
    public double getDiskon() {
        return diskon;
    }

    /**
     * @param diskon the diskon to set
     */
    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }
}
